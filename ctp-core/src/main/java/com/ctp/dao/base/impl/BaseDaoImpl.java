package com.ctp.dao.base.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ctp.dao.base.impl.UQueryLoadingUtil.UQuery;
import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;


//继承了HibernateDaoSupport就不能用注解的方式注入，会报错，只能用配置文件注入
public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

	private final static Logger log = Logger.getLogger(BaseDaoImpl.class);
	
	/*因为setSessionFactory不能被重写，这里只能用注解的方式注入*/
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//vdissa.kingdee.com
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	} 
	
	private void checkNull(Object o){
		if(o == null)
			throw new NullPointerException();
	}
	private void checkEmpty(String s){
		if(s == null || s.length() == 0)
			throw new NullPointerException();
	}
	
	public <T> Serializable save(T entity) {
		this.checkNull(entity);
		return this.getSession().save(entity);
	}
	
	public <T> void save(List<T> entitys){
		this.checkNull(entitys);
		for(int i=0,size=entitys.size();i<size;i++){
			this.save(entitys.get(i));
		} 
	}
	
	public <T> void update(T entity){
		this.checkNull(entity);
		this.getSession().update(entity);
	}
	public void updateByHql(String hql){
		this.checkEmpty(hql);
		this.getSession().createQuery(hql).executeUpdate();
	}
	public void updateByHql(String hql,Object... parameters){
		this.checkEmpty(hql);
		UQuery uq = UQueryLoadingUtil.loadingString(hql);
		Query query = this.getSession().createQuery(uq.getSql());
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(),parameters);
		}
		query.executeUpdate();
	}
	public void updateByHql(String hql,Map<String,Object> parameters){
		this.checkEmpty(hql);
		Query query = this.getSession().createQuery(hql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		query.executeUpdate();
	}
	
	public void updateBySql(String sql){
		this.checkEmpty(sql);
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	
	public <T> void updateBySql(String sql, T... parameters){
		this.checkEmpty(sql);
		UQuery uq = UQueryLoadingUtil.loadingString(sql);
		Query query = this.getSession().createSQLQuery(uq.getSql());
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(), parameters);
		}
		query.executeUpdate();
	}
	
	public <T,V> void updateBySql(String sql,Map<T,V> parameters){
		this.checkEmpty(sql);
		Query query = this.getSession().createSQLQuery(sql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		query.executeUpdate();
	}
	
	
	
	 public <T> T load(Class<T> clazz,Serializable id){
		this.checkNull(clazz);
		return id == null ? null : this.getSession().load(clazz, id);
	}
	
	/**
	 * 取得对象
	 * @param clazz
	 * @param id
	 * @return
	 * 直接从数据库索引，如果不存在则返回null
	 */
	
	public <T> T get(Class<T> clazz, Serializable id){
		this.checkNull(clazz);
		return id == null ? null : (T)this.getSession().get(clazz, id);
	}
	
	/**
	 * 获取对象
	 * @param hql
	 * @return
	 */
	
	public Object get(String hql){
		this.checkEmpty(hql);
		List<?> list = this.getSession().createQuery(hql).list();
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}
	
	/**
	 * 取得对象
	 * @param hql
	 * @param parameters
	 * @return
	 */
	
	public Object get(String hql,Object... parameters){
		List list = this.query(hql, parameters);
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	public Object getLimit(String hql, int first, int max, Object... parameters) {
		List list = this.queryLimit(hql,first,max,parameters);
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}
	
	/**
	 * 取得对象
	 * @param hql
	 * @param parameters
	 * @return
	 */
	
	public Object get(String hql,Map parameters){
		List list = this.query(hql,parameters);
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	
	public <T> void delete(T entity){
		if(entity != null) this.getSession().delete(entity);
	}
	
	/**
	 * 删除
	 * @param clazz 
	 * @param id 主键
	 */ 
	
	public void delete(Class clazz,Serializable id){
		if(clazz != null && id != null){
			Object t = this.get(clazz, id);
			if(t != null) this.getSession().delete(t);
		}
	}
	
	/**
	 * 删除全表
	 * @param clazz
	 */
	
	public void deleteAll(Class clazz){
		if(clazz == null) return ;
		this.getSession().createQuery("DELETE " + clazz.getName()).executeUpdate();
	}
	
	public void deleteByHql(String hql){
		this.updateByHql(hql);
	}
	
	public void deleteBySql(String sql){
		this.updateBySql(sql);
	}
	/**
	 * 根据HQL删除
	 * @param hql
	 * @param parameters
	 */
	
	public void deleteByHql(String hql,Object... parameters){
		this.updateByHql(hql, parameters);
	}
	
	public void deleteBySql(String sql,Object... parameters){
		this.updateBySql(sql, parameters);
	}
	/**
	 * 根据HQL删除
	 * @param hql
	 * @param parameters
	 */
	
	public void deleteByHql(String hql,Map parameters){
		this.updateByHql(hql, parameters);
	}
	public void deleteBySql(String sql,Map parameters){
		this.updateBySql(sql, parameters);
	}
	
	/** 
	 * 删除
	 * delete from beanName where field in (:ids)
	 * @param beanName 
	 * @param field 字段名称
	 * @param ids ID列表
	 */
	
	public void delete(String beanName,String field,Object... ids){
		if(beanName == null || beanName.length() == 0
				|| field == null || field.length() == 0 
				|| ids == null || ids.length < 1) return ;
		StringBuffer hql = new StringBuffer("DELETE FROM ");
		hql.append(beanName).append(" WHERE ").append(field);
		hql.append(" IN (:ids)");
		this.getSession().createQuery(hql.toString()).setParameterList("ids", ids).executeUpdate();
	}
	
	/**
	 * 删除
	 * delete from beanName where field not in (:ids)
	 * @param beanName
	 * @param field
	 * @param ids
	 */
	
	public void deleteNoIn(String beanName,String field,Object... ids){
		if(beanName == null || beanName.length() == 0
				|| field == null || field.length() == 0 
				|| ids == null || ids.length < 1) return ;
		StringBuffer hql = new StringBuffer("DELETE FROM ");
		hql.append(beanName).append(" WHERE ").append(field);
		hql.append(" NOT IN (:ids)");
		this.getSession().createQuery(hql.toString()).setParameterList("ids", ids).executeUpdate();
	}
	
	/**
	 * 查询所有数据
	 * @param clazz
	 * @return
	 */
	
	public List queryAll(Class clazz){
		if(clazz == null) return null;
		return this.getSession().createQuery("FROM " + clazz.getName()).list();
	}
	
	/**
	 * 查询
	 * @param hql
	 * @param parameters
	 * @return
	 */
	
	public <T,V> List<V> query(String hql,T... parameters){
		this.checkEmpty(hql);
		UQuery uq = UQueryLoadingUtil.loadingString(hql);
		Query query = this.getSession().createQuery(uq.getSql());
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(), parameters);
		}
		return query.list();
	}
	
	
	public List queryLimit(String hql,int first,int max,Object...parameters){
		this.checkEmpty(hql);
		UQuery uq = UQueryLoadingUtil.loadingString(hql);
		Query query = this.getSession().createQuery(uq.getSql());
		query.setFirstResult(first);
		query.setMaxResults(max);
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(), parameters);
		}
		return query.list();
	}

	/**
	 * 查询
	 * @param 原生sql
	 * @param parameters
	 * @return
	 */
	
	public List queryBySql(String sql,Object... parameters){
		this.checkEmpty(sql);
		UQuery uq = UQueryLoadingUtil.loadingString(sql);
		Query query = this.getSession().createSQLQuery(uq.getSql());
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(),parameters);
		}
		return query.list();
	}
	
	public List queryBySqlLimit(String sql,int first,int max,Object... parameters){
		this.checkEmpty(sql);
		UQuery uq = UQueryLoadingUtil.loadingString(sql);
		Query query = this.getSession().createSQLQuery(uq.getSql());
		query.setFirstResult(first);
		query.setMaxResults(max);
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(),parameters);
		}
		return query.list();
	}
	
	/**
	 * 查询
	 * @param hql
	 * @param parameters
	 * @return
	 */
	
	public List query(String hql,Map parameters){
		if(hql == null || hql.length() == 0) return null;
		Query query = this.getSession().createQuery(hql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		return query.list();
	}
	
	public List queryLimit(String hql,Map<String, Object> parameters,int first,int max){
		if(hql == null || hql.length() == 0) return null;
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		return query.list();
	}
	/**
	 * 查询
	 * @param 原生sql
	 * @param parameters
	 * @return
	 */
	
	public List queryBySql(String sql,Map parameters){
		this.checkEmpty(sql);
		Query query = this.getSession().createSQLQuery(sql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		return query.list();
	}
	
	
	public List queryBySqlLimit(String sql,Map<String, Object> parameters,int first,int max){
		this.checkEmpty(sql);
		Query query = this.getSession().createSQLQuery(sql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		return query.list();
	}
	
	/**
	 * 取得总数量
	 * @param countHql
	 * @return
	 */
	
	public int getCount(String countHql){
		this.checkEmpty(countHql);
		Query query = this.getSession().createQuery(countHql);
		List<Long> list = query.list();
		if(list != null && list.size() > 0)
			return list.get(0).intValue();
		return 0;
	}

	/**
	 * 取得总数
	 * @param countHql
	 * @param parameters
	 * @return
	 */
	
	public int getCount(String countHql, Object... parameters) {
		this.checkEmpty(countHql);
		UQuery uq = UQueryLoadingUtil.loadingString(countHql);
		Query query = this.getSession().createQuery(uq.getSql());
		if(parameters != null){
			UQueryLoadingUtil.loadingObjectParameters(query, uq.getParams(), parameters);
		}
		List<Long> list = query.list();
		if(list != null && list.size() > 0)
			return list.get(0).intValue();
		return 0;
	}

	/**
	 * 取得总数
	 * @param countHql
	 * @param parameters
	 * @return
	 */
	
	public int getCount(String countHql, Map parameters) {
		this.checkEmpty(countHql);
		Query query = this.getSession().createQuery(countHql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		List<Long> list = query.list();
		if(list != null && list.size() > 0)
			return list.get(0).intValue();
		return 0;
	}
	
	/**
	 * 取得总数
	 * @param countSql
	 * @param parameters
	 * @return
	 */
	
	public int getCountBySql(String countSql,Map parameters){
		this.checkEmpty(countSql);
		Query query = this.getSession().createSQLQuery(countSql);
		if(parameters != null){
			UQueryLoadingUtil.loadingMapParameters(query, parameters);
		}
		return ((BigInteger)query.uniqueResult()).intValue();
	}
	
	
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param countHql
	 * @param queryHql
	 * @param parameters
	 * @return
	 */
	public ListPage queryByHql(int pageNo,int pageSize,String countHql,String queryHql){
		return queryByHql(pageNo,pageSize,countHql,queryHql,null);
	}
	public ListPage queryByHql(int pageNo,int pageSize,String countHql,String queryHql,Map parameters){
		try {
			//初始化ListPage
			ListPage listPage = ListPage.createEmpty(pageNo);
			if(countHql == null || countHql.length() == 0
					|| queryHql == null || queryHql.length() == 0) return listPage;
			if(pageNo < 1) pageNo = 1;
			if(pageSize < 1) pageSize = 1;
			//取得总条数
			int totalCount = this.getCount(countHql, parameters);
			if(totalCount < 1) return listPage;//没有找到数据
			
			//计算总页数
			int totalPageCount = (int)((totalCount -1)/pageSize + 1);
			if(pageNo > totalPageCount) return listPage;//超出了可查询的范围
			
			//计算第一条从哪里开始
			int firstResultIndex = (pageNo -1)*pageSize;
			if(firstResultIndex > totalCount) return listPage;//超出了可查询范围
				
			Query query = this.getSession().createQuery(queryHql);
			//设置参数
			if(parameters != null){
				UQueryLoadingUtil.loadingMapParameters(query, parameters);
			}
			query.setFirstResult(firstResultIndex);
			query.setMaxResults(pageSize);
			List<Object> list = query.list();
			int size = list == null ? 0 : list.size();
			listPage = new ListPage();//重新生成
			listPage.setCurrentPageNo(pageNo);
			listPage.setCurrentPageSize(size);
			listPage.setTotalCount(totalCount);
			listPage.setTotalPageCount(totalPageCount);
			listPage.setDataList(list);
			return listPage;
		} catch (Exception e) { 
			log.error("分页查询", e);
			return ListPage.createEmpty(pageNo);
		}
	}
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param countSql
	 * @param querySql
	 * @param parameters
	 * @return
	 */
	
	public ListPage queryBySql(int pageNo,int pageSize,String countSql,String querySql,Map parameters){
		try {
			//初始化ListPage
			ListPage listPage = ListPage.createEmpty(pageNo);
			if(countSql == null || countSql.length() == 0
					|| querySql == null || querySql.length() == 0) return listPage;
			if(pageNo < 1) pageNo = 1;
			if(pageSize < 1) pageSize = 1;
			//取得总条数
			int totalCount = this.getCountBySql(countSql, parameters);
			if(totalCount < 1) return listPage;//没有找到数据
			
			//计算总页数
			int totalPageCount = (int)((totalCount -1)/pageSize + 1);
			if(pageNo > totalPageCount) return listPage;//超出了可查询的范围
			
			//计算第一条从哪里开始
			int firstResultIndex = (pageNo -1)*pageSize;
			if(firstResultIndex > totalCount) return listPage;//超出了可查询范围
				
			Query query = this.getSession().createSQLQuery(querySql);
			//设置参数
			if(parameters != null){
				UQueryLoadingUtil.loadingMapParameters(query, parameters);
			}
			query.setFirstResult(firstResultIndex);
			query.setMaxResults(pageSize);
			List<Object> list = query.list();
			listPage = new ListPage();//重新生成
			listPage.setCurrentPageNo(pageNo);
			listPage.setCurrentPageSize(list == null ? 0 : list.size());
			listPage.setTotalCount(totalCount);
			listPage.setTotalPageCount(totalPageCount);
			listPage.setDataList(list);
			return listPage;
		} catch (Exception e) {
			log.error("分页查询出错", e);
			return ListPage.createEmpty(pageNo);
		}
	}

	
	public <T> void saveOrUpdate(T obj) {
		this.getSession().saveOrUpdate(obj);;
	}

	
	public <T> void meger(T entity) {
		this.getSession().merge(entity);
	}
	
}
