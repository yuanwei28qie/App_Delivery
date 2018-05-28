package com.microsilver.mrcard.basicservice.controller;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.dto.*;
import com.microsilver.mrcard.basicservice.model.FxSdSysArea;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopen;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersion;
import com.microsilver.mrcard.basicservice.model.MobileCheckCode;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.FxSdSysVersionServices;
import com.microsilver.mrcard.basicservice.service.SysAreasServices;
import com.microsilver.mrcard.basicservice.utils.JuheMsg;
import com.microsilver.mrcard.basicservice.vo.MobileVo;
import com.microsilver.mrcard.basicservice.vo.VersionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(value = "/api/Common", description = "通用方法API")
@RestController
@RequestMapping("/api/Common")
@SuppressWarnings("unchecked")
public class CommonController extends BaseController {

	private final SysAreasServices sysAreasServices;

	private final FxSdSysVersionServices fxSdSysVersionServices;

	private final StringRedisTemplate stringRedisTemplate;

	private final RedisTemplate redisTemplate;

	@Autowired
	public CommonController(SysAreasServices sysAreasServices, FxSdSysVersionServices fxSdSysVersionServices, StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate) {
		this.sysAreasServices = sysAreasServices;
		this.fxSdSysVersionServices = fxSdSysVersionServices;
		this.stringRedisTemplate = stringRedisTemplate;
		this.redisTemplate = redisTemplate;
	}


