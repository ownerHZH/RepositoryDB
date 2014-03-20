package com.cqjt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.cqjt.dao.BaseDao;
import com.cqjt.service.BaseService;


public class BaseServiceImpl implements BaseService {

	@Autowired
	private BaseDao baseDao;

	/**
	 * 添加
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public Object insert(String sqlName, Object entity) {

		return baseDao.insert(sqlName, entity);
	}

	/**
	 * 查询
	 * 
	 * @param selectName
	 * @param params
	 * @return
	 */
	@Override
	public List<?> select(String sqlName, Map<String, Object> params) {
		return baseDao.select(sqlName, params);
	}

	/**
	 * 更新
	 * 
	 * @param updateName
	 * @param entity
	 * @param id
	 * @return
	 */
	@Override
	public boolean update(String sqlName, Object entity) {
		return baseDao.update(sqlName, entity);
	}

	/**
	 * 删除
	 * 
	 * @param delete
	 * @param id
	 * @return
	 */
	@Override
	public Integer delete(String sqlName, Map<String, Object> params) {
		return baseDao.delete(sqlName, params);
	}

	/**
	 * 查询单个数据
	 * 
	 * @param sqlName
	 * @param params
	 * @return
	 */
	@Override
	public Object find(String sqlName, Map<String, Object> params) {
		return baseDao.find(sqlName, params);
	}

	
	/**
	 * 通过sql更新
	 * @param sql
	 * @return
	 */
	@Override
	public boolean updateBySql(String sql) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sql", sql);
		return baseDao.update("exesql.update", map); 
	}

	
	/**
	 * 通过sql删除
	 * @param sql
	 * @return
	 */
	@Override
	public int deleteBySql(String sql) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sql", sql);
		return baseDao.delete("exesql.update", map);
	}

		
	
	/**
	 * 根据条件统计个数
	 * @param sqlName
	 * @param params
	 * @return
	 */
	@Override
	public int getCount(String sqlName, Object params) {
		return baseDao.getCount(sqlName, params);
	}
	
}
