package com.jusfoun.catalog.vo;

/**
 * 目录树VO
 * @author liudebin
 *
 */
public class CatalogTree {
	
	private int id;//目录树id
	private int pId;//父目录树id
	private String name;//目录树名
	private boolean isParent;//是否是父目录
	private boolean open;//是否打开
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPId() {
		return pId;
	}
	public void setPId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean isOpen() {
		return open;
	}
	public void setIsOpen(boolean open) {
		this.open = open;
	}
	
}
