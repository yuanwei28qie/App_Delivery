package com.microsilver.mrcard.basicservice.controller;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.dto.SuperDeliveryDto;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditional;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserMember;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreReg;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryService;
import com.microsilver.mrcard.basicservice.service.SupserDeliveryInfoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
@Api(value = "/api/superDelivery", description = "骑手功能API")
@Controller
@RequestMapping(value = "/api/superDelivery")
public class SuperDeliveryController extends BaseController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private SuperDeliveryService superDeliveryService;
	@Autowired
	private SupserDeliveryInfoService supserDeliveryInfoService;
	
	
	
	@ApiOperation(value = "跑腿注册(手机号注册)", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "body"),
			@ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "password", value = "骑手密码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "country", value = "所在区县编码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "city", value = "城市编码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "province", value = "省份编码", required = true, paramType = "body")
			})
	@RequestMapping(value = "/SuperDeliveryregister")
	@ResponseBody
	public RespBaseDto<SuperDeliveryDto> SuperDeliveryregister(
			String mobile,
			String checkCode,
			String password,
			Long country,
			Long city,
			Long province
			) {
		RespBaseDto<SuperDeliveryDto> result = new RespBaseDto<SuperDeliveryDto>();
		SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
		try {
			if(mobile!=null) {
				FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if(selectDeliveryBymobile==null) {
					//验证码
					String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
					FxSdUserDeliverinfo info = new FxSdUserDeliverinfo();
					if(Integer.valueOf(redisCheckCode).equals(Integer.valueOf(checkCode))) {
						info.setMobile(mobile);
						info.setPwd(DigestUtils.md5Hex(password));
						info.setCounty(country);
						info.setCity(city);
						info.setProvince(province);
						//先存入到memeber表
						superDeliveryService.insertDelivery(info);
						//获取id查询到additional表中的数据
						FxSdUserDeliverAdditional selectInfoByDelivery = supserDeliveryInfoService.selectInfoByDelivery(info.getId());
						superDeliveryDto.setWorkstatus(selectInfoByDelivery.getIsWork());
						superDeliveryDto.setService_score(selectInfoByDelivery.getServiceScore());
						superDeliveryDto.setTotal_mileage(selectInfoByDelivery.getTotalMileage());
						superDeliveryDto.setTotal_number(selectInfoByDelivery.getTotalNumber());
						
						superDeliveryDto.setUserId(info.getId());
						superDeliveryDto.setRealname(info.getRealname());
						superDeliveryDto.setAvatar(info.getAvatar());
						superDeliveryDto.setMobile(info.getMobile());
						superDeliveryDto.setAlipay_account(info.getAlipayAccount());
						superDeliveryDto.setCheck_status(info.getCheckStatus());
						superDeliveryDto.setLevel_name("为什么只有服务分,没有服务等级");
						//今日里程
						superDeliveryDto.setToday_mileage(1000);
						//今日单数
						superDeliveryDto.setToday_number(12);
						//今日收入
						superDeliveryDto.setToday_income("5000美金");
						//余额
						superDeliveryDto.setReal_amount("仅剩7块");
						superDeliveryDto.setIm_accout("即时通讯账号");
						superDeliveryDto.setImtoken("即时通讯token");
						//查询pre_reg表存入referee
						FxSdUserPreReg checkIsInvitation = superDeliveryService.checkIsInvitation(Long.parseLong(mobile));
						if(checkIsInvitation!=null&&checkIsInvitation.getStatus()==0) {
							checkIsInvitation.setStatus((byte)1);
							info.setReferee(Long.parseLong(checkIsInvitation.getRefereeId()));
							superDeliveryService.updateSuperDelivery(info,info.getId());
						}
						result.setData(superDeliveryDto);
						result.setMessage("OK");
					}
				}
			}
			
		}catch(Exception e) {
			logger.error("SuperDeliveryregister error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	

	/**
	 * 骑手登陆(用户和密码登陆)
	 */
	@ApiOperation(value = "骑手登陆(手机号,密码登陆)", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form") })
	@RequestMapping(value = "/SuperliveryLogin")
	@ResponseBody
	public RespBaseDto<Object> SuperliveryLogin(
			String mobile, 
			String password) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
			if(mobile!=null&&password!=null) {
			// 验证手机号是否存在
			FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if(selectDeliveryBymobile!=null) {
					String md5password = DigestUtils.md5Hex(password);
					if(selectDeliveryBymobile.getPwd().equals(md5password)) {
						FxSdUserDeliverAdditional selectInfoByDelivery = supserDeliveryInfoService.selectInfoByDelivery(selectDeliveryBymobile.getId());
						if(selectInfoByDelivery!=null) {
							superDeliveryDto.setWorkstatus(selectInfoByDelivery.getIsWork());
							superDeliveryDto.setService_score(selectInfoByDelivery.getServiceScore());
							superDeliveryDto.setTotal_mileage(selectInfoByDelivery.getTotalMileage());
							superDeliveryDto.setTotal_number(selectInfoByDelivery.getTotalNumber());
						}
						superDeliveryDto.setUserId(selectDeliveryBymobile.getId());
						superDeliveryDto.setRealname(selectDeliveryBymobile.getRealname());
						superDeliveryDto.setAvatar(selectDeliveryBymobile.getAvatar());
						superDeliveryDto.setMobile(selectDeliveryBymobile.getMobile());
						superDeliveryDto.setAlipay_account(selectDeliveryBymobile.getAlipayAccount());
						superDeliveryDto.setCheck_status(selectDeliveryBymobile.getCheckStatus());
						superDeliveryDto.setLevel_name("为什么只有服务分,没有服务等级");
						//今日里程
						superDeliveryDto.setToday_mileage(1000);
						//今日单数
						superDeliveryDto.setToday_number(12);
						//今日收入
						superDeliveryDto.setToday_income("5000美金");
						//余额
						superDeliveryDto.setReal_amount("仅剩7块");
						superDeliveryDto.setIm_accout("即时通讯账号");
						superDeliveryDto.setImtoken("即时通讯token");
						result.setData(superDeliveryDto);
						result.setMessage("ok");
					}
				}
			}
		}catch(Exception e) {
			logger.error("SuperliveryLogin error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	

	/**
	 * 
	 * 忘记密码,更新数据库中密码
	 */
	@ApiOperation(value = "忘记密码", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "checkCode", value = "短信验证码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newPwd", value = "新密码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newConfirmPwd", value = "确认新密码", required = true, paramType = "form") })
	@RequestMapping(value = "/ForgetPwd")
	@ResponseBody
	public RespBaseDto<Object> ForgetPwd(String mobile, String checkCode, String newPwd, String newConfirmPwd) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile == null || mobile.trim().equals("")) {
			result.setState(1);
			result.setMessage("手机号不能为空,请重新输入");
			return result;
		}

		if (checkCode == null || checkCode.trim().equals("")) {
			result.setState(2);
			result.setMessage("验证码不能为空,请重新输入");
			return result;
		}
		if (newPwd == null || newPwd.trim().equals("")) {
			result.setState(3);
			result.setMessage("密码不能为空,请重新输入");
			return result;
		}
		if (newConfirmPwd == null || newConfirmPwd.trim().equals("")) {
			result.setState(4);
			result.setMessage("密码不能为空,请重新输入");
			return result;
		}
		FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
		if (selectDeliveryBymobile == null) {
			result.setState(5);
			result.setMessage("手机号未注册,请注册后登陆");
			return result;
		}
		String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
		if (!redisCheckCode.equals(checkCode)) {
			result.setState(6);
			result.setMessage("验证码有误,请重新输入");
			return result;
		}
		if (!newPwd.equals(newConfirmPwd)) {
			System.out.println(newPwd);
			System.out.println(newConfirmPwd);
			result.setState(7);
			result.setMessage("两次密码输入不一致,请重新输入");
			return result;
		}
		// 更新密码
		selectDeliveryBymobile.setPwd(DigestUtils.md5Hex(newPwd));
		superDeliveryService.updatePwd(selectDeliveryBymobile);
		result.setState(8);
		result.setMessage("密码更新成功,请重新登陆");

		return result;

	}

	
	
	
	/**
	 * 骑手登陆(短信验证码登陆)
	 */
	@ApiOperation(value = "骑手登陆(短信验证码登陆)", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "checkCode", value = "验证码", required = true, paramType = "form") })
	@RequestMapping(value = "/SuperDeiveryMsgLogin")
	@ResponseBody
	public RespBaseDto<Object> SuperDeiveryMsgLogin(
			String mobile, 
			String checkCode) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			SuperDeliveryDto superDeliveryDto = new SuperDeliveryDto();
			if(mobile!=null&&checkCode!=null) {
			// 验证手机号是否存在
			FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
			//校验验证码
			String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
			if(Integer.valueOf(redisCheckCode).equals(Integer.valueOf(checkCode))) {
				if(selectDeliveryBymobile!=null) {
						FxSdUserDeliverAdditional selectInfoByDelivery = supserDeliveryInfoService.selectInfoByDelivery(selectDeliveryBymobile.getId());
						if(selectInfoByDelivery!=null) {
							superDeliveryDto.setWorkstatus(selectInfoByDelivery.getIsWork());
							superDeliveryDto.setService_score(selectInfoByDelivery.getServiceScore());
							superDeliveryDto.setTotal_mileage(selectInfoByDelivery.getTotalMileage());
							superDeliveryDto.setTotal_number(selectInfoByDelivery.getTotalNumber());
						}
						superDeliveryDto.setUserId(selectDeliveryBymobile.getId());
						superDeliveryDto.setRealname(selectDeliveryBymobile.getRealname());
						superDeliveryDto.setAvatar(selectDeliveryBymobile.getAvatar());
						superDeliveryDto.setMobile(selectDeliveryBymobile.getMobile());
						superDeliveryDto.setAlipay_account(selectDeliveryBymobile.getAlipayAccount());
						superDeliveryDto.setCheck_status(selectDeliveryBymobile.getCheckStatus());
						superDeliveryDto.setLevel_name("为什么只有服务分,没有服务等级");
						//今日里程
						superDeliveryDto.setToday_mileage(1000);
						//今日单数
						superDeliveryDto.setToday_number(12);
						//今日收入
						superDeliveryDto.setToday_income("5000美金");
						//余额
						superDeliveryDto.setReal_amount("仅剩7块");
						superDeliveryDto.setIm_accout("即时通讯账号");
						superDeliveryDto.setImtoken("即时通讯token");
						result.setData(superDeliveryDto);
						result.setMessage("ok");
					}
				}
			}
		}catch(Exception e) {
			logger.error("SuperDeiveryMsgLogin error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	
	/**
	 * 修改骑手手机号
	 */
	@ApiOperation(value = "修改骑手手机号", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "oldPhoneNumber", value = "旧手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "oldCheckCode", value = "旧手机号验证码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newPhoneNumber", value = "新手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newCheckCode", value = "新手机号验证码", required = true, paramType = "form"), 
			@ApiImplicitParam(name = "identityCardNo", value = "身份证号", required = true, paramType = "form") })
	@RequestMapping(value = "/EditSuperDeliveryPhone")
	@ResponseBody
	public RespBaseDto<Object> EditSuperDeliveryPhone(
			String oldPhoneNumber, 
			String oldCheckCode,
			String newPhoneNumber,
			String newCheckCode,
			String identityCardNo
			) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			if(oldPhoneNumber!=null&&oldCheckCode!=null&&newPhoneNumber!=null&&newCheckCode!=null&&identityCardNo!=null) {
				FxSdUserDeliverinfo oldPhoneSuperDelivery = superDeliveryService.selectDeliveryBymobile(oldPhoneNumber);
				if(oldPhoneSuperDelivery!=null) {
					String redisOldCode = stringRedisTemplate.opsForValue().get(oldPhoneNumber);
					if(Integer.valueOf(redisOldCode).equals(Integer.valueOf(oldCheckCode))) {
						FxSdUserDeliverinfo newPhoneSuperDelivery = superDeliveryService.selectDeliveryBymobile(newPhoneNumber);
						if(newPhoneSuperDelivery==null) {
							String redisNewCode = stringRedisTemplate.opsForValue().get(newPhoneNumber);
							if(Integer.valueOf(redisNewCode).equals(Integer.valueOf(newCheckCode))) {
								
								if(identityCardNo.equals(oldPhoneSuperDelivery.getIdentityCardNo())) {
									oldPhoneSuperDelivery.setMobile(newPhoneNumber);
									superDeliveryService.updateSuperDelivery(oldPhoneSuperDelivery,oldPhoneSuperDelivery.getId());
									result.setMessage("ok");
								}
							}
						}
					}
				}
			}
		}catch(Exception e) {
			logger.error("EditSuperDeliveryPhone error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	/**
	 * 修改骑手支付宝账号 
	 */
	@ApiOperation(value = "修改骑手支付宝账号 ", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "phoneNumber", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "checkCode", value = "验证码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "alipayAccount", value = "支付宝账号", required = true, paramType = "form"),
			})
	@RequestMapping(value = "/EditSuperDeliveryAlipay")
	@ResponseBody
	public RespBaseDto<Object> EditSuperDeliveryAlipay(
			String phoneNumber, 
			String checkCode,
			String alipayAccount
			) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			if(phoneNumber!=null&&checkCode!=null&&alipayAccount!=null) {
				FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(phoneNumber);
				if(selectDeliveryBymobile!=null) {
					String redisCheckCode = stringRedisTemplate.opsForValue().get(phoneNumber);
					if(Integer.valueOf(redisCheckCode).equals(Integer.valueOf(checkCode))) {
						selectDeliveryBymobile.setAlipayAccount(alipayAccount);
						superDeliveryService.updateSuperDelivery(selectDeliveryBymobile,selectDeliveryBymobile.getId());
						result.setMessage("ok");
					}
				}
			}
			
		}catch(Exception e) {
			logger.error("EditSuperDeliveryAlipay error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	
	/**
	 * 修改骑手密码或者重置密码
	 */
	@ApiOperation(value = "修改骑手密码或者重置密码", httpMethod = "POST")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
		@ApiImplicitParam(name = "password", value = "用户新密码", required = true, paramType = "form"),
		@ApiImplicitParam(name = "code", value = "旧密码或者验证码", required = true, paramType = "form"),
		@ApiImplicitParam(name = "type", value = "类型,1修改;2忘记", required = true, paramType = "form") 
			})
	@RequestMapping(value = "/UpdateSuperDeliveryPwd")
	@ResponseBody
	public RespBaseDto<Object> UpdateSuperDeliveryPwd(
			String mobile, 
			String password, 
			String code, 
			String type
			) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			if(mobile!=null) {
				FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
				if(selectDeliveryBymobile!=null) {
					//type类型是1则是修改密码,此刻的coke是旧密码
					if(type!=null&&type.equals("1")&&password!=null) {
						if(DigestUtils.md5Hex(code).equals(selectDeliveryBymobile.getPwd())) {
							selectDeliveryBymobile.setPwd(DigestUtils.md5Hex(password));
							superDeliveryService.updatePwd(selectDeliveryBymobile,mobile);
							System.out.println(selectDeliveryBymobile.toString());
							result.setMessage("Ok");
						}
					}
					//type类型是1则是修改密码,此刻的coke是验证码
					String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
					if(type!=null&&type.equals("2")&&password!=null) {
						if(Integer.parseInt(code)==Integer.parseInt(redisCheckCode)) {
							selectDeliveryBymobile.setPwd(DigestUtils.md5Hex(password));
							superDeliveryService.updatePwd(selectDeliveryBymobile,mobile);
							result.setMessage("Ok");
						}
					}
				}
			}
			
		}catch(Exception e) {
			logger.error("UpdateSuperDeliveryPwd error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	/**
	 * 骑手头像上传
	 */
	@ApiOperation(value = "骑手头像上传", httpMethod = "POST")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "superDeliveryId", value = "骑手Id", required = true, paramType = "body") ,
		@ApiImplicitParam(name = "avatar", value = "骑手头像URL", required = true, paramType = "body") 
			})
	@RequestMapping(value = "/UploadSuperDeliveryHeadImg")
	@ResponseBody
	public RespBaseDto<Object> UploadSuperDeliveryHeadImg(
			String superDeliveryId,
			String avatar 
			) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			if(superDeliveryId!=null) {
				 FxSdUserDeliverinfo superDelivery = superDeliveryService.selectUserBysuperDeliveryId(superDeliveryId);
				if(avatar!=null&&superDelivery!=null) {
					superDelivery.setAvatar(avatar);
					superDeliveryService.updateAvatar(superDelivery);
					result.setData(superDelivery);
					result.setMessage("ok");
					result.setState(200);
				}
			}
			
		}catch(Exception e) {
			logger.error("UploadSuperDeliveryHeadImg error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
}
