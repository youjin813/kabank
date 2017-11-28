package com.kabank.web.service;

import java.util.Scanner;

public class MemberService {
	public String join(String ssn) {
		String res = "";
		String result = "";
		char ch = ssn.charAt(7);
		switch(ch) {
		case '1' :
		case '3' :
		result = "남";break;
		case '2' :
		case '4' :
		result = "여";break;
		default : result = "다시 입력하세요.";
		res += "[고객번호]101";
		
		
		}
		return res;
		}
}
