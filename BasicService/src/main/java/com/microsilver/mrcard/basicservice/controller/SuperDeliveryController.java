package com.microsilver.mrcard.basicservice.controller;


import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.dto.SuperDeliveryDto;
import com.microsilver.mrcard.basicservice.dto.SuperDeliverySimpleDto;
import com.microsilver.mrcard.basicservice.model.*;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.*;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(value = "/api/superDelivery", description = "骑手功能API")
@Controller
@RequestMapping(value = "/api/superDelivery")
@SuppressWarnings("unchecked")
@Transactional
public class SuperDeliveryController extends BaseController {

	private final StringRedisTemplate stringRedisTemplate;

	private final RedisTemplate redisTemplate;

	private final SuperDeliveryService superDeliveryService;

	private final SuperDeliveryInfoService superDeliveryInfoService;

	private final FinanceService financeService;

	private final SuperDeliveryOrderService superDeliveryOrderService;

	private final LevelService levelService;

	@Autowired
	public SuperDeliveryController(StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate, SuperDeliveryService superDeliveryService, SuperDeliveryInfoService superDeliveryInfoService, FinanceService financeService, SuperDeliveryOrderService superDeliveryOrderService, LevelService levelService) {
		this.stringRedisTemplate = stringRedisTemplate;
		this.redisTemplate = redisTemplate;

		this.superDeliveryService = superDeliveryService;
		this.superDeliveryInfoService = superDeliveryInfoService;
		this.financeService = financeService;
		this.superDeliveryOrderService = superDeliveryOrderService;
		this.levelService = levelService;
	}


