package com.jusfoun.catalog.vo;

/**
 * 目录树VO
 * @author liudebin
 *
 */
public class CatalogTree {
	
	private int id;//目录树id
	private int pid;//父目录树id
	private String name;//目录树名
	private boolean isParent;//是否是父目录
	private boolean open;//是否打开
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isParent() {
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
