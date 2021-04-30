package com.naver;

public class Student {
	private String hakbun;
	private String name;
	private int age;
	private double height;
	
	// setter / getter (오른쪽 마우스 클릭 -> 소스 -> 제네럴 게터세터)
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
