package com.cqjt.service;

import java.util.List;

import com.cqjt.pojo.Major;


public interface MajorService extends BaseService{
	/**
	 * 获取所有的专业名称
	 * @return
	 */
  public List<Major> getMajorList();
  
  /**
   * 添加专业
   * @param major
   */
  public boolean addMajor(Major major);
}
