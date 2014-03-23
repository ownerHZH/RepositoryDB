package com.cqjt.service;

import java.util.List;
import java.util.Map;

public interface BaseService {

	/**
	 * 添加
	 * 
	 * @param entity
	 * @return
	 */
	public Object insert(String sqlName, Object entity);

	/**
	 * 查询
	 * 
	 * @param selectName
	 * @param params
	 * @return
	 */
	public List<?> select(String sqlName, Map<String, Object> params);

	/**
	 * 更新
	 * 
	 * @param updateName
	 * @param entity
	 * @param id
	 * @return
	 */
	public boolean update(String sqlName, Object entity);

	/**
	 * 删除
	 * 
	 * @param delete
	 * @param id
	 * @return
	 */
	public Integer delete(String sqlName, Map<String, Object> params);

	/**
	 * 查询单个数据
	 * 
	 * @param sqlName
	 * @param params
	 * @return
	 */
	public Object find(String sqlName, Map<String, Object> params);
	
	/**
	 * 通过sql更新
	 * @param sql
	 * @return
	 */
	public boolean updateBySql(String sql);
	
	/**
	 * 通过sql删除
	 * @param sql
	 * @return
	 */
	public int deleteBySql(String sql);
 
	
	/**
	 * 根据条件统计个数
	 * @param sqlName
	 * @param params
	 * @return
	 */
	public int getCount(String sqlName, Object params);
	
	/**
	 * 批量插入数据
	 * @author Owner
	 * @param sqlName
	 * @param list
	 */
	public void insert(String sqlName, List<?> list);
	
	/**
	 * 批量删除数据
	 * @author Owner
	 * @param sqlName
	 * @param list
	 */
	public void delete(String sqlName, List<?> list);
	
	/**
	 * 批量更新
	 * @author Owner
	 * @param sqlName
	 * @param list
	 */
	public void update(String sqlName, List<?> list);
}
