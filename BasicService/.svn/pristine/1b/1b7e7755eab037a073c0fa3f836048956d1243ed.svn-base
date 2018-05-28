/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdSysAreaMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdSysAreaopenMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysArea;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaExample;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopen;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopenExample;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.SysAreasServices
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月2日 上午9:29:48
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class SysAreasServices {
		
	@Autowired
	private FxSdSysAreaMapper fxSdSysAreaMapper;
	
	@Autowired
	private FxSdSysAreaopenMapper fxSdSysAreaopenMapper;
	
	public List<FxSdSysArea> getAllSysAreas(){
		
		FxSdSysAreaExample example = new FxSdSysAreaExample();
		return fxSdSysAreaMapper.selectByExample(example);
	}
	
	
	public List<FxSdSysAreaopen> getOpenSysAreas(){
		
		FxSdSysAreaopenExample example = new FxSdSysAreaopenExample();
		return fxSdSysAreaopenMapper.selectByExample(example);
	}
	
	public String getOpenAreaAttribute (Long attribute) {
		FxSdSysAreaExample example = new FxSdSysAreaExample();
		example.createCriteria().andCodeEqualTo(attribute);
		List<FxSdSysArea> list = fxSdSysAreaMapper.selectByExample(example);
		if(list!=null) {
			for (FxSdSysArea fxSdSysArea : list) {
				return fxSdSysArea.getName();
			}
		}
		return null;
	}

	
	
}