	@ApiOperation(value = "发送短信验证码并保存", httpMethod = "POST")
	@RequestMapping( value = "/sendAndSaveCheckCode", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RespBaseDto<CheckCodeDto> sendAndSaveCheckCode(
			@RequestBody MobileVo mobileVo
	) {
		RespBaseDto<CheckCodeDto> result = new RespBaseDto<>();
		Long mobile = mobileVo.getMobile();
		short type = mobileVo.getType();
		try {
			if (mobile != null ) {
				//CheckBasicMsg.checkMobile(mobile+"")
				if(true){
					// 生成验证码
					String checkCode = (Math.random() + "").substring(2, 8);
					// 存入redis中.一分钟过期
					MobileCheckCode mobileCheckCode = new MobileCheckCode();
					mobileCheckCode.setCheckCode(Integer.parseInt(checkCode));
					mobileCheckCode.setMobile(mobile);
					mobileCheckCode.setType(type);
					redisTemplate.opsForValue().set(mobile,mobileCheckCode,60,TimeUnit.SECONDS);
					JuheMsg.sendMsg(mobile+"", checkCode);
					CheckCodeDto checkCodeDto = new CheckCodeDto();
					checkCodeDto.setMobile(mobile+"");
					checkCodeDto.setCheckCode(checkCode);
					result.setData(checkCodeDto);
					result.setMessage("发送成功");
					result.setState(200);
					return result;
				}else{
					result.setData(new CheckCodeDto());
					result.setMessage(EWarning.MobileNotConformingToSpecifications.getName());
					result.setState(EWarning.MobileNotConformingToSpecifications.getValue());
				}
			}else{
				result.setData(new CheckCodeDto());
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			}
		} catch (Exception e) {
			logger.error("sendAndSaveCheckCode error:{}", e.getMessage());
			result.setMessage(EWarning.Unknown.getName() + e.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取服务器时间", httpMethod = "POST")
	@PostMapping(value = "/getSysTime",produces ="application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<String> getSysTime() {
		RespBaseDto<String> result = new RespBaseDto<>();
		result.setData(String.valueOf(System.currentTimeMillis()));
		result.setMessage("OK");
		return result;
	}


	@ApiOperation(value = "获取全部区域", httpMethod = "POST")
	@PostMapping(value = "/getAllArea",produces ="application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<AllAreaDto>> getAllArea()  {
		RespBaseDto<List<AllAreaDto>> result = new RespBaseDto<>();
		List<AllAreaDto> listAllArea = new ArrayList<>();
		try {
			List<FxSdSysArea> allArea = sysAreasServices.getAllSysAreas();
			if(allArea!=null){
				for (FxSdSysArea area:
						allArea ) {
					AllAreaDto allAreaDto = new AllAreaDto();
					allAreaDto.setId(area.getId());
					allAreaDto.setCode((long)area.getCode());
					allAreaDto.setLevel((short)area.getLevel().intValue());
					allAreaDto.setName(area.getName());
					allAreaDto.setParentCode((long)area.getParentCode());
					listAllArea.add(allAreaDto);
				}
				result.setData(listAllArea);
			}else{
				result.setMessage(EWarning.Unknown.getName());
				result.setState(EWarning.Unknown.getValue());
				result.setData(listAllArea);
			}
		} catch (Exception ex) {
			logger.error("getAllArea error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "获取已开通区域", httpMethod = "POST")
	@PostMapping(value = "/getOpenArea",produces ="application/json;charset=UTF-8")
	@ResponseBody
	public RespBaseDto<List<FxAreaDto>> getOpenArea()  {
		RespBaseDto<List<FxAreaDto>> result = new RespBaseDto<>();
		List<FxAreaDto> list = new ArrayList<>();
		try {
			List<FxSdSysAreaopen> openSysAreasList = sysAreasServices.getOpenSysAreas();
			if (openSysAreasList != null) {
				for (FxSdSysAreaopen fxSdSysAreaopen : openSysAreasList) {
					FxAreaDto fxAreaDto = new FxAreaDto();
					fxAreaDto.setProvince(sysAreasServices.getOpenAreaAttribute((long) fxSdSysAreaopen.getProvince()));
					fxAreaDto.setCity(sysAreasServices.getOpenAreaAttribute((long) fxSdSysAreaopen.getCity()));
					fxAreaDto.setCounty(fxSdSysAreaopen.getName());
					fxAreaDto.setCityNum(fxSdSysAreaopen.getCity()+"");
					fxAreaDto.setCountyNum(fxSdSysAreaopen.getCounty()+"");
					fxAreaDto.setProvinceNum(fxSdSysAreaopen.getProvince()+"");
					fxAreaDto.setId(fxSdSysAreaopen.getId().intValue());
					list.add(fxAreaDto);
				}
				result.setData(list);
				result.setMessage("Ok");
				result.setState(200);
			}else{
				result.setData(null);
				result.setMessage(EWarning.NoAreaMsg.getName());
				result.setState(EWarning.NoAreaMsg.getValue());
			}
		} catch (Exception ex) {
			logger.error("getOpenArea error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName() + ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@ApiOperation(value = "APP版本检查更新", httpMethod = "POST")
	@ResponseBody
	@PostMapping(value = "/getAppVersion",produces ="application/json;charset=UTF-8")
	public RespBaseDto<VersionDto> getAppVersion(
			@RequestBody VersionVo versionVo
		) {
		RespBaseDto<VersionDto> result = new RespBaseDto<>();
		try {
			VersionDto versionDto = new VersionDto();
			FxSdSysVersion version = fxSdSysVersionServices.checkVersion(versionVo.getAppType(), versionVo.getClientType());
			if (version == null ) {
				result.setMessage(EWarning.UninitializedVersion.getName());
				result.setState(EWarning.UninitializedVersion.getValue());
				result.setData(versionDto);
			} else {
				versionDto.setId(version.getId());
				versionDto.setAppType(version.getAppType());
				versionDto.setClientType(version.getClientType());
				versionDto.setCode(version.getCode());
				versionDto.setDescription(version.getDescription());
				versionDto.setIsForce(version.getIsForce().shortValue());
				versionDto.setCode(version.getCode());
				versionDto.setDownAddress(version.getDownDdress());
				versionDto.setVersion(version.getVersion());
				result.setMessage("ok");
				result.setData(versionDto);
				result.setState(200);
			}
		}catch(Exception ex) {
			logger.error("getAppVersion error:{}", ex.getMessage());
			result.setMessage(EWarning.Unknown.getName()+ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "上传图片到服务器", httpMethod = "POST")
	@RequestMapping(value = "/UploadPicture")
	@ResponseBody
	public RespBaseDto<PrctureDto> uploadPicture(@RequestParam("file") MultipartFile file) {
		RespBaseDto<PrctureDto> result = new RespBaseDto<>();

		PrctureDto prctureDto = new PrctureDto();
		// 创建日期文件夹
		String path = Consts.PICTURES_ADDRESS +File.separator+ new SimpleDateFormat("MM/").format(new Date());
		String pathFile =  null;
		// 如果不存在,创建文件夹
		File f = new File(path);
		UUID uuid = UUID.randomUUID();
		System.out.println("path:"+path);
		if (!f.exists()) {
				f.mkdirs();
			}
		if (!file.isEmpty()) {
				try {
					// 根路径
					//File.separator 根据系统下识别分割器
					String fileName = file.getOriginalFilename();
					pathFile = f.getPath() + File.separator + uuid+"."+fileName.substring(fileName.lastIndexOf(".")+1);
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(pathFile)));
					out.write(file.getBytes());
					out.flush();
					out.close();
					//http://211.149.164.182/uploads2018/05/ea7779fc-5f8c-43e5-88fe-95c862a2fcef.png
					//new SimpleDateFormat("MM/").format(new Date()
					prctureDto.setPictureUrl("http://211.149.164.182/uploads2018/"+File.separator+new SimpleDateFormat("MM/").format(new Date())+File.separator+uuid+"."+fileName.substring(fileName.lastIndexOf(".")+1));
					result.setData(prctureDto);
					result.setMessage("上传成功");
					result.setState(200);
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					result.setData(prctureDto);
					result.setMessage("上传失败," + e.getMessage());
					result.setState(2100);
					return result;
				}
			} else {
				result.setData(prctureDto);
				result.setMessage("上传失败，因为文件是空的.");
				result.setState(2100);
				return result;
			}
		
	}
}
