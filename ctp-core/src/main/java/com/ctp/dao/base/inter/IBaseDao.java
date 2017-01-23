package com.ctp.dao.base.inter;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ctp.dao.base.impl.ListPage;

public interface IBaseDao {
	/**
	 * 保存
	 * @param entity 
	 * @return
	 */
	<T> Serializable save(T entity);
	
	/**
	 * 批量保存
	 * @param entitys
	 */
	<T> void save(List<T> entitys);
	
	/**
	 * 更新
	 * @param entity
	 */
	<T> void update(T entity);
	
	<T> void meger(T entity);
	/**
	 * 更新
	 * @param hql
	 */
	void updateByHql(String hql);
	
	/**
	 * 更新
	 * @param hql
	 * @param parameters
	 */ 
	void updateByHql(String hql,Object... parameters);

	/**
	 * 更新
	 * @param hql
	 * @param map
	 */
	void updateByHql(String hql, Map<String,Object> map);
	
	/**
	 * 取得对象
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T load(Class<T> clazz,Serializable id);
	/**
	 * 取得对象
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T get(Class<T> clazz,Serializable id);
	/**
	 * 获取对象
	 * @param hql
	 * @return
	 */
	Object get(String hql);
	/**
	 * 取得对象
	 * @param hql
	 * @param parameters
	 * @return
	 */
	Object get(String hql,Object... parameters);
	Object getLimit(String hql,int first,int max,Object... parameters);
	/**
	 * 取得对象
	 * @param hql
	 * @param parameters
	 * @return
	 */
	Object get(String hql,Map<String,Object> parameters);
	/**
	 * 删除
	 * @param entity
	 */
	<T> void delete(T entity);
	
	/**
	 * 删除
	 * @param clazz
	 * @param id
	 */
	void delete(Class clazz,Serializable id);
	/**
	 * 删除全表
	 * @param clazz
	 */
	void deleteAll(Class clazz);
	
	/**
	 * 根据HQL删除
	 * @param hql
	 */
	void deleteByHql(String hql);
	void deleteBySql(String sql);
	/**
	 * 根据HQL删除
	 * @param hql
	 * @param parameters
	 */
	void deleteByHql(String hql,Object... parameters);
	void deleteBySql(String sql,Object... parameters);
	/**
	 * 根据HQL删除
	 * @param hql
	 * @param parameters
	 */
	void deleteByHql(String hql,Map<String,Object> parameters);
	void deleteBySql(String sql,Map<String,Object> parameters);
	/**
	 * 删除
	 * delete from beanName where field in (:ids)
	 * @param beanName 
	 * @param field 字段名称
	 * @param ids ID列表
	 */
	void delete(String beanName,String field,Object... ids);
	/**
	 * 删除
	 * delete from beanName where field not in (:ids)
	 * @param beanName
	 * @param field
	 * @param ids
	 */
	void deleteNoIn(String beanName,String field,Object... ids);
	
	/**
	 * 查询所有数据
	 * @param clazz
	 * @return
	 */
	<T> List queryAll(Class<T> clazz);
	/**
	 * 查询数据
	 * @param hql
	 * @param parameters
	 * @return
	 */
	<T,V> List<V> query(String hql,T...parameters);
	List queryLimit(String hql,int first,int max,Object...parameters);
	/**
	 * 查询数据
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List queryBySql(String sql,Object...parameters);
	List queryBySqlLimit(String sql,int first,int max,Object...parameters);
	/**
	 * 查询数据
	 * @param hql
	 * @param parameters
	 * @return
	 */
	List query(String hql,Map<String,Object> parameters);
	List queryLimit(String hql,Map<String, Object> parameters,int first,int max);
	/**
	 * 查询数据
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List queryBySql(String sql,Map<String,Object> parameters);
	List queryBySqlLimit(String sql,Map<String, Object> parameters,int first,int max);
	/**
	 * 取得总数量
	 * @param countHql
	 * @return
	 */
	int getCount(String countHql);
	/**
	 * 取得总数
	 * @param countHql
	 * @param parameters
	 * @return
	 */
	int getCount(String countHql,Object... parameters);
	/**
	 * 取得总数
	 * @param countHql
	 * @param parameters
	 * @return
	 */
	int getCount(String countHql,Map<String,Object> parameters);
	
	/**
	 * 取得总数
	 * @param countSql
	 * @param parameters
	 * @return
	 */
	int getCountBySql(String countSql,Map<String,Object> parameters);
	/**
	 * 分页查询
	 * @param pageNo 查询页
	 * @param pageSize 查询页数据条数
	 * @param countHql 查询总数HQL语句
	 * @param queryHql 查询数据HQL语句
	 * @return
	 */
	ListPage queryByHql(int pageNo,int pageSize,String countHql,String queryHql);
	ListPage queryByHql(int pageNo,int pageSize,String countHql,String queryHql,Map<String,Object> parameters);
	/**
	 * 分页查询
	 * @param pageNo 查询页
	 * @param pageSize 查询页数据条数
	 * @param countHql 查询总数SQL语句
	 * @param queryHql 查询数据SQL语句
	 * @param parameters 查询绑定参数
	 * @return
	 */
	ListPage queryBySql(int pageNo,int pageSize,String countHql,String queryHql,Map<String,Object> parameters);

	/**
	 * 更新
	 * @param sql
	 */
	void updateBySql(String sql);

	/**
	 * 更新
	 * @param sql
	 * @param parameters
	 */
	<T> void updateBySql(String sql, T... parameters);

	/**
	 * 更新
	 * @param sql
	 * @param parameters
	 */
	<T, V> void  updateBySql(String sql, Map<T, V> parameters);
	
	/**
	 * 保存或更新
	 * @param obj
	 */
	<T> void saveOrUpdate(T obj);
}
