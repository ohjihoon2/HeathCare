package com.mycom.vo;

public class InbodyVO {
	
	int cno, age;
	double height, weight, body_fat, waist, hip;
	String gender, BMI, S_weight, PBF, FAT, WHR;
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBody_fat() {
		return body_fat;
	}
	public void setBody_fat(double body_fat) {
		this.body_fat = body_fat;
	}
	public double getWaist() {
		return waist;
	}
	public void setWaist(double waist) {
		this.waist = waist;
	}
	public double getHip() {
		return hip;
	}
	public void setHip(double hip) {
		this.hip = hip;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBMI() {
		return BMI;
	}
	public void setBMI(String bMI) {
		BMI = bMI;
	}
	public String getS_weight() {
		return S_weight;
	}
	public void setS_weight(String s_weight) {
		S_weight = s_weight;
	}
	public String getPBF() {
		return PBF;
	}
	public void setPBF(String pBF) {
		PBF = pBF;
	}
	public String getFAT() {
		return FAT;
	}
	public void setFAT(String fAT) {
		FAT = fAT;
	}
	public String getWHR() {
		return WHR;
	}
	public void setWHR(String wHR) {
		WHR = wHR;
	}
	@Override
	public String toString() {
		return "InbodyVO [cno=" + cno + ", age=" + age + ", height=" + height + ", weight=" + weight + ", body_fat="
				+ body_fat + ", waist=" + waist + ", hip=" + hip + ", gender=" + gender + ", BMI=" + BMI + ", S_weight="
				+ S_weight + ", PBF=" + PBF + ", FAT=" + FAT + ", WHR=" + WHR + "]";
	}
	

	
	

}