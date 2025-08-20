package com.ineuron.binding;

import lombok.Data;

@Data
public class Books 
{
	
	private String bname;
	private String authorName;
	private Integer bprice;
	
	/*
	 * 	 Added setters and getters to resolve the mapping issue
	 */
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getBprice() {
		return bprice;
	}
	public void setBprice(Integer bprice) {
		this.bprice = bprice;
	}
	
	
	
}
