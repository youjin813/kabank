package com.kabank.web.service;

import java.util.Random;


public class AccountService {
  public int createAccount() {
	 
	  Random r = new Random();
	 
	  int accountNo = 0;
	  boolean flag = true;
	  while(flag){
		  int temp = r.nextInt(1000000);
		  if(temp >100000) {
			 accountNo=temp;
			 flag = false;
		  }
	  }
	  return accountNo;
  }
  
}
