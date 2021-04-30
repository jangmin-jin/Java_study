// com 폴더 안에 naver로 생성되서 들어감
package com.naver;

public class Student{
    // public String hakbun;
    // public String name;
    // public int age;
    // public double height;

    private String hakbun;
    private String name;
    private int age;
    private double height;

    // 생성자 선언 (setter의 역할을 대신 해준다)
    public Student(String hakbun, String name, int age, double height){
        this.hakbun = hakbun;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void setHakbun(String hakbun){
        this.hakbun = hakbun;        
    }
    public String getHakbun(){
        return hakbun;
    }

    public void setName(String name){
        this.name = name;        
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;        
    }
    public int getAge(){
        return age;
    }

    public void setHeight(double height){
        this.height = height;        
    }
    public double getHeight(){
        return height;
    }
}