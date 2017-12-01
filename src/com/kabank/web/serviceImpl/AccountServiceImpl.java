package com.kabank.web.serviceImpl;

import java.util.Random;

public class AccountServiceImpl {
	private String name;
	private int accountNum;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
  public void setAccountNum() {
	  Random r = new Random();
	  int accountNum = 0;
	  boolean flag = true;
	  while(flag){
		  int temp = r.nextInt(1000000);
		  if(temp >100000) {
			 accountNum=temp;
			 flag = false;
		  }else {
			 flag = true;
		  }
	  }
  }
public int getAccountNum() {
	return this.accountNum;
} 
}
