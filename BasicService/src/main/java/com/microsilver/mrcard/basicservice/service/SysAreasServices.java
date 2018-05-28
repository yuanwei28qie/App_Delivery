
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import com.microsilver.mrcard.basicservice.dao.FxSdSysAreaMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdSysAreaopenMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysArea;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaExample;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopen;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopenExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAreasServices {
		
	private final FxSdSysAreaMapper fxSdSysAreaMapper;
	
	private final FxSdSysAreaopenMapper fxSdSysAreaopenMapper;

	@Autowired
	public SysAreasServices(FxSdSysAreaMapper fxSdSysAreaMapper, FxSdSysAreaopenMapper fxSdSysAreaopenMapper) {
		this.fxSdSysAreaMapper = fxSdSysAreaMapper;
		this.fxSdSysAreaopenMapper = fxSdSysAreaopenMapper;
	}

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
		example.createCriteria().andCodeEqualTo(attribute.intValue());
		List<FxSdSysArea> list = fxSdSysAreaMapper.selectByExample(example);
		if(list!=null) {
			for (FxSdSysArea fxSdSysArea : list) {
				return fxSdSysArea.getName();
			}
		}
		return null;
	}

	
	
}
