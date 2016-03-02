package com.jusfoun.catalog.vo;

/**
 * 检索分析
 * @author liudebin
 *
 */
public class SearchAnalysis {
	
	private String keyword;//热门词
	private String officeName;//热门机构
	private String srhTime;
	private int srhCount;
	private int srhType;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getSrhTime() {
		return srhTime;
	}
	public void setSrhTime(String srhTime) {
		this.srhTime = srhTime;
	}
	public int getSrhCount() {
		return srhCount;
	}
	public void setSrhCount(int srhCount) {
		this.srhCount = srhCount;
	}
	public int getSrhType() {
		return srhType;
	}
	public void setSrhType(int srhType) {
		this.srhType = srhType;
	}
	
}
