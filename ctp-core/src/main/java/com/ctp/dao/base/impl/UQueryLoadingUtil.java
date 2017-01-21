package com.ctp.dao.base.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;

/**
 * 扩展Query方法
 * @author zms
 * @date 2014年10月14日	
 * @description
 */
public class UQueryLoadingUtil {
	
	public static class UQuery{
		private ArrayList<String> params;
		private String sql;
		public UQuery(ArrayList<String> params,String sql){
			this.params = params;
			this.sql = sql;
		}
		public ArrayList<String> getParams(){
			return this.params;
		}
		public String getSql(){
			return this.sql;
		}
	}
	
	public final static UQuery loadingString(String sql){
		ArrayList<String> params = new ArrayList<String>();
		StringBuilder str = new StringBuilder(sql);
		int fromIndex = 0;
		while(true){
			int index = str.indexOf("?",fromIndex-1);
			if(index == -1) break;
			str = str.replace(index, index+1, ":q"+index);
			params.add("q"+index);
			fromIndex = index;
		}
		return new UQuery(params, str.toString());
	}
	
	public final static void loadingMapParameters(Query query ,Map parameters){
		if(parameters == null) return ;
		for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			if(name == null || name.length() == 0) continue;
			Object value = parameters.get(name);
			if(value == null) continue;
			if (value instanceof String) {
				query.setString(name , (String)value);
			} else if (value instanceof Integer) {
				query.setInteger(name , ( (Integer)value ).intValue());	
			} else if (value instanceof Long) {
				query.setLong(name, ( (Long)value ).longValue());
			} else if (value instanceof Float) {
				query.setFloat(name, ( (Float)value ).floatValue());
			} else if (value instanceof Double) {
				query.setDouble(name, ( (Double)value ).doubleValue());
			} else if (value instanceof Timestamp) {
				query.setTimestamp(name, (Timestamp)value);
			} else if (value instanceof Date) {
				query.setDate(name, (Date)value);
			} else if (value instanceof Collection) {
				query.setParameterList(name, (Collection)value);
			} else if (value instanceof Object[]) {
				query.setParameterList(name, (Object[])value);
			} else {
				query.setParameter(name, value);
			}
		}
	}
	
	public final static void loadingObjectParameters(Query query,ArrayList<String> params,Object...parameters){
		if(parameters == null) return ;
		for(int i=0,len=params.size();i<len;++i){
			String name = params.get(i);
			Object value = parameters[i];
			if(value == null) continue;
			if (value instanceof Object[]) {
				query.setParameterList(name, (Object[])value);
			}else if (value instanceof Collection) {
				query.setParameterList(name, (Collection)value);
			}  else if(value instanceof String) {
				query.setString(name , (String)value);
			} else if (value instanceof Integer) {
				query.setInteger(name , ( (Integer)value ).intValue());	
			} else if (value instanceof Long) {
				query.setLong(name, ( (Long)value ).longValue());
			} else if (value instanceof Float) {
				query.setFloat(name, ( (Float)value ).floatValue());
			} else if (value instanceof Double) {
				query.setDouble(name, ( (Double)value ).doubleValue());
			} else if (value instanceof Timestamp) {
				query.setTimestamp(name, (Timestamp)value);
			} else if (value instanceof Date) {
				query.setDate(name, (Date)value);
			} else {
				query.setParameter(name, value);
			}
		}
	}
}
