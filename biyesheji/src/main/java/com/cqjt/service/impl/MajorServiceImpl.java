package com.cqjt.service.impl;

import java.util.List;

import javax.jws.WebService;

import com.cqjt.pojo.Major;
import com.cqjt.service.MajorService;


//@Service(value="majorService")
@WebService(endpointInterface = "com.cqjt.service.MajorService", serviceName = "majorService")
public class MajorServiceImpl extends BaseServiceImpl implements MajorService {

/*	@Resource(name = "majorDAO")
	private IMajorDAO majorDAO;*/
	
	/**
	 * 得到所有XX列表
	 */
	@Override
	public List<Major> getMajorList() {
		String sqlName = "getallmajor";
		List<Major> majors=(List<Major>) super.select(sqlName, null);//majorDAO.getAllMajor();
		System.out.println("majors=="+majors.size());
		return majors;
	}
	public static void main(String[] args) {
		int i =(new MajorServiceImpl()).getMajorList().size();
		System.out.println(i);
	}
	@Override
	public boolean addMajor(Major major) {
		 Object object=insert("addMajor", major);
		return (Boolean) object;
	}
}
