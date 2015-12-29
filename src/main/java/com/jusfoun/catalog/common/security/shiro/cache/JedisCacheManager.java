package com.jusfoun.catalog.common.security.shiro.cache;

import com.jusfoun.catalog.common.tool.JedisTool;
import com.jusfoun.catalog.common.tool.ServletTool;
import com.google.common.collect.Sets;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * 自定义授权缓存管理类
 * @author Connor
 * @version 2015-12-20
 */
public class JedisCacheManager implements CacheManager {

	private String cacheKeyPrefix = "shiro_cache_";
	
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new JedisCache<K, V>(cacheKeyPrefix + name);
	}

	public String getCacheKeyPrefix() {
		return cacheKeyPrefix;
	}

	public void setCacheKeyPrefix(String cacheKeyPrefix) {
		this.cacheKeyPrefix = cacheKeyPrefix;
	}
	
	/**
	 * 自定义授权缓存管理类
	 * @author ThinkGem
	 * @version 2014-7-20
	 */
	public class JedisCache<K, V> implements Cache<K, V> {

		private Logger logger = LoggerFactory.getLogger(getClass());

		private String cacheKeyName = null;

		public JedisCache(String cacheKeyName) {
			this.cacheKeyName = cacheKeyName;
//			if (!JedisTool.exists(cacheKeyName)){
//				Map<String, Object> map = Maps.newHashMap();
//				JedisTool.setObjectMap(cacheKeyName, map, 60 * 60 * 24);
//			}
//			logger.debug("Init: cacheKeyName {} ", cacheKeyName);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public V get(K key) throws CacheException {
			if (key == null){
				return null;
			}
			
			V v = null;
			HttpServletRequest request = ServletTool.getRequest();
			if (request != null){
				v = (V)request.getAttribute(cacheKeyName);
				if (v != null){
					return v;
				}
			}
			
			V value = null;
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				value = (V) JedisTool.toObject(jedis.hget(JedisTool.getBytesKey(cacheKeyName), JedisTool.getBytesKey(key)));
				logger.debug("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "");
			} catch (Exception e) {
				logger.error("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "", e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			
			if (request != null && value != null){
				request.setAttribute(cacheKeyName, value);
			}
			
			return value;
		}

		@Override
		public V put(K key, V value) throws CacheException {
			if (key == null){
				return null;
			}
			
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				jedis.hset(JedisTool.getBytesKey(cacheKeyName), JedisTool.getBytesKey(key), JedisTool.toBytes(value));
				logger.debug("put {} {} = {}", cacheKeyName, key, value);
			} catch (Exception e) {
				logger.error("put {} {}", cacheKeyName, key, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			return value;
		}

		@SuppressWarnings("unchecked")
		@Override
		public V remove(K key) throws CacheException {
			V value = null;
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				value = (V) JedisTool.toObject(jedis.hget(JedisTool.getBytesKey(cacheKeyName), JedisTool.getBytesKey(key)));
				jedis.hdel(JedisTool.getBytesKey(cacheKeyName), JedisTool.getBytesKey(key));
				logger.debug("remove {} {}", cacheKeyName, key);
			} catch (Exception e) {
				logger.warn("remove {} {}", cacheKeyName, key, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			return value;
		}

		@Override
		public void clear() throws CacheException {
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				jedis.hdel(JedisTool.getBytesKey(cacheKeyName));
				logger.debug("clear {}", cacheKeyName);
			} catch (Exception e) {
				logger.error("clear {}", cacheKeyName, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
		}

		@Override
		public int size() {
			int size = 0;
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				size = jedis.hlen(JedisTool.getBytesKey(cacheKeyName)).intValue();
				logger.debug("size {} {} ", cacheKeyName, size);
				return size;
			} catch (Exception e) {
				logger.error("clear {}",  cacheKeyName, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			return size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<K> keys() {
			Set<K> keys = Sets.newHashSet();
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				Set<byte[]> set = jedis.hkeys(JedisTool.getBytesKey(cacheKeyName));
				for(byte[] key : set){
					keys.add((K)key);
	        	}
				logger.debug("keys {} {} ", cacheKeyName, keys);
				return keys;
			} catch (Exception e) {
				logger.error("keys {}", cacheKeyName, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			return keys;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<V> values() {
			Collection<V> vals = Collections.emptyList();;
			Jedis jedis = null;
			try {
				jedis = JedisTool.getResource();
				Collection<byte[]> col = jedis.hvals(JedisTool.getBytesKey(cacheKeyName));
				for(byte[] val : col){
					vals.add((V)val);
	        	}
				logger.debug("values {} {} ", cacheKeyName, vals);
				return vals;
			} catch (Exception e) {
				logger.error("values {}",  cacheKeyName, e);
			} finally {
				JedisTool.returnResource(jedis);
			}
			return vals;
		}
	}
}
