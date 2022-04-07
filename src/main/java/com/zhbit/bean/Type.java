package com.zhbit.bean;

import org.springframework.stereotype.Component;

@Component
public class Type {
	private int tNo;           //ID
	private String tTypeName; //通知公告类型名称
	
	public Type(){
		
	}

	public Type(int tNo, String tTypeName) {
		this.tNo = tNo;
		this.tTypeName = tTypeName;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettTypeName() {
		return tTypeName;
	}

	public void settTypeName(String tTypeName) {
		this.tTypeName = tTypeName;
	}

	@Override
	public String toString() {
		return "Type{" +
				"tNo=" + tNo +
				", tTypeName='" + tTypeName + '\'' +
				'}';
	}
}
