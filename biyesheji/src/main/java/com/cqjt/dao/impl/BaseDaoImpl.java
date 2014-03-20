package com.cqjt.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cqjt.dao.BaseDao;


public class BaseDaoImpl extends SqlMapClientDaoSupport implements BaseDao {

	/**
	 * 添加
	 * @param entity
	 * @return
	 */
	@Override
	public Object insert(String sqlName, Object entity) throws DataAccessException {
		if (entity == null) {
			throw new IllegalArgumentException("插入数据库实体不能为空");
		} else {
			return getSqlMapClientTemplate().insert(sqlName, entity);
		}
	}

	/**
	 * 查询
	 * 
	 * @param selectName
	 * @param params
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> select(String sqlName, Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList(sqlName, params);
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
		getSqlMapClientTemplate().update(sqlName, entity);
		return true;
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
		return getSqlMapClientTemplate().delete(sqlName, params);
	}
	
	
	
	/**
	 * 查询单个数据
	 * 
	 * @param sqlName
	 * @param params
	 * @return
	 */
	public Integer deletebyPKOrID(String sqlName, Object pkorId) {
		return getSqlMapClientTemplate().delete(sqlName,pkorId);
	}

	
	/**
	 * 根据主键查询单个实体
	 * @param sqlName
	 * @param primaryKey
	 * @return Object
	 */
	@Override
	public Object find(String sqlName, Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForObject(sqlName, params);
	}
	
	

	
	/**
	 * 根据主键查询单个实体
	 * @param sqlName
	 * @param primaryKey
	 * @return Object
	 */
	@Override
	public Object findByPrimaryKey(String sqlName, Object primaryKey) throws DataAccessException {
		return getSqlMapClientTemplate().queryForObject(sqlName, primaryKey);
	}
	
	/**
	 * （deleteByPrimaryKey方法的名字没有取好）
	 * 根据主键删除单个实体
	 * @param sqlName
	 * @param primaryKey
	 * @return
	 */
	@Override
	public Integer deleteByPrimaryKey(String sqlName, Object primaryKey) throws DataAccessException {
		return getSqlMapClientTemplate().delete(sqlName, primaryKey);
	}
	
	
	/**
	 * 根据参数查询列表，参数可以为一个String
	 * @param sqlName
	 * @param params
	 * @return
	 * @throws DataAccessException
	 */
	@Override
	public List findList(String sqlName, Object params)  throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(sqlName, params);
	}
	
	/**
	 * 根据条件统计个数
	 * @param sqlName
	 * @param params
	 * @return
	 * @throws DataAccessException
	 */
	@Override
	public int getCount(String sqlName, Object params)  throws DataAccessException {
		return (Integer)getSqlMapClientTemplate().queryForObject(sqlName, params);
	}
}
