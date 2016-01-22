package com.jusfoun.catalog.vo;

import java.util.List;

public class ETreeNode {
	
	private int id;//节点Id
	private String text;//节点名称
	private String state;//节点状态
	private List<ETreeNode> etnList;//子节点
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<ETreeNode> getEtnList() {
		return etnList;
	}
	public void setEtnList(List<ETreeNode> etnList) {
		this.etnList = etnList;
	}

}
