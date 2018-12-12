package com.mhrj.entity;


//("1111", "测试文章1", "作者1", 1.0, 1);
public class TArticle {
private String aaa;
private String bbb;
private String ccc;
private Double ddd;
private Integer eee;


public TArticle(String aaa, String bbb, String ccc, Double ddd, Integer eee) {
	super();
	this.aaa = aaa;
	this.bbb = bbb;
	this.ccc = ccc;
	this.ddd = ddd;
	this.eee = eee;
}


public TArticle() {
	super();
}


public String getAaa() {
	return aaa;
}
public void setAaa(String aaa) {
	this.aaa = aaa;
}
public String getBbb() {
	return bbb;
}
public void setBbb(String bbb) {
	this.bbb = bbb;
}
public String getCcc() {
	return ccc;
}
public void setCcc(String ccc) {
	this.ccc = ccc;
}
public Double getDdd() {
	return ddd;
}
public void setDdd(Double ddd) {
	this.ddd = ddd;
}
public Integer getEee() {
	return eee;
}
public void setEee(Integer eee) {
	this.eee = eee;
}

}
