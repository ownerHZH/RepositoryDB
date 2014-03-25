package com.cqjt.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

import com.cqjt.pojo.Curriculum;
import com.cqjt.service.ICurriculumService;

/**
 * 大纲服务层
 * @author Owner
 *
 */

@Service(value="curriculumService")
//@WebService(endpointInterface = "com.cqjt.service.ICurriculumService", serviceName = "curriculumService")
public class CurriculumServiceImpl extends BaseServiceImpl implements ICurriculumService {

	@Override
	public List<Curriculum> getAllCurriculum() {
		@SuppressWarnings("unchecked")
		List<Curriculum> coList=(List<Curriculum>) super.select("getAllCurriculum", null);
		return coList;
	}


	@Override
	public Curriculum getCurriculumByCode(int code) {
		HashMap<String, Object> params=new HashMap<String, Object>();
		params.put("curriculum_code", code);
		Curriculum c=(Curriculum) super.find("getCurriculumByCode", params);
		return c;
	}


	@Override
	public boolean addCurriculum(Curriculum curriculum) {
		Object o=super.insert("addCurriculum", curriculum);
		return o==null?false:true;
	}


	@Override
	public boolean updateCurriculum(Curriculum curriculum) {
		Object o=super.update("updateCurriculum", curriculum);
		return o==null?false:true;
	}


	@Override
	public boolean deleteCurriculum(Curriculum curriculum) {
		HashMap<String, Object> params=new HashMap<String, Object>();
		params.put("curriculum_code", curriculum.getCurriculum_code());
		Object o=super.delete("deleteCurriculum", params);
		return o==null?false:true;
	}

}
