package com.cqjt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface BaseDao {

	/**
	 * 添加
	 * 
	 * @param entity
	 * @return
	 */
	public Object insert(String sqlName, Object entity) throws DataAccessException;

	/**
	 * 查询
	 * 
	 * @param selectName
	 * @param params
	 * @return
	 */
	public List<Object> select(String sqlName, Map<String, Object> params);

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
	 * 根据主键查询单个实体
	 * @param sqlName
	 * @param primaryKey
	 * @return Object
	 */
	public Object findByPrimaryKey(String sqlName, Object primaryKey) throws DataAccessException;
	
	/**
	 * 根据主键删除单个实体
	 * @param sqlName
	 * @param primaryKey
	 * @return
	 */
	public Integer deleteByPrimaryKey(String sqlName, Object primaryKey) throws DataAccessException;
	
	/**
	 * 根据参数查询列表，参数可以为一个String
	 * @param sqlName
	 * @param params
	 * @return
	 * @throws DataAccessException
	 */
	public List findList(String sqlName, Object params)  throws DataAccessException;
	
	
	/**
	 * 根据条件统计个数
	 * @param sqlName
	 * @param params
	 * @return
	 * @throws DataAccessException
	 */
	public int getCount(String sqlName, Object params)  throws DataAccessException;
}
