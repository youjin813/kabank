package com.kabank.web.service;

 
public class MemberService {
	private int customNum;
	private String name;
	private int age;
	private String gender;
	private String ssn;

	public MemberService() {
		this.customNum = 0;
		this.name ="";
		this.age = 0;
		this.gender ="";
		this.ssn ="";
}
	public void setCustomNum() {
		this.customNum = 101;
	}
	public int getCustomNum(){
		return this.customNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge() {
		ssn = "";
		
		this.age = 30;
	}
	public int getAge() {
		return this.age;
	}
	public void setGender() {
		String res = "";
		char ch = ssn.charAt(7);
		switch(ch){
			case '1':
			case '3':
				res = "남자";break;
			case '2':
			case '4':
				res = "여자";break;
			default : 
				res = "다시 입력하세요.";
			}
		this.gender = res;
	}
	public String getGender() {
		return this.gender;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return this.ssn;
	}
}
