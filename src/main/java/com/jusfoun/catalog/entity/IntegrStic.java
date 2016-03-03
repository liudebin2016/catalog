package com.jusfoun.catalog.entity;

/**
 * 信息统计--中间图表
 * @author liudebin
 *
 */
public class IntegrStic {
	
	private String sTime;//时间
	private int sCount;//数量
	private int type;//类型
	
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public int getsCount() {
		return sCount;
	}
	public void setsCount(int sCount) {
		this.sCount = sCount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
