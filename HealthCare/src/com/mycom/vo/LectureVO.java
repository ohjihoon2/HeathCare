package com.mycom.vo;

public class LectureVO {
	String cname, gx_code, gx_name, gx_validity;
	int cno, gx_count , gx_price, gx_totprice;
	
	//method
	public String getGx_validity() {
		return gx_validity;
	}
	public void setGx_validity(String gx_validity) {
		this.gx_validity = gx_validity;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getGx_totprice() {
		return gx_totprice;
	}
	public void setGx_totprice(int gx_totprice) {
		this.gx_totprice = gx_totprice;
	}
	public String getGx_code() {
		return gx_code;
	}
	public void setGx_code(String gx_code) {
		this.gx_code = gx_code;
	}
	public String getGx_name() {
		return gx_name;
	}
	public void setGx_name(String gx_name) {
		this.gx_name = gx_name;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getGx_count() {
		return gx_count;
	}
	public void setGx_count(int gx_count) {
		this.gx_count = gx_count;
	}
	public int getGx_price() {
		return gx_price;
	}
	public void setGx_price(int gx_price) {
		this.gx_price = gx_price;
	}


	
}
