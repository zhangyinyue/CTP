package com.ctp.jedis.client;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *   redis 客户端封装
 *	@auther zyy
 *	@date 2016年12月18日上午10:53:43
 */
@Repository(value=RedisName.REDIS_CLIENT)
public class RedisClient  {
	/**
	 * 日志记录
	 */
	private static final Logger logger = Logger.getLogger(RedisClient.class);
	/**
	 * redis 连接池
	 */
	@Resource(name=RedisName.REDIS_POOL)
	private JedisPool pool;
	
	public void setPool(JedisPool pool) {
		this.pool = pool;
	}
	/**
	 * 获取jedis 
	 * @return
	 */
	public Jedis getResource(){
		Jedis jedis =null;
		try {
			jedis =pool.getResource();
		} catch (Exception e) {
			logger.info("can't  get  the redis resource");
		}
		return jedis;
	}
	/**
	 * 关闭连接
	 * @param jedis
	 */
	public void disconnect(Jedis jedis){
		jedis.disconnect();
	}
	/**
	 * 将jedis 返还连接池
	 * @param jedis
	 */
	public void returnResource(Jedis jedis){
		if(null != jedis){
			try {
				pool.returnResource(jedis);
			} catch (Exception e) {
				logger.info("can't return jedis to jedisPool");
			}
		}
	}
	/**
	 * 无法返还jedispool，释放jedis客户端对象，
	 * @param jedis
	 */
	public void brokenResource(Jedis jedis){
		if (jedis!=null) {
			try {
				pool.returnBrokenResource(jedis);
			} catch (Exception e) {
				logger.info("can't release jedis Object");
			}
		}
	}
}
