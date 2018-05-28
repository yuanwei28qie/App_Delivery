package com.microsilver.mrcard.basicservice.controller;

import com.microsilver.mrcard.basicservice.dto.*;
import com.microsilver.mrcard.basicservice.model.*;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.*;
import com.microsilver.mrcard.basicservice.utils.MapDistance;
import com.microsilver.mrcard.basicservice.utils.RandomLngLat;
import com.microsilver.mrcard.basicservice.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Api(value = "/api/user", description = "用户基础API")
@Controller
@RequestMapping(value = "/api/user")
@SuppressWarnings("unchecked")
@Transactional
public class UserController extends BaseController {
	private final UserService userService;

	private final StringRedisTemplate stringRedisTemplate;

	private final RedisTemplate redisTemplate;

	private final SuperDeliveryInfoService superDeliveryInfoService;

	private final UserCarriageDispatchService userCarriageDispatchService;

	private final OrderService orderService;

	private final FinanceService financeService;

	@Autowired
	public UserController(UserService userService, StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate, SuperDeliveryInfoService superDeliveryInfoService, UserCarriageDispatchService userCarriageDispatchService, OrderService orderService, FinanceService financeService) {
		this.userService = userService;
		this.stringRedisTemplate = stringRedisTemplate;
		this.redisTemplate = redisTemplate;
		this.superDeliveryInfoService = superDeliveryInfoService;
		this.userCarriageDispatchService = userCarriageDispatchService;
		this.orderService = orderService;
		this.financeService = financeService;
	}


