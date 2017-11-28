package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.web.service.AccountService;
import com.kabank.web.service.MemberService;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while (true){
			System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료");return;
			case 1:
				MemberService memberService = new MemberService();
				System.out.println("이름");
				String name = scanner.next();
				System.out.println("주민번호");
				memberService.join(scanner.next());
				System.out.println("고객번호101"+"[이름]"+name+"[성별] 남"+"[나이] 30세");
				break;
			case 2 : 
				AccountService service = new AccountService();
				
				System.out.println("이름?");
				String n =scanner.next();
				System.out.println(n+"[계좌번호]"+service.createAccount());
				break;
			}
		}
	}
}
