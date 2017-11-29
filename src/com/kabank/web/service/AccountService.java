package com.kabank.web.service;

import java.util.Random;

public class AccountService {
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
	  int accountNo = 0;
	  boolean flag = true;
	  while(flag){
		  int temp = r.nextInt(1000000);
		  if(temp >100000) {
			 accountNo=temp;
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