	@ApiOperation(value = "用户注册(手机号验证码注册)", httpMethod = "POST")
	@PostMapping(value = "/userRegister", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserSimpleDto> userRegister(
			@RequestBody UserRegisterVo userRegisterVo
	) {
		RespBaseDto<UserSimpleDto> result = new RespBaseDto<>();
		UserSimpleDto userSimpleDto = new UserSimpleDto();
		try {
			Long mobile = userRegisterVo.getMobile();
			Integer checkCode = userRegisterVo.getCheckCode();
			String password = userRegisterVo.getPassword();
			if (mobile != null && checkCode!=null && password!=null && !password.equals("")) {
				FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile+"");
				if (selectUserByMobile != null) {
					result.setData(new UserSimpleDto());
					result.setMessage(EWarning.MobileRegistered.getName());
					result.setState(EWarning.MobileRegistered.getValue());
				} else {
					//对比验证码
					//String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile+"");
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
					if(mobileCheckCode!=null){
						int redisCheckCode = mobileCheckCode.getCheckCode();
						short type = mobileCheckCode.getType();
						if (type != 1) {
							result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
							result.setState(EWarning.CheckCodeTypeNotSame.getValue());
							result.setData(new UserSimpleDto());
						} else {
							int valueOf = redisCheckCode;
							int valueOf2 = checkCode;
							if (valueOf != valueOf2) {
								result.setMessage(EWarning.CheckCodeError.getName());
								result.setState(EWarning.CheckCodeError.getValue());
								result.setData(new UserSimpleDto());
							} else {
								//验证码相同,则创建一个用户对象
								FxSdUserMember fxSdUserMember = new FxSdUserMember();
								//给用户默认设置一个密码
								fxSdUserMember.setPwd(DigestUtils.md5Hex(password));
								fxSdUserMember.setMobile(mobile + "");
								fxSdUserMember.setPwd(DigestUtils.md5Hex(password));
								String longMobile = mobile + "";
								fxSdUserMember.setNickname(longMobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
								//默认信用等级分80
								fxSdUserMember.setServiceScore(5.0);
								fxSdUserMember.setLevelScore(5.0);
								fxSdUserMember.setStatus((byte) 1);
								String s = String.valueOf(System.currentTimeMillis() / 1000);
								fxSdUserMember.setCreatetime(Integer.parseInt(s));
								userService.getIdentityId(fxSdUserMember);
								userSimpleDto.setUserId(fxSdUserMember.getId());
								userSimpleDto.setStatus(1);
								result.setData(userSimpleDto);
								result.setMessage("用户添加成功");
								result.setState(200);
								Long id = fxSdUserMember.getId();
								//注册成功之后向财务生成一个该用户的信息
								FxSdFinanceCustomer customer = new FxSdFinanceCustomer();
								customer.setMobile(mobile + "");
								customer.setUserType((byte) 1);
								financeService.insertFinaceCustomer(customer);
								//查询该手机号在邀请表中是否存在,存在就属于被邀请对象,不存在则正常注册无推荐奖金.
								//如果是,那么则修改status状态0变出1;0表示被邀请人邀请的用户(预注册),1是表示被邀请人已经注册完成,但是未发放奖金,2是表示被邀请人已经注册完成,已发送完奖金;
								FxSdUserPreReg checkIsInvitation = userService.checkIsInvitation(mobile);
								if (checkIsInvitation != null) {
									if (checkIsInvitation.getStatus() == 0) {
										checkIsInvitation.setStatus((short) 1);
										userService.updateStatus(checkIsInvitation.getRefereeId(), fxSdUserMember);
									}
								}
							}
						}
					}else{
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(new UserSimpleDto());
					}
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new UserSimpleDto());
			}
		} catch (Exception ex) {
			logger.error("UserRegister error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}

		return result;

	}

	@ApiOperation(value = "用户修改密码(新密码旧密码)和忘记密码(手机验证码)", httpMethod = "POST")
	@PostMapping(value = "/updatePwd", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserSimpleDto> updatePwd(
			@RequestBody EditPwdVo userEditPwdVo
	) {
		RespBaseDto<UserSimpleDto> result = new RespBaseDto<>();
		UserSimpleDto userSimpleDto = new UserSimpleDto();
		Long mobile = userEditPwdVo.getMobile();
		String code = userEditPwdVo.getCode();
		String type = userEditPwdVo.getType().toString();
		String password = userEditPwdVo.getNewPwd();
		try {
			if (mobile != null) {
				FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile+"");
				if (selectUserByMobile != null) {
					//type类型是1则是修改密码,此刻的coke是旧密码
					if (type.equals("1") && password != null) {
						if (DigestUtils.md5Hex(code).equals(selectUserByMobile.getPwd())) {
							selectUserByMobile.setPwd(DigestUtils.md5Hex(password));
							userService.updatePwd(selectUserByMobile, mobile+"");
							userSimpleDto.setUserId(selectUserByMobile.getId());
							result.setMessage("Ok");
							result.setState(200);
							result.setData(userSimpleDto);
						} else {
							result.setMessage(EWarning.PasswordError.getName());
							result.setState(EWarning.PasswordError.getValue());
							result.setData(new UserSimpleDto());
						}
					}
					//type类型是2则是忘记密码,此刻的coke是验证码
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
					if(mobileCheckCode!=null){
						int redisCheckCode = mobileCheckCode.getCheckCode();
						short typeCheckCode = mobileCheckCode.getType();
						if ( type.equals("2") && password != null && typeCheckCode==4) {
							if (Integer.parseInt(code) == redisCheckCode) {
								selectUserByMobile.setPwd(DigestUtils.md5Hex(password));
								userService.updatePwd(selectUserByMobile, mobile+"");
								userSimpleDto.setUserId(selectUserByMobile.getId());
								result.setMessage("ok");
								result.setState(200);
								result.setData(userSimpleDto);
							} else {
								result.setMessage(EWarning.CheckCodeError.getName());
								result.setState(EWarning.CheckCodeError.getValue());
								result.setData(new UserSimpleDto());
							}
						}
					}else{
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(new UserSimpleDto());
					}
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new UserSimpleDto());
				}
			}

		} catch (Exception e) {
			logger.error("UpDatePwd error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}

		return result;

	}

	@ApiOperation(value = "用户登陆(手机号,验证码登陆)", httpMethod = "POST")
	@PostMapping(value = "/userQuickLogin", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserDto> userQuickLogin(@RequestBody RegisterOrLoginVo userQuickRegisterVo) {
		RespBaseDto<UserDto> result = new RespBaseDto<>();
		Long mobile = userQuickRegisterVo.getMobile();
		Integer checkCode = userQuickRegisterVo.getCheckCode();
		if (mobile == null ) {
			result.setState(EWarning.PhoneIsNull.getValue());
			result.setMessage(EWarning.PhoneIsNull.getName());
			result.setData(new UserDto());
			return result;
		}
		if (checkCode == null ) {
			result.setState(EWarning.CheckCodeIsNull.getValue());
			result.setMessage(EWarning.CheckCodeIsNull.getName());
			result.setData(new UserDto());
			return result;
		}
		FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile+"");
		if (selectUserByMobile == null) {
			result.setState(EWarning.NonExistent.getValue());
			result.setMessage(EWarning.NonExistent.getName());
			result.setData(new UserDto());
			return result;
		}
		//String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile+"");
		MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
		if(mobileCheckCode==null){
			result.setMessage(EWarning.CheckCode_Overdue.getName());
			result.setState(EWarning.CheckCode_Overdue.getValue());
			result.setData(new UserDto());
			return result;
		}
		int redisCheckCode = mobileCheckCode.getCheckCode();
		short typeCheckCode = mobileCheckCode.getType();
		if (typeCheckCode!=2) {
			result.setState(EWarning.CheckCodeTypeNotSame.getValue());
			result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
			result.setData(new UserDto());
			return result;
		}
		if (checkCode!=redisCheckCode) {
			result.setState(EWarning.CheckCodeError.getValue());
			result.setMessage(EWarning.CheckCodeError.getName());
			result.setData(new UserDto());
			return result;
		}
		//登陆成功
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		UserDto userDto = new UserDto();
		userDto.setUserId(selectUserByMobile.getId());
		userDto.setToken(s);
		//保存到redis中
		//stringRedisTemplate.opsForValue().set("userId:"+selectUserByMobile.getId()+"" , s, 60 * 60 *24, TimeUnit.SECONDS);
		TokenType tokenType = new TokenType();
		tokenType.setAppType((short)1);
		tokenType.setToken(s);
		tokenType.setUserId(selectUserByMobile.getId().intValue());
		redisTemplate.opsForValue().set(selectUserByMobile.getId().intValue()+""+1,tokenType,60 * 60 *24, TimeUnit.SECONDS);
		//添加token到用户
		selectUserByMobile.setToken(s);
		userService.updateToken(selectUserByMobile);
		result.setData(userDto);
		result.setMessage("ok");
		result.setState(200);
		return result;
	}

	@ApiOperation(value = "用户登陆(手机号,密码登陆)", httpMethod = "POST")
	@PostMapping(value = "/userLogin", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserDto> userLogin(
			@RequestBody LoginVo userLoginVo
	) {
		RespBaseDto<UserDto> result = new RespBaseDto<>();
		Long mobile = userLoginVo.getMobile();
		String password = userLoginVo.getPassword();
		try {
			if (mobile != null && password != null && !password.equals("")) {
				FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile+"");
				if (selectUserByMobile != null) {
					if (selectUserByMobile.getPwd().equals(DigestUtils.md5Hex(password))) {
						UUID uuid = UUID.randomUUID();
						String s = uuid.toString();
						//保存到redis中
						TokenType tokenType = new TokenType();
						tokenType.setAppType((short)1);
						tokenType.setToken(s);
						tokenType.setUserId(selectUserByMobile.getId().intValue());
						redisTemplate.opsForValue().set(selectUserByMobile.getId().intValue()+""+1,tokenType,60 * 60 *24, TimeUnit.SECONDS);
						UserDto userDto = new UserDto();
						userDto.setUserId(selectUserByMobile.getId());
						userDto.setToken(s);
						//添加token到用户
						selectUserByMobile.setToken(s);
						userService.updateToken(selectUserByMobile);
						result.setData(userDto);
						result.setMessage("ok");
						result.setState(200);
					} else {
						result.setMessage(EWarning.PasswordError.getName());
						result.setState(EWarning.PasswordError.getValue());
						result.setData(new UserDto());
					}
				} else {
					result.setMessage(EWarning.MobileNotRegister.getName());
					result.setState(EWarning.MobileNotRegister.getValue());
					result.setData(new UserDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new UserDto());
			}
		} catch (Exception e) {
			logger.error("userLogin error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
			result.setData(new UserDto());
		}

		return result;
	}

	@ApiOperation(value = "用户id返回用户信息", httpMethod = "POST")
	@PostMapping(value = "/getUserInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto< UserDto> getUserInfo(
			@RequestBody UserGetInfo userGetInfo
	) {
		Integer userId = userGetInfo.getId();
		RespBaseDto<UserDto> result = new RespBaseDto<>();
		UserDto userDto = new UserDto();
		System.out.println(userId+"---");
		try {
			if (userId == null ) {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new UserDto());
			} else {
				FxSdUserMember selectUserByMobile = userService.selectUserByUserId(userId+"");
				if (selectUserByMobile != null) {
					userDto.setUserId(userId.longValue());
					userDto.setAvatar(selectUserByMobile.getAvatar());
					//userDto.setRefereeId(selectUserByMobile.getReferee().intValue());
					userDto.setMobile(Long.parseLong(selectUserByMobile.getMobile()));
					userDto.setCreateTime(selectUserByMobile.getCreatetime().longValue());
					userDto.setNickName(selectUserByMobile.getNickname());
					userDto.setToken(selectUserByMobile.getToken());
					//财务id
					//userDto.setFinanceId();
					result.setData(userDto);
					result.setMessage("Ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new UserDto());
				}
			}
		} catch (Exception e) {
			logger.error("getUserInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
			result.setData(new UserDto());
		}
		return result;
	}

	@ApiOperation(value = "修改用户手机", httpMethod = "POST")
	@PostMapping(value = "/updateUserPhone", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto< UserDto> updateUserPhone(
			@RequestBody UserEditPhoneVo userEditPhoneVo) {
		RespBaseDto<UserDto> result = new RespBaseDto<>();
		Long oldPhoneNumber = userEditPhoneVo.getOldPhoneNumber();
		Integer oldCheckCode = userEditPhoneVo.getOldCheckCode();
		Long newPhoneNumber = userEditPhoneVo.getNewPhoneNumber();
		Integer newCheckCode = userEditPhoneVo.getNewCheckCode();
		UserDto userDto = new UserDto();
		try {
			if (oldPhoneNumber != null
					&& oldCheckCode != null
					&& newPhoneNumber != null
					&& newCheckCode != null ) {
				FxSdUserMember selectUserByMobile = userService.selectUserByMobile(oldPhoneNumber+"");
				if (selectUserByMobile != null) {
					//String redisCheckCode = stringRedisTemplate.opsForValue().get(oldPhoneNumber+"");
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(oldPhoneNumber+"");
					if(mobileCheckCode!=null){
						int redisCheckCode = mobileCheckCode.getCheckCode();
						short typeCheckCode = mobileCheckCode.getType();
						if (typeCheckCode == 4) {
							if (oldCheckCode == redisCheckCode) {
								FxSdUserMember selectUserByMobile2 = userService.selectUserByMobile(newPhoneNumber+"");
								if (selectUserByMobile2 == null) {
									MobileCheckCode mobileCheckCode2 = (MobileCheckCode) redisTemplate.opsForValue().get(oldPhoneNumber+"");
									if(mobileCheckCode2!=null){
										int redisNewPhoneCheckCode = mobileCheckCode2.getCheckCode();
										short typeCheckCodeNew = mobileCheckCode2.getType();
										if (redisNewPhoneCheckCode == newCheckCode && typeCheckCodeNew==4) {
											//通过旧手机查询到记录并修改为修手机
											selectUserByMobile.setMobile(newPhoneNumber+"");
											String s = newPhoneNumber + "";
											selectUserByMobile.setNickname(s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
											//写库
											userService.updatePhone(selectUserByMobile, oldPhoneNumber.toString());
											userDto.setMobile(Long.parseLong(selectUserByMobile.getMobile()));
											userDto.setAvatar(selectUserByMobile.getAvatar());
											userDto.setNickName(selectUserByMobile.getNickname());
											//财务id数据库没有
											//userDto.setFinanceId(selectUserByMobile.get);
											userDto.setToken(selectUserByMobile.getToken());
											userDto.setCreateTime(selectUserByMobile.getCreatetime().longValue());
											//userDto.setStatus((int)selectUserByMobile.getStatus());
											//userDto.setRefereeId(selectUserByMobile.getReferee().intValue());
											result.setData(userDto);
											result.setMessage("Ok");
											result.setState(200);
										} else {
											result.setMessage(EWarning.CheckCodeError.getName());
											result.setState(EWarning.CheckCodeError.getValue());
											result.setData(new UserDto());
										}
									}else{
										result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
										result.setState(EWarning.CheckCodeTypeNotSame.getValue());
										result.setData(new UserDto());
									}
								} else {
									result.setMessage(EWarning.MobileRegistered.getName());
									result.setState(EWarning.MobileRegistered.getValue());
									result.setData(new UserDto());
								}
							} else {
								result.setMessage(EWarning.CheckCodeError.getName());
								result.setState(EWarning.CheckCodeError.getValue());
								result.setData(new UserDto());
							}
						} else {
							result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
							result.setState(EWarning.CheckCodeTypeNotSame.getValue());
							result.setData(new UserDto());
						}
					}else{
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(new UserDto());
					}
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new UserDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new UserDto());
			}

		} catch (Exception e) {
			logger.error("UpdateUserPhone error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "新增用户常用地址", httpMethod = "POST")
	@PostMapping(value = "/addUserAddress", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<FxSdUserAddress> addUserAddress(
			@RequestBody UserAddAddressVo userAddAddressVo) {
		RespBaseDto<FxSdUserAddress> result = new RespBaseDto<>();
		Long mobile = userAddAddressVo.getMobile();
		String address = userAddAddressVo.getAddress();
		Integer area = userAddAddressVo.getArea();
		Integer city = userAddAddressVo.getCity();
		Short isDefault = userAddAddressVo.getIsDefault();
		Double lat = userAddAddressVo.getLat();
		Double lng = userAddAddressVo.getLng();
		Integer province = userAddAddressVo.getProvince();
		Integer userId = userAddAddressVo.getUserId();
		String realName = userAddAddressVo.getRealName();
		String street = userAddAddressVo.getStreet();
		try {
			FxSdUserAddress fxSdUserAddress = new FxSdUserAddress();
			if (mobile == null  || realName == null || province == null
					|| city == null  || area == null
					|| street == null  || address == null || address.equals("")
					|| lat == null  || lng == null
					|| isDefault == null  || userId == null ) {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			} else {
				FxSdUserMember selectUserByMobile = userService.selectUserByUserId(userId+"");
				if (selectUserByMobile != null) {
					fxSdUserAddress.setAddress(address);
					fxSdUserAddress.setProvince(province+"");
					fxSdUserAddress.setArea(area+"");
					fxSdUserAddress.setCity(city+"");
					fxSdUserAddress.setLat(lat+"");
					fxSdUserAddress.setLng(lng+"");
					fxSdUserAddress.setMemberId(userId.longValue());
					fxSdUserAddress.setMobile(mobile+"");
					fxSdUserAddress.setRealname(realName);
					fxSdUserAddress.setStreet(street);
					//判断是否是默认地址
					if (isDefault==1) {
						//查询所有订单
						List<FxSdUserAddress> listAddress = userService.selectUserAllAddress(userId+"");
						if (listAddress != null) {

							ergodicDefaultAddress(listAddress);
							//写入数据库
							editAddressIfIsDefault( fxSdUserAddress);
						} else {
							//写入数据库
							editAddressIfIsDefault( fxSdUserAddress);
						}
					} else {
						//查询数据库中是否有默认地址
						//查询所有订单
						List<FxSdUserAddress> listAddress = userService.selectUserAllAddress(userId+"");
						if (listAddress != null) {
							for (FxSdUserAddress addressDefault : listAddress) {
								Byte isDefault2 = addressDefault.getIsdefault();
								//找到默认值为1的地址修改为0
								if (isDefault2 == 1) {
									//有默认地址
									fxSdUserAddress.setIsdefault((byte) 0);
									userService.insertReturnId(fxSdUserAddress);
								}
							}
						} else {
							editAddressIfIsDefault(fxSdUserAddress);
						}

					}

					result.setData(fxSdUserAddress);
					result.setMessage("Ok");
					result.setState(200);

				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new FxSdUserAddress());
				}

			}
		} catch (Exception e) {
			logger.error("addUserAddress error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	private void editAddressIfIsDefault( FxSdUserAddress fxSdUserAddress) {
		fxSdUserAddress.setIsdefault((byte) 1);
		userService.insertReturnId(fxSdUserAddress);
	}

	private void ergodicDefaultAddress(List<FxSdUserAddress> listAddress) {
		for (FxSdUserAddress addressDefault : listAddress) {
			Byte isDefault2 = addressDefault.getIsdefault();
			//找到默认值为1的地址修改为0
			if (isDefault2 == 1) {
				addressDefault.setIsdefault((byte) 0);
				userService.updateAddress(addressDefault, addressDefault.getId());
			}
		}
	}

	@ApiOperation(value = "修改用户常用地址", httpMethod = "POST")
	@ResponseBody
	@PostMapping(value = "/updateUserAddress", produces = "application/json;charset=UTF-8")
	public RespBaseDto<FxSdUserAddress> updateUserAddress(
			@RequestBody UserAddressAddVo userAddressAddVo) {
		RespBaseDto<FxSdUserAddress> result = new RespBaseDto<>();
		Integer addressId = userAddressAddVo.getAddressId();
		Long mobile = userAddressAddVo.getMobile();
		String address = userAddressAddVo.getAddress();
		Integer area = userAddressAddVo.getArea();
		Integer city = userAddressAddVo.getCity();
		Short isDefault = userAddressAddVo.getIsDefault();
		Double lat = userAddressAddVo.getLat();
		Double lng = userAddressAddVo.getLng();
		Integer province = userAddressAddVo.getProvince();
		Integer userId = userAddressAddVo.getUserId();
		String realName = userAddressAddVo.getRealName();
		String street = userAddressAddVo.getStreet();
		try {
			FxSdUserAddress fxSdUserAddress = new FxSdUserAddress();
			if (mobile != null && realName != null && province != null && city != null && area != null && street != null
					&& address != null && lat != null && lng != null && userId != null && addressId != null) {
				FxSdUserAddress selectMemberAddress = userService.selectMemberAddress(userId+"", addressId+"");
				if (selectMemberAddress != null) {
					fxSdUserAddress.setMobile(mobile+"");
					fxSdUserAddress.setRealname(realName);
					fxSdUserAddress.setProvince(province+"");
					fxSdUserAddress.setCity(city+"");
					fxSdUserAddress.setArea(area+"");
					fxSdUserAddress.setAddress(address);
					fxSdUserAddress.setLat(lat+"");
					fxSdUserAddress.setLng(lng+"");
					fxSdUserAddress.setMemberId(userId.longValue());
					fxSdUserAddress.setStreet(street);
					fxSdUserAddress.setId(addressId);
					//System.out.println(fxSdUserAddress.toString());
					//判断是否用户地址是默认地址
					if (isDefault==1) {
						//查询所有订单
						List<FxSdUserAddress> listAddress = userService.selectUserAllAddress(userId+"");
						if (listAddress != null) {
							ergodicDefaultAddress(listAddress);
						}
						//写入数据库
						fxSdUserAddress.setIsdefault((byte) 1);
						userService.updateAddress(fxSdUserAddress, addressId);
					} else {
						//FxSdUserAddress selectMemberAddress = userService.selectMemberAddress(userId,addressId);
						if (selectMemberAddress.getIsdefault() == 0) {
							fxSdUserAddress.setIsdefault((byte) 0);
							userService.updateAddress(fxSdUserAddress, addressId);
						} else {
							fxSdUserAddress.setIsdefault((byte) 0);
							userService.updateAddress(fxSdUserAddress, addressId);
							//数据库中无默认地址了,需要设置
							//没有默认地址则设置第一条数据为默认地址
							List<FxSdUserAddress> list = userService.selectUserByMemberIdAndNotId(userId+"", addressId+"");
							if (list != null) {
								FxSdUserAddress fxSdUserAddress2 = list.get(0);
								fxSdUserAddress2.setIsdefault((byte) 1);
								userService.updateAddress(fxSdUserAddress2, fxSdUserAddress2.getId());
							}
						}
					}
					result.setMessage("OK");
					result.setState(200);
					result.setData(fxSdUserAddress);
				} else {
					result.setMessage(EWarning.NoUserOfAddress.getName());
					result.setState(EWarning.NoUserOfAddress.getValue());
					result.setData(new FxSdUserAddress());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new FxSdUserAddress());
			}
		} catch (Exception e) {
			logger.error("updateUserAddress error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
			result.setData(new FxSdUserAddress());
		}
		return result;
	}
	@ApiOperation(value = "删除用户常用地址", httpMethod = "POST")
	@ResponseBody
	@PostMapping(value = "/deleteUserAddress", produces = "application/json;charset=UTF-8")
	public RespBaseDto<List<FxSdUserAddress>> deleteUserAddress(
			@RequestBody UserDelAddressVo userDelAddressVo
	) {
		RespBaseDto<List<FxSdUserAddress>> result = new RespBaseDto<>();
		Integer userId = userDelAddressVo.getId();
		Integer addressId = userDelAddressVo.getAddressId();
		List<FxSdUserAddress> list = new ArrayList<>();
		try {
			if (userId != null  && addressId!=null) {
				FxSdUserAddress selectMemberAddress = userService.selectMemberAddress(userId+"", addressId+"");
				if (selectMemberAddress != null) {
					//删除之后,当用户的默认地址没有,则当第一条地址设置为默认地址
					userService.deleteAddress(addressId+"");
					Map<Integer, Byte> map = new HashMap<>();
					list = userService.selectUserAllAddress(userId+"");
					if(list!=null){
						for (FxSdUserAddress fxSdUserAddress : list) {
							map.put(fxSdUserAddress.getId(), fxSdUserAddress.getIsdefault());
						}
						if (map.containsValue((byte) 1)) {
							result.setMessage("OK");
							result.setState(200);
							result.setData(list);
						} else {
							FxSdUserAddress fxSdUserAddress = list.get(0);
							fxSdUserAddress.setIsdefault((byte) 1);
							userService.updateAddress(fxSdUserAddress, fxSdUserAddress.getId());
							List<FxSdUserAddress> listAddress = userService.selectUserAllAddress(userId+"");
							result.setMessage("OK");
							result.setState(200);
							result.setData(listAddress);
						}
					}else{
						result.setMessage(EWarning.UserNoAddress.getName());
						result.setState(EWarning.NoUserOfAddress.getValue());
						result.setData(list);
					}
				} else {
					result.setMessage(EWarning.NoUserOfAddress.getName());
					result.setState(EWarning.NoUserOfAddress.getValue());
					result.setData(list);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(list);
			}
		} catch (Exception e) {
			logger.error("deleteUserAddress error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "设置用户常用默认地址", httpMethod = "POST")
	@PostMapping(value = "/setUpDefaultAddress", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<FxSdUserAddress> setUpDefaultAddress(
			@RequestBody UserDelAddressVo userDelAddressVo
	) {
		RespBaseDto<FxSdUserAddress> result = new RespBaseDto<>();
		Integer userId = userDelAddressVo.getId();
		Integer addressId = userDelAddressVo.getAddressId();
		try {
			if (userId != null && addressId != null ) {
				FxSdUserAddress fxSdUserAddress1 = userService.selectMemberAddress(userId+"", addressId+"");
				if(fxSdUserAddress1!=null){
					List<FxSdUserAddress> list = userService.selectUserAllAddress(userId+"");
					if(list!=null){
						for (FxSdUserAddress address : list) {
							if (address.getIsdefault() == 1) {
								address.setIsdefault((byte) 0);
								userService.updateAddress(address, address.getId());
							}
						}
					}
					FxSdUserAddress fxSdUserAddress = new FxSdUserAddress();
					fxSdUserAddress.setIsdefault((byte) 1);
					userService.updateAddress(fxSdUserAddress, Integer.valueOf(addressId));
					result.setMessage("ok");
					result.setState(200);
					result.setData(fxSdUserAddress);
				}else{
					result.setMessage(EWarning.NoUserOfAddress.getName());
					result.setState(EWarning.NoUserOfAddress.getValue());
					result.setData(new FxSdUserAddress());
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new FxSdUserAddress());
			}
		} catch (Exception e) {
			logger.error("setUpDefaultAddress error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
			result.setData(new FxSdUserAddress());
		}
		return result;
	}


	@ApiOperation(value = "查询常用地址集合", httpMethod = "POST")
	@PostMapping(value = "/searchUserAddressList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<FxSdUserAddress>> searchUserAddressList(
			@RequestBody UserGetInfo userGetInfo
	) {
		RespBaseDto<List<FxSdUserAddress>> result = new RespBaseDto<>();
		Integer userId = userGetInfo.getId();
		List<FxSdUserAddress> listAddress = new ArrayList<>();
		try {
			if (userId != null) {
				List<FxSdUserAddress> list = userService.selectUserAllAddress(userId+"");
				if(list!=null){

					result.setData(list);
					result.setMessage("ok");
					result.setState(200);
				}else{
					result.setData(listAddress);
					result.setMessage(EWarning.NoUserOfAddress.getName());
					result.setState(EWarning.NoUserOfAddress.getValue());
				}
			}else{
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(listAddress);
			}
		} catch (Exception e) {
			logger.error("searchUserAddressList error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "用户上传头像", httpMethod = "POST")
	@PostMapping(value = "/uploadUserHeadImg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserAvatarDto> uploadUserHeadImg(
			@RequestBody AvatarVo userAvatarVo
	) {
		RespBaseDto<UserAvatarDto> result = new RespBaseDto<>();
		Integer userId = userAvatarVo.getUserId();
		String avatar = userAvatarVo.getUserAvartarUrl();
		UserAvatarDto userAvatarDto = new UserAvatarDto();
		try {
			if (userId != null && avatar != null  && !avatar.equals("")) {
				FxSdUserMember user = userService.selectUserByUserId(userId+"");
				if (user != null) {
					user.setAvatar(avatar);
					userService.updateAvatar(user);
					userAvatarDto.setId(user.getId());
					userAvatarDto.setUserAvatarUrl(avatar);
					result.setMessage("ok");
					result.setState(200);
					result.setData(userAvatarDto);
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(userAvatarDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(userAvatarDto);
			}
		} catch (Exception e) {
			logger.error("UploadUserHeadImg error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "用户昵称修改", httpMethod = "POST")
	@PostMapping(value = "/updateUserNickname", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<UserNickNameDto> updateUserNickname(
			@RequestBody UserNickNameVo userNickNameVo
	) {
		RespBaseDto<UserNickNameDto> result = new RespBaseDto<>();
		Integer userId = userNickNameVo.getUserId();
		String nickName = userNickNameVo.getUserNickName();
		UserNickNameDto userNickNameDto = new UserNickNameDto();
		try {
			if (userId != null && nickName != null  && !nickName.equals("")) {
				FxSdUserMember user = userService.selectUserByUserId(userId+"");
				if (user != null) {
					user.setNickname(nickName);
					userService.updateNickName(user);
					userNickNameDto.setUserId(user.getId());
					userNickNameDto.setNickName(nickName);
					result.setMessage("ok");
					result.setState(200);
					result.setData(userNickNameDto);
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(userNickNameDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(userNickNameDto);
			}
		} catch (Exception e) {
			logger.error("updateUserNickname error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "用户首页获取周围骑手信息", httpMethod = "POST")
	@PostMapping(value = "/getDeliversPosition", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<SuperDeliveryPositionDto>> getDeliversPosition(
			@RequestBody DeliveryInfoVo deliveryInfoVo
	)  {
		RespBaseDto<List<SuperDeliveryPositionDto>> result = new RespBaseDto<>();
		Integer areaCode = deliveryInfoVo.getAreaCode();
		Double lat = deliveryInfoVo.getLat();
		Double lng = deliveryInfoVo.getLng();
		//存放骑手的List
		List<SuperDeliveryPositionDto> list = new ArrayList<>();
		try {
			if(lat!=null&&lng!=null&&areaCode!=null){
				//查询出fx_sd_user_deliver_additional所有的经度纬度
				List<FxSdUserDeliverAdditional> listSuperDelivery = superDeliveryInfoService.selectSuperDelivery();
				if (listSuperDelivery != null) {
					//通过区域编号查询到该区域编号的默认公里数;
					FxSdSysCarriageDispatch selectDispatchByAreaId = userCarriageDispatchService.selectDispatchByAreaId(areaCode+"");
					if(selectDispatchByAreaId==null){
						SuperDeliveryPositionDto dto = new SuperDeliveryPositionDto();
						list.add(dto);
					}else{
						for (FxSdUserDeliverAdditional fxSdUserDeliverAdditional : listSuperDelivery) {
							//骑手于用户之间的距离
							double distance = Double.valueOf(MapDistance.getDistance(lat+"", lng+"",
									fxSdUserDeliverAdditional.getLat(), fxSdUserDeliverAdditional.getLng()));
							Byte baseMileage = selectDispatchByAreaId.getBaseMileage();
							double doubleValue = baseMileage.doubleValue() * 1000;
							if(distance<=doubleValue){
								//小于默认公里数
								//骑手未接单
								if (fxSdUserDeliverAdditional.getIsWork()==0) {
									SuperDeliveryPositionDto superDeliveryPositionDto = new SuperDeliveryPositionDto();
									superDeliveryPositionDto.setSuperDeliveryId(fxSdUserDeliverAdditional.getDeliverId());
									superDeliveryPositionDto.setLat(fxSdUserDeliverAdditional.getLat());
									superDeliveryPositionDto.setLng(fxSdUserDeliverAdditional.getLng());
									list.add(superDeliveryPositionDto);
								}else{
								}
							}else{
							}
						}
						if ( list.size() < 10 ) {
							List<String> latAndLng = RandomLngLat.getLatAndLng(lat, lng);
							for (String a:
									latAndLng) {
								String[] split = a.split(",");
								SuperDeliveryPositionDto superDeliveryPositionDto = new SuperDeliveryPositionDto();
								superDeliveryPositionDto.setSuperDeliveryId(null);
								String s = split[0];
								BigDecimal bigDecimal = new BigDecimal(s).setScale(5, BigDecimal.ROUND_HALF_UP);
								superDeliveryPositionDto.setLat(bigDecimal+"");
								superDeliveryPositionDto.setLng(new BigDecimal(split[1]).setScale(5, BigDecimal.ROUND_HALF_UP).toString());
								list.add(superDeliveryPositionDto);
							}
						}
					}



					result.setData(list);
					result.setMessage("ok");
					result.setState(200);

				}else{
					result.setMessage(EWarning.ErrorParams.getName());
					result.setState(EWarning.ErrorParams.getValue());
					result.setData(list);
				}
			}else{
				result.setMessage(EWarning.Unknown.getName());
				result.setState(EWarning.Unknown.getValue());
				result.setData(list);
			}
		} catch (Exception e) {
			logger.error("GetDeliversPosition error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


}