	@ApiOperation(value = "跑腿注册(手机号注册)", httpMethod = "POST")
	@PostMapping(value = "/superDeliveryRegister", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliveryDto> superDeliveryRegister(
			@RequestBody DeliveryRegisterVo DeliveryRegisterVo
	) {
		RespBaseDto<SuperDeliveryDto> result = new RespBaseDto<>();
		SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
		Long mobile = DeliveryRegisterVo.getMobile();
		Integer checkCode = DeliveryRegisterVo.getCheckCode();
		String password = DeliveryRegisterVo.getPassword();
		Integer country = DeliveryRegisterVo.getCountry();
		Integer province = DeliveryRegisterVo.getProvince();
		Integer city = DeliveryRegisterVo.getCity();
		try {
			if (mobile != null && checkCode != null && country != null
					&& province != null && city != null && password != null && !password.equals("")) {
				FxSdUserDeliverinfo selectDeliveryByMobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if (selectDeliveryByMobile != null) {
					//骑手审核未通过,但是依然可以注册
					if(selectDeliveryByMobile.getCheckStatus()==(byte)0){
						//验证码
						//String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile + "");
						MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
						if(mobileCheckCode!=null){
							int redisCheckCode = mobileCheckCode.getCheckCode();
							short typeCheckCode = mobileCheckCode.getType();
							if (typeCheckCode == 1) {
								FxSdUserDeliverinfo info = new FxSdUserDeliverinfo();
								if (Integer.valueOf(redisCheckCode).equals(checkCode)) {
									info.setMobile(mobile + "");
									info.setPwd(DigestUtils.md5Hex(password));
									info.setCounty(country);
									info.setCity(city);
									info.setProvince(province);
									info.setCheckStatus((short) 3);
									info.setStates((byte)2);
									String s = String.valueOf(System.currentTimeMillis() / 1000);
									info.setCreateTime(Integer.parseInt(s));
									//先更新骑手表
									superDeliveryService.updateDelivery(info);
								/*//创建等级表关于骑手
								FxSdSysLevelsetting fxSdSysLevelsetting = levelService.selectByDliveryId(selectDeliveryByMobile.getId().intValue());
								if(fxSdSysLevelsetting==null){
									FxSdSysLevelsetting leveling = new FxSdSysLevelsetting();
									leveling.setServiceScore(0.0);
									leveling.setLevelName("白板");
									leveling.setLevelScore(80);
									leveling.setTotalStarScore(0);
									leveling.setDeliveryId(selectDeliveryByMobile.getId().intValue());
									levelService.insertInto(leveling);
								}*/
									superDeliveryDto.setWorkStatus((byte) 1);
									superDeliveryDto.setServiceScore(new BigDecimal(80));
									superDeliveryDto.setTotalMileage(0);
									superDeliveryDto.setTotalNumber(0);
									System.out.println(selectDeliveryByMobile.getId());
									superDeliveryDto.setSuperDeliveryId(selectDeliveryByMobile.getId());
									superDeliveryDto.setMobile(info.getMobile());
									superDeliveryDto.setLevelName("最强王者");
									superDeliveryDto.setCounty(country+"");
									superDeliveryDto.setProvince(province+"");
									superDeliveryDto.setCity(city+"");
									//今日里程
									superDeliveryDto.setTodayMileage(0);
									//今日单数
									superDeliveryDto.setTodayNumber(0);
									//今日收入
									superDeliveryDto.setTodayIncome("0美金");
									//余额
									superDeliveryDto.setRealAmount("0");
									//superDeliveryDto.setImAccount("即时通讯账号");
									//superDeliveryDto.setImToken("即时通讯token");
									//查询pre_reg表存入referee
								/*FxSdUserPreReg checkIsInvitation = superDeliveryService.checkIsInvitation(mobile);
								if (checkIsInvitation != null && checkIsInvitation.getStatus() == 0) {
									checkIsInvitation.setStatus((short) 1);
									info.setReferee(Long.parseLong(checkIsInvitation.getRefereeId()));
									superDeliveryService.updateSuperDelivery(info, info.getId());
								}*/
									result.setData(superDeliveryDto);
									result.setMessage("OK");
									result.setState(200);
								} else {
									result.setMessage(EWarning.CheckCodeError.getName());
									result.setState(EWarning.CheckCodeError.getValue());
									result.setData(new SuperDeliveryDto());
								}
							} else {
								result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
								result.setState(EWarning.CheckCodeTypeNotSame.getValue());
								result.setData(new SuperDeliveryDto());
							}
						}else{
							result.setMessage(EWarning.CheckCode_Overdue.getName());
							result.setState(EWarning.CheckCode_Overdue.getValue());
							result.setData(new SuperDeliveryDto());
						}
					}else{
						result.setData(new SuperDeliveryDto());
						result.setMessage(EWarning.MobileRegistered.getName());
						result.setState(EWarning.MobileRegistered.getValue());
					}
				} else {
					//验证码
					deliveryRegiester(result, superDeliveryDto, mobile, checkCode, password, country, province, city);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new SuperDeliveryDto());
			}
		} catch (Exception e) {
			logger.error("SuperDeliveryRegister error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	private void deliveryRegiester(RespBaseDto<SuperDeliveryDto> result, SuperDeliveryDto superDeliveryDto, Long mobile, Integer checkCode, String password, Integer country, Integer province, Integer city) {
		//验证码
		//String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile + "");
		MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
		int redisCheckCode = mobileCheckCode.getCheckCode();
		short typeCheckCode = mobileCheckCode.getType();
		if (typeCheckCode == 1) {
			FxSdUserDeliverinfo info = new FxSdUserDeliverinfo();
			if (Integer.valueOf(redisCheckCode).equals(checkCode)) {
				info.setMobile(mobile + "");
				info.setPwd(DigestUtils.md5Hex(password));
				info.setCounty(country);
				info.setCity(city);
				info.setProvince(province);
				info.setCheckStatus((short) 3);
				info.setStates((byte)2);
				String s = String.valueOf(System.currentTimeMillis() / 1000);
				info.setCreateTime(Integer.parseInt(s));
				//先存入到骑手表
				superDeliveryService.insertDelivery(info);
				//创建等级表关于骑手
				FxSdSysLevelsetting fxSdSysLevelsetting = levelService.selectByDliveryId(info.getId().intValue());
				if(fxSdSysLevelsetting==null){
					FxSdSysLevelsetting leveling = new FxSdSysLevelsetting();
					leveling.setServiceScore(0.0);
					leveling.setLevelName("白板");
					leveling.setLevelScore(80);
					leveling.setTotalStarScore(0);
					leveling.setDeliveryId(info.getId().intValue());
					levelService.insertInto(leveling);
				}
				//添加数据到财务
				FxSdFinanceCustomer financeCustomer = new FxSdFinanceCustomer();

				financeCustomer.setMobile(mobile+"");
				financeCustomer.setUserType((byte) 2);
				financeCustomer.setAdvanceAmount(new BigDecimal(0));
				financeCustomer.setTotalAmount(new BigDecimal(0));
				financeCustomer.setOtherAmount(new BigDecimal(0));
				String time =String.valueOf(System.currentTimeMillis()/1000);
				financeCustomer.setCreateTime(Integer.parseInt(time));
				financeCustomer.setRealAmount(new BigDecimal(0));
				financeCustomer.setStatus((byte)1);
				financeService.insertFinaceCustomer(financeCustomer);
				//通过注册之后的骑手的id来保存additional数据表的信息
				FxSdUserDeliverAdditional fxSdUserDeliverAdditional = new FxSdUserDeliverAdditional();
				//骑手默认注册后为休息;是否工作(1:工作,0:休息)
				fxSdUserDeliverAdditional.setIsWork((byte) 0);
				fxSdUserDeliverAdditional.setLat("0");
				fxSdUserDeliverAdditional.setLng("0");
				fxSdUserDeliverAdditional.setDeliverId(info.getId());
				fxSdUserDeliverAdditional.setLevelScore(80);
				fxSdUserDeliverAdditional.setServiceScore(new BigDecimal(80));
				fxSdUserDeliverAdditional.setTotalMileage(0);
				fxSdUserDeliverAdditional.setTotalNumber(0);
				superDeliveryOrderService.insertfxSdUserDeliverAdditional(fxSdUserDeliverAdditional);
				superDeliveryDto.setWorkStatus((byte) 1);
				superDeliveryDto.setServiceScore(new BigDecimal(80));
				superDeliveryDto.setTotalMileage(0);
				superDeliveryDto.setTotalNumber(0);
				superDeliveryDto.setSuperDeliveryId(info.getId());
				superDeliveryDto.setMobile(info.getMobile());
				superDeliveryDto.setLevelName("最强王者");
				superDeliveryDto.setCounty(country+"");
				superDeliveryDto.setProvince(province+"");
				superDeliveryDto.setCity(city+"");
				//今日里程
				superDeliveryDto.setTodayMileage(0);
				//今日单数
				superDeliveryDto.setTodayNumber(0);
				//今日收入
				superDeliveryDto.setTodayIncome("0美金");
				//余额
				superDeliveryDto.setRealAmount("0");
				//superDeliveryDto.setImAccount("即时通讯账号");
				//superDeliveryDto.setImToken("即时通讯token");
				//查询pre_reg表存入referee
				FxSdUserPreReg checkIsInvitation = superDeliveryService.checkIsInvitation(mobile);
				if (checkIsInvitation != null && checkIsInvitation.getStatus() == 0) {
					checkIsInvitation.setStatus((short) 1);
					info.setReferee(Long.parseLong(checkIsInvitation.getRefereeId()));
					superDeliveryService.updateSuperDelivery(info, info.getId());
				}
				result.setData(superDeliveryDto);
				result.setMessage("OK");
				result.setState(200);
			} else {
				result.setMessage(EWarning.CheckCodeError.getName());
				result.setState(EWarning.CheckCodeError.getValue());
				result.setData(new SuperDeliveryDto());
			}
		} else {
			result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
			result.setState(EWarning.CheckCodeTypeNotSame.getValue());
			result.setData(new SuperDeliveryDto());
		}
	}

	@ApiOperation(value = "id获取骑手信息", httpMethod = "POST")
	@PostMapping(value = "/getSuperDeliveryInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliveryDto> getSuperDeliveryInfo(
			@RequestBody DeliveryGetInfoVo deliveryGetInfoVo
	) {
		RespBaseDto<SuperDeliveryDto> result = new RespBaseDto<>();
		SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
		Integer superDeliveryId = deliveryGetInfoVo.getDeliveryId();
		try {
				if(superDeliveryId!=null){
					FxSdUserDeliverinfo fxSdUserDeliverinfo = superDeliveryService.selectUserBysuperDeliveryId(superDeliveryId + "");
					if (fxSdUserDeliverinfo != null) {

						superDeliveryDto.setSuperDeliveryId(superDeliveryId.longValue());
						superDeliveryDto.setCheckStatus(fxSdUserDeliverinfo.getCheckStatus());
						superDeliveryDto.setMobile(fxSdUserDeliverinfo.getMobile());
						superDeliveryDto.setRealName(fxSdUserDeliverinfo.getRealname());
						superDeliveryDto.setAvatar(fxSdUserDeliverinfo.getAvatar());
						superDeliveryDto.setGender(fxSdUserDeliverinfo.getGender());
						superDeliveryDto.setAddress(fxSdUserDeliverinfo.getAddress());
						superDeliveryDto.setAliPayAccount(fxSdUserDeliverinfo.getAlipayAccount());
						superDeliveryDto.setIdentityCardFront(fxSdUserDeliverinfo.getIdentityCardFront());
						superDeliveryDto.setIdentityCardNo(fxSdUserDeliverinfo.getIdentityCardNo());
						superDeliveryDto.setIdentityCardBack(fxSdUserDeliverinfo.getIdentityCardBack());
						superDeliveryDto.setIdentityCardGroup(fxSdUserDeliverinfo.getIdentityCardGroup());

						superDeliveryDto.setCreateTime(fxSdUserDeliverinfo.getCreateTime() + "");
						superDeliveryDto.setProvince(fxSdUserDeliverinfo.getProvince() + "");
						superDeliveryDto.setCity(fxSdUserDeliverinfo.getCity() + "");
						superDeliveryDto.setCounty(fxSdUserDeliverinfo.getCounty() + "");
						superDeliveryDto.setOtherPhone(fxSdUserDeliverinfo.getOtherphoneno());
						superDeliveryDto.setOccupation(fxSdUserDeliverinfo.getOccupation());
						result.setMessage("ok");
						result.setState(200);
						result.setData(superDeliveryDto);

					} else {
						result.setMessage(EWarning.NonExistent.getName());
						result.setState(EWarning.NonExistent.getValue());
						result.setData(superDeliveryDto);
					}
					FxSdUserDeliverAdditional fxSdUserDeliverAdditional = superDeliveryInfoService.selectInfoByDelivery(superDeliveryId.longValue());
					if (fxSdUserDeliverAdditional != null) {
						superDeliveryDto.setServiceScore(fxSdUserDeliverAdditional.getServiceScore());
						superDeliveryDto.setLevelName(fxSdUserDeliverAdditional.getLevelScore() + "");
						superDeliveryDto.setWorkStatus(fxSdUserDeliverAdditional.getIsWork());
					} else {
						result.setMessage(EWarning.NonExistent.getName());
						result.setState(EWarning.NonExistent.getValue());
						result.setData(superDeliveryDto);
					}
				}else{
					result.setMessage(EWarning.MessageIsNull.getName());
					result.setState(EWarning.MessageIsNull.getValue());
					result.setData(superDeliveryDto);
				}


		} catch (Exception e) {
			logger.error("getSuperDeliveryInfo error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "跑腿完善资料", httpMethod = "POST")
	@PostMapping(value = "/perfectSuperDelivery", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliveryDto> perfectSuperDelivery(
			@RequestBody DeliveryPerfectVo deliveryPerfectVo
	) {
		RespBaseDto<SuperDeliveryDto> result = new RespBaseDto<>();
		Integer superDeliveryId = deliveryPerfectVo.getSuperDeliveryId();
		//登陆名
		Long mobile = deliveryPerfectVo.getMobile();
		String password = deliveryPerfectVo.getPassword();
		String realName = deliveryPerfectVo.getRealName();
		Short gender = deliveryPerfectVo.getGender();
		Integer city = deliveryPerfectVo.getCity();
		Integer province = deliveryPerfectVo.getProvince();
		Integer county = deliveryPerfectVo.getCounty();
		//支付宝账号
		String aliPayAccount = deliveryPerfectVo.getAliPayAccount();
		//身份证编号
		String identityCardNo = deliveryPerfectVo.getIdentityCardNo();
		String address = deliveryPerfectVo.getAddress();
		//紧急人电话
		Long otherPhoneNo = deliveryPerfectVo.getOtherPhone();
		//从事职业
		String occupation = deliveryPerfectVo.getOccupation();
		String identityCardFront = deliveryPerfectVo.getIdentityCardFront();
		String identityCardBack = deliveryPerfectVo.getIdentityCardBack();
		String identityCardGroup = deliveryPerfectVo.getIdentityCardGroup();
		SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
		try {
			if (superDeliveryId != null && mobile != null &&
					password != null && !password.equals("") && realName != null && !realName.equals("") &&
					gender != null && city != null &&
					province != null && county != null &&
					aliPayAccount != null && !aliPayAccount.equals("") && identityCardNo != null && !identityCardNo.equals("") &&
					address != null && !address.equals("") && otherPhoneNo != null &&
					occupation != null && !occupation.equals("") && identityCardFront != null && !identityCardFront.equals("") &&
					identityCardBack != null && !identityCardBack.equals("") && identityCardGroup != null && !identityCardGroup.equals("")
					) {
				FxSdUserDeliverinfo fxSdUserDeliverinfo = superDeliveryService.selectDeliveryByMobileAndId(mobile + "", superDeliveryId + "");
				if (fxSdUserDeliverinfo != null) {
					if(fxSdUserDeliverinfo.getCheckStatus()==2){
						result.setMessage("骑手已审核完成,请勿重复操作");
						result.setState(EWarning.PasswordError.getValue());
						result.setData(new SuperDeliveryDto());
					}else{
						if (DigestUtils.md5Hex(password).equals(fxSdUserDeliverinfo.getPwd())) {
							fxSdUserDeliverinfo.setRealname(realName);
							//性别，0-男，1-女
							fxSdUserDeliverinfo.setGender((short) 1);
							fxSdUserDeliverinfo.setAddress(address);
							fxSdUserDeliverinfo.setAlipayAccount(aliPayAccount);
							fxSdUserDeliverinfo.setIdentityCardNo(identityCardNo);
							fxSdUserDeliverinfo.setIdentityCardFront(identityCardFront);
							fxSdUserDeliverinfo.setIdentityCardBack(identityCardBack);
							fxSdUserDeliverinfo.setIdentityCardGroup(identityCardGroup);
							fxSdUserDeliverinfo.setCity(city);
							fxSdUserDeliverinfo.setProvince(province);
							fxSdUserDeliverinfo.setCounty(county);
							//时间戳
							String time = String.valueOf(System.currentTimeMillis() / 1000);
							fxSdUserDeliverinfo.setCreateTime(Integer.parseInt(time));
							fxSdUserDeliverinfo.setCheckStatus((short) 1);
							fxSdUserDeliverinfo.setOtherphoneno(otherPhoneNo + "");
							fxSdUserDeliverinfo.setOccupation(occupation);
							//默认禁用(1启用 2禁用)
							fxSdUserDeliverinfo.setStates((byte) 2);
							//写库
							superDeliveryService.updateSuperDelivery(fxSdUserDeliverinfo, fxSdUserDeliverinfo.getId());
							//查询评分等级表
							FxSdUserDeliverAdditional fxSdUserDeliverAdditional = superDeliveryInfoService.selectInfoByDelivery(superDeliveryId.longValue());
							if (fxSdUserDeliverAdditional != null) {
								superDeliveryDto.setServiceScore(fxSdUserDeliverAdditional.getServiceScore());
								superDeliveryDto.setLevelName(fxSdUserDeliverAdditional.getLevelScore() + "");
								superDeliveryDto.setWorkStatus(fxSdUserDeliverAdditional.getIsWork());
							}
							superDeliveryDto.setSuperDeliveryId(superDeliveryId.longValue());
							superDeliveryDto.setAliPayAccount(aliPayAccount);
							superDeliveryDto.setMobile(mobile + "");
							superDeliveryDto.setCheckStatus((short) 1);
							superDeliveryDto.setRealName(realName);
							superDeliveryDto.setGender((short) 1);
							superDeliveryDto.setAddress(address);
							superDeliveryDto.setIdentityCardNo(identityCardNo);
							superDeliveryDto.setIdentityCardFront(identityCardFront);
							superDeliveryDto.setIdentityCardBack(identityCardBack);
							superDeliveryDto.setIdentityCardGroup(identityCardGroup);
							superDeliveryDto.setCreateTime(time);
							superDeliveryDto.setCheckStatus((short) 1);
							superDeliveryDto.setProvince(province + "");
							superDeliveryDto.setCity(city + "");
							superDeliveryDto.setCounty(county + "");
							superDeliveryDto.setOtherPhone(otherPhoneNo + "");
							superDeliveryDto.setOccupation(occupation);
							result.setMessage("ok");
							result.setState(200);
							result.setData(superDeliveryDto);
						} else {
							result.setMessage(EWarning.PasswordError.getName());
							result.setState(EWarning.PasswordError.getValue());
							result.setData(new SuperDeliveryDto());
						}
					}
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new SuperDeliveryDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new SuperDeliveryDto());
			}
		} catch (Exception ex) {
			logger.error("perfectSuperDelivery error:{}" + ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "骑手登陆(手机号,密码登陆)", httpMethod = "POST")
	@PostMapping(value = "/superDeliveryLogin", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliverySimpleDto> superDeliveryLogin(
			@RequestBody LoginVo loginVo
	) {
		RespBaseDto<SuperDeliverySimpleDto> result = new RespBaseDto<>();
		try {
			Long mobile = loginVo.getMobile();
			String password = loginVo.getPassword();
			if (mobile != null && password != null) {
				// 验证手机号是否存在
				FxSdUserDeliverinfo selectDeliveryByMobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if (selectDeliveryByMobile != null) {
					String md5password = DigestUtils.md5Hex(password);
					if (selectDeliveryByMobile.getPwd().equals(md5password)) {
						UUID uuid = UUID.randomUUID();
						String s = uuid.toString();
						TokenType tokenType = new TokenType();
						tokenType.setAppType((short)2);
						tokenType.setToken(s);
						tokenType.setUserId(selectDeliveryByMobile.getId().intValue());
						redisTemplate.opsForValue().set(selectDeliveryByMobile.getId().intValue()+""+2,tokenType,60 * 60 *24*7, TimeUnit.SECONDS);
						SuperDeliverySimpleDto superDeliverySimpleDto = new SuperDeliverySimpleDto();
						superDeliverySimpleDto.setSuperDeliveryId(selectDeliveryByMobile.getId() + "");
						superDeliverySimpleDto.setToken(s);
						superDeliverySimpleDto.setMobile(mobile.toString());
						//写库token
						selectDeliveryByMobile.setToken(s.getBytes());
						superDeliveryService.updateToken(selectDeliveryByMobile);
						result.setMessage("ok");
						result.setState(200);
						result.setData(superDeliverySimpleDto);
					} else {
						result.setMessage(EWarning.PasswordError.getName());
						result.setState(EWarning.PasswordError.getValue());
						result.setData(new SuperDeliverySimpleDto());
					}
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new SuperDeliverySimpleDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new SuperDeliverySimpleDto());
			}
		} catch (Exception e) {
			logger.error("superDeliveryLogin error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	/**
	 * 骑手登陆(短信验证码登陆)
	 */
	@ApiOperation(value = "骑手登陆(短信验证码登陆)", httpMethod = "POST")
	@PostMapping(value = "/superDeliveryMsgLogin", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliverySimpleDto> superDeliveryMsgLogin(
			@RequestBody RegisterOrLoginVo registerOrLoginVo
	) {
		Long mobile = registerOrLoginVo.getMobile();
		Integer checkCode = registerOrLoginVo.getCheckCode();
		RespBaseDto<SuperDeliverySimpleDto> result = new RespBaseDto<>();
		try {
			if (mobile != null && checkCode != null) {
				// 验证手机号是否存在
				FxSdUserDeliverinfo selectDeliveryByMobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if (selectDeliveryByMobile != null) {
					//校验验证码
					//String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile + "");
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
					if(mobileCheckCode!=null){
						int redisCheckCode = mobileCheckCode.getCheckCode();
						short typeCheckCode = mobileCheckCode.getType();
						if (typeCheckCode != 2) {
							result.setMessage(EWarning.CheckCodeTypeNotSame.getName());
							result.setState(EWarning.CheckCodeTypeNotSame.getValue());
							result.setData(new SuperDeliverySimpleDto());
						} else {
							if (Integer.valueOf(redisCheckCode).equals(checkCode)) {
								UUID uuid = UUID.randomUUID();
								String s = uuid.toString();
								//保存到redis中
								TokenType tokenType = new TokenType();
								tokenType.setAppType((short)2);
								tokenType.setToken(s);
								tokenType.setUserId(selectDeliveryByMobile.getId().intValue());
								redisTemplate.opsForValue().set(selectDeliveryByMobile.getId().intValue()+""+2,tokenType,60 * 60 *24*7, TimeUnit.SECONDS);

								TokenType tokenType1 = (TokenType) redisTemplate.opsForValue().get(selectDeliveryByMobile.getId().intValue() + "" + 2);
								System.out.println(tokenType1.getToken());
								SuperDeliverySimpleDto superDeliverySimpleDto = new SuperDeliverySimpleDto();
								superDeliverySimpleDto.setSuperDeliveryId(selectDeliveryByMobile.getId() + "");
								superDeliverySimpleDto.setToken(s);
								superDeliverySimpleDto.setMobile(selectDeliveryByMobile.getMobile());
								//写库token
								selectDeliveryByMobile.setToken(s.getBytes());
								superDeliveryService.updateToken(selectDeliveryByMobile);
								result.setData(superDeliverySimpleDto);
								result.setMessage("登陆成功");
								result.setState(200);
							} else {
								result.setMessage(EWarning.CheckCodeError.getName());
								result.setState(EWarning.CheckCodeError.getValue());
								result.setData(new SuperDeliverySimpleDto());
							}
						}
					}else{
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(new SuperDeliverySimpleDto());
					}

				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new SuperDeliverySimpleDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new SuperDeliverySimpleDto());
			}
		} catch (Exception e) {
			logger.error("SuperDeliveryMsgLogin error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	/**
	 * 修改骑手手机号
	 */
	@ApiOperation(value = "修改骑手手机号", httpMethod = "POST")
	@PostMapping(value = "/editSuperDeliveryPhone", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliverySimpleDto> editSuperDeliveryPhone(
			@RequestBody DeliveryEditPhoneVo deliveryEditPhoneVo
	) {
		RespBaseDto<SuperDeliverySimpleDto> result = new RespBaseDto<>();
		Long oldPhoneNumber = deliveryEditPhoneVo.getOldPhoneNumber();
		Integer oldCheckCode = deliveryEditPhoneVo.getOldCheckCode();
		Long newPhoneNumber = deliveryEditPhoneVo.getNewPhoneNumber();
		Integer newCheckCode = deliveryEditPhoneVo.getNewCheckCode();
		String identityCardNo = deliveryEditPhoneVo.getIdentityCardNo();
		SuperDeliverySimpleDto superDeliverySimpleDto = new SuperDeliverySimpleDto();
		try {
			if (oldPhoneNumber != null && oldCheckCode != null && newPhoneNumber != null && newCheckCode != null && identityCardNo != null) {
				FxSdUserDeliverinfo oldPhoneSuperDelivery = superDeliveryService.selectDeliveryBymobile(oldPhoneNumber );
				if (oldPhoneSuperDelivery != null) {
					//String redisOldCode = stringRedisTemplate.opsForValue().get(oldPhoneNumber + "");
					MobileCheckCode mobileCheckCode = (MobileCheckCode) redisTemplate.opsForValue().get(oldPhoneNumber);
					if(mobileCheckCode!=null){
						int redisOldCode = mobileCheckCode.getCheckCode();
						short typeCheckCode = mobileCheckCode.getType();
						if (Integer.valueOf(redisOldCode).equals(oldCheckCode)&&typeCheckCode==3) {
							FxSdUserDeliverinfo newPhoneSuperDelivery = superDeliveryService.selectDeliveryBymobile(newPhoneNumber );
							if (newPhoneSuperDelivery == null) {
								//String redisNewCode = stringRedisTemplate.opsForValue().get(newPhoneNumber + "");
								MobileCheckCode mobileCheckCode2 = (MobileCheckCode) redisTemplate.opsForValue().get(oldPhoneNumber);
								if(mobileCheckCode2!=null){
									int redisNewCode = mobileCheckCode2.getCheckCode();
									short typeCheckCodeNew = mobileCheckCode2.getType();
									if (Integer.valueOf(redisNewCode).equals(newCheckCode)&&typeCheckCodeNew==3) {
										if (identityCardNo.equals(oldPhoneSuperDelivery.getIdentityCardNo())) {
											oldPhoneSuperDelivery.setMobile(newPhoneNumber + "");
											superDeliveryService.updateSuperDelivery(oldPhoneSuperDelivery, oldPhoneSuperDelivery.getId());
											superDeliverySimpleDto.setSuperDeliveryId(oldPhoneSuperDelivery.getId() + "");
											superDeliverySimpleDto.setMobile(newPhoneNumber + "");
											result.setMessage("ok");
											result.setState(200);
											result.setData(superDeliverySimpleDto);
										} else {
											result.setMessage(EWarning.CardNotSame.getName());
											result.setState(EWarning.CardNotSame.getValue());
											result.setData(superDeliverySimpleDto);
										}
									} else {
										result.setMessage(EWarning.CheckCodeError.getName());
										result.setState(EWarning.CheckCodeError.getValue());
										result.setData(superDeliverySimpleDto);
									}
								}else{
									result.setMessage(EWarning.CheckCode_Overdue.getName());
									result.setState(EWarning.CheckCode_Overdue.getValue());
									result.setData(superDeliverySimpleDto);
								}
							} else {
								result.setMessage(EWarning.MobileRegistered.getName());
								result.setState(EWarning.MobileRegistered.getValue());
								result.setData(superDeliverySimpleDto);
							}
						} else {
							result.setMessage(EWarning.CheckCodeError.getName());
							result.setState(EWarning.CheckCodeError.getValue());
							result.setData(superDeliverySimpleDto);
						}
					}else{
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(superDeliverySimpleDto);
					}

				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(superDeliverySimpleDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(superDeliverySimpleDto);
			}
		} catch (Exception e) {
			logger.error("EditSuperDeliveryPhone error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	/**
	 * 修改骑手密码或者重置密码
	 */
	@ApiOperation(value = "修改骑手密码或者重置密码", httpMethod = "POST")
	@PostMapping(value = "/updateSuperDeliveryPwd", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliverySimpleDto> updateSuperDeliveryPwd(
			@RequestBody EditPwdVo userEditPwdVo
	) {
		RespBaseDto<SuperDeliverySimpleDto> result = new RespBaseDto<>();
		Long mobile = userEditPwdVo.getMobile();
		String code = userEditPwdVo.getCode();
		String type = userEditPwdVo.getType().toString();
		String password = userEditPwdVo.getNewPwd();
		SuperDeliverySimpleDto superDeliverySimpleDto = new SuperDeliverySimpleDto();
		try {
			if (mobile != null && password != null
					&& !password.equals("") && code != null && !code.equals("")  && !type.equals("")) {
				FxSdUserDeliverinfo selectDeliveryByMobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if (selectDeliveryByMobile != null) {
					//type类型是1则是修改密码,此刻的coke是旧密码
					if (type.equals("1")) {
						if (DigestUtils.md5Hex(code).equals(selectDeliveryByMobile.getPwd())) {
							updateSuperDeliveryInfo(superDeliverySimpleDto, result, mobile, password, selectDeliveryByMobile);
						} else {
							result.setMessage(EWarning.PasswordError.getName());
							result.setState(EWarning.PasswordError.getValue());
							result.setData(superDeliverySimpleDto);
						}
					}
					//type类型是1则是修改密码,此刻的coke是验证码
					MobileCheckCode mobileCheckCode2 = (MobileCheckCode) redisTemplate.opsForValue().get(mobile);
					if (mobileCheckCode2!=null){
						int redisCheckCode = mobileCheckCode2.getCheckCode();
						short typeCheckCodeNew = mobileCheckCode2.getType();
						if (type.equals("2")) {
							if (Integer.parseInt(code) == redisCheckCode && typeCheckCodeNew==3) {
								updateSuperDeliveryInfo(superDeliverySimpleDto, result, mobile, password, selectDeliveryByMobile);
							} else {
								result.setMessage(EWarning.CheckCodeError.getName());
								result.setState(EWarning.CheckCodeError.getValue());
								result.setData(superDeliverySimpleDto);
							}
						}
						if (!type.equals("1") && !type.equals("2")) {
							result.setMessage(EWarning.NotType.getName());
							result.setState(EWarning.NotType.getValue());
							result.setData(superDeliverySimpleDto);
						}
					}else {
						result.setMessage(EWarning.CheckCode_Overdue.getName());
						result.setState(EWarning.CheckCode_Overdue.getValue());
						result.setData(superDeliverySimpleDto);
					}

				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(superDeliverySimpleDto);
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(superDeliverySimpleDto);
			}
		} catch (Exception e) {
			logger.error("UpdateSuperDeliveryPwd error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	private void updateSuperDeliveryInfo(SuperDeliverySimpleDto superDeliverySimpleDto, RespBaseDto<SuperDeliverySimpleDto> result, Long mobile, String password, FxSdUserDeliverinfo selectDeliveryByMobile) {
		selectDeliveryByMobile.setPwd(DigestUtils.md5Hex(password));
		superDeliveryService.updatePwd(selectDeliveryByMobile, mobile);
		superDeliverySimpleDto.setSuperDeliveryId(selectDeliveryByMobile.getId() + "");
		result.setMessage("Ok");
		result.setData(superDeliverySimpleDto);
		result.setState(200);
	}

	/**
	 * 骑手头像上传
	 */
	@ApiOperation(value = "骑手头像上传", httpMethod = "POST")
	@PostMapping(value = "/uploadSuperDeliveryHeadImg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<SuperDeliverySimpleDto> uploadSuperDeliveryHeadImg(
			@RequestBody AvatarVo avatarVo
	) {
		RespBaseDto<SuperDeliverySimpleDto> result = new RespBaseDto<>();
		Integer superDeliveryId = avatarVo.getUserId();
		String avatar = avatarVo.getUserAvartarUrl();
		SuperDeliverySimpleDto superDeliverySimpleDto = new SuperDeliverySimpleDto();
		try {
			if (superDeliveryId != null && avatar != null  && !avatar.equals("")) {
				FxSdUserDeliverinfo superDelivery = superDeliveryService.selectUserBysuperDeliveryId(superDeliveryId+"");
				if (superDelivery != null) {
					superDelivery.setAvatar(avatar);
					superDeliveryService.updateAvatar(superDelivery);
					superDeliverySimpleDto.setAvatar(avatar);
					superDeliverySimpleDto.setMobile(superDelivery.getMobile());
					superDeliverySimpleDto.setSuperDeliveryId(superDelivery.getId().toString());
					result.setData(superDeliverySimpleDto);
					result.setMessage("ok");
					result.setState(200);
				} else {
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
					result.setData(new SuperDeliverySimpleDto());
				}
			} else {
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
				result.setData(new SuperDeliverySimpleDto());
			}
		} catch (Exception e) {
			logger.error("uploadSuperDeliveryHeadImg error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

}
