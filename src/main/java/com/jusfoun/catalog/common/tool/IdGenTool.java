package com.jusfoun.catalog.common.tool;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author Connor
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdGenTool implements IdGenerator, SessionIdGenerator {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return EncodeTool.encodeBase62(randomBytes);
	}
	
	/**
	 * Activiti ID 生成
	 */
	@Override
	public String getNextId() {
		return IdGenTool.uuid();
	}

	@Override
	public Serializable generateId(Session session) {
		return IdGenTool.uuid();
	}
	
	public static void main(String[] args) {
		System.out.println(IdGenTool.uuid());
		System.out.println(IdGenTool.uuid().length());
		System.out.println(new IdGenTool().getNextId());
		for (int i=0; i<1000; i++){
			System.out.println(IdGenTool.randomLong() + "  " + IdGenTool.randomBase62(5));
		}
	}

}
