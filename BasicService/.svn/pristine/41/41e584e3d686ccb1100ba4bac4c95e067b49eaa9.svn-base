package com.microsilver.mrcard.basicservice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.basicservice.dto.FxAreaDto;
import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.FxSdSysArea;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopen;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersion;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.mq.MQSendMsgHelper;
import com.microsilver.mrcard.basicservice.service.FxSdSysVersionServices;
import com.microsilver.mrcard.basicservice.service.IFinanceRemoteSmpl;
import com.microsilver.mrcard.basicservice.service.SysAreasServices;
import com.microsilver.mrcard.mq.PushMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/Common", description = "通用方法API")
@Controller
@RequestMapping("/api/Common")
public class CommonController extends BaseController {
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;
	@Autowired
	private SysAreasServices sysAreasServices;
	@Autowired
	private FxSdSysVersionServices fxSdSysVersionServices;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	IFinanceRemoteSmpl financeRemoteSmpl;

	@Autowired
	private MQSendMsgHelper mqSendMsgHelper;
	
	@ApiOperation(value = "获取服务器时间", httpMethod = "POST")
	@RequestMapping(value = "/getSysTime")
	@ResponseBody
	public RespBaseDto<String> getSysTime(){
		RespBaseDto<String> result = new RespBaseDto<String>();
		result.setData(String.valueOf(System.currentTimeMillis()));
		result.setMessage("OK");
		return result;
	}
	
	/**
	 * 发送短信验证码并保存
	 */
	@ApiOperation(value = "发送短信验证码并保存", httpMethod = "POST")
	@RequestMapping(value = { "/sendAndSaveCheckCode" }, method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Object> sendAndSaveCheckCode(String mobile) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try {
			if (mobile != null && !mobile.equals("")) {
				mobile = mobile.trim();
				// 生成验证码
				String checkCode = (Math.random()+"").substring(2, 8);
				// 存入redis中
				stringRedisTemplate.opsForValue().set(mobile, checkCode);
				//发送消息给MQ
				mqSendMsgHelper.sendJSONMsg(mobile+"-"+checkCode+"-"+"您的验证码是:"+checkCode+",如非本人操作,请忽略本短信");
				result.setData(null);
				result.setMessage("发送成功");
				result.setState(200);
				return result;
			}
		}catch(Exception e) {
			logger.error("sendAndSaveCheckCode error:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName()+e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	@ApiOperation(value = "MQ接收处理，短信消息，推送消息", httpMethod = "POST")
	@RequestMapping(value = "/pushMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Object> pushMessageToMQ(PushMsg msg){
		logger.info("PushMsg :"+JSON.toJSONString(msg));

		RespBaseDto<Object> res = new RespBaseDto<Object>();
		try{
			mqsendMsgHelper.sendJSONMsg(msg);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}
	
	@ApiOperation(value = "获取全部区域", httpMethod = "POST")
	@RequestMapping(value = "/getAllArea")
	@ResponseBody
	public RespBaseDto<List<FxSdSysArea>> getAllArea() throws Exception{
		RespBaseDto<List<FxSdSysArea>> dto = new RespBaseDto<>();
		List<FxSdSysArea> allArea = sysAreasServices.getAllSysAreas();
		dto.setData(allArea);
		return dto;
	}
	
	
	@ApiOperation(value = "获取已开通区域", httpMethod = "POST")
	@RequestMapping(value = "/getOpenArea")
	@ResponseBody
	public RespBaseDto<List<FxAreaDto>> getOpenArea() throws Exception{
		RespBaseDto<List<FxAreaDto>> info = new RespBaseDto<>();
		List<FxSdSysAreaopen> openSysAreasList = sysAreasServices.getOpenSysAreas();
		List<FxAreaDto> list = new ArrayList<FxAreaDto>();
		if(openSysAreasList!=null) {
			for (FxSdSysAreaopen fxSdSysAreaopen : openSysAreasList) {
				FxAreaDto fxAreaDto = new FxAreaDto();
				fxAreaDto.setProvince(sysAreasServices.getOpenAreaAttribute((long)fxSdSysAreaopen.getProvince()));
				fxAreaDto.setCity(sysAreasServices.getOpenAreaAttribute((long)fxSdSysAreaopen.getCity()));
				fxAreaDto.setCounty(fxSdSysAreaopen.getName());
				fxAreaDto.setId(fxSdSysAreaopen.getId().intValue());
				list.add(fxAreaDto);
			}
			for (FxAreaDto fxAreaDto2 : list) {
				System.out.println(fxAreaDto2.toString());
			}
			info.setData(list);
			info.setMessage("Ok");
			return info;
		}
		return null;
	}
	@ApiOperation(value = "APP版本检查更新", httpMethod = "POST")
	@RequestMapping(value = "/getAppVersion")
	@ApiImplicitParams({@ApiImplicitParam(name="appType",value="APP类型1:超级跑腿,2:超级飞人",dataType="int"),
		@ApiImplicitParam(name="clientType",value="终端类型(ture:android,false:ios)",dataType="int")})
	@ResponseBody
	public RespBaseDto<FxSdSysVersion> getAppVersion(Integer appType,Boolean clientType){
		RespBaseDto<FxSdSysVersion> result = new RespBaseDto<FxSdSysVersion>();
		FxSdSysVersion version = fxSdSysVersionServices.CheackVersion(appType, clientType);
		if(version == null){
			version = new FxSdSysVersion();
			result.setMessage("未初始化版本");
			result.setState(0);
		}else{
			result.setMessage("SUCCESS");
		}
		result.setData(version);		
		return result;
	}
	
	
	
	@ApiOperation(value = "上传图片到服务器", httpMethod = "POST")
	@RequestMapping(value = "/UploadPicture")
	@ApiImplicitParams({ @ApiImplicitParam(name = "oldfileurl", value = "图片访问路径", dataType = "body") })
	@ResponseBody
	public RespBaseDto<Object> UploadPicture(@RequestParam("file") MultipartFile file) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		// 创建日期文件夹
		String path = "D:/aim/" + new SimpleDateFormat("yyyy/MM/").format(new Date());
		String pathFile =null;
		// 如果不存在,创建文件夹
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!file.isEmpty()) {
			try {
				//根路径
				pathFile = f.getPath()+"\\"+file.getOriginalFilename();
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(pathFile)));
				out.write(file.getBytes());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				result.setMessage("上传失败," + e.getMessage());
				return result;
			} catch (IOException e) {
				e.printStackTrace();
				result.setMessage("上传失败," + e.getMessage());
				return result;
			}
			result.setData(pathFile);
			result.setMessage("上传成功");
			result.setState(200);
			return result;
		} else {
			result.setMessage("上传失败，因为文件是空的.");
			return result;
		}

		
	}
}
