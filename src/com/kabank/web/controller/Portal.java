package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;


public class Portal {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("회원수를 입력");
		System.out.println(scanner);
		int count = scanner.nextInt();
		MemberService memberService = new MemberServiceImpl(scanner.nextInt());
 		MemberBean member =null;
		while (true){
			System.out.print("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수 4.회원목록");
			switch(scanner.nextInt()) {
			case 0 : System.out.print("종료");return;
			case 1:
				member = new MemberBean();
				System.out.print("이름을 입력하세요.");
				member.setName(scanner.next());
				System.out.print("주민번호를 입력하세요.");
				member.setSsn(scanner.next());
			    member.setCustomNum(memberService.createCustomNum());
				member.setGender(memberService.findGender(member.getSsn()));
				member.setAge(memberService.findAge(member.getSsn()));
				memberService.addMember(member);
				System.out.print(
						  "[고객번호]" + member.getCustomNum()
						+ "[주민번호]" + member.getSsn()
						+ "[이름]" + member.getName()
						+ "[성별]" + member.getGender()
						+ "[나이]" + member.getAge());
				break;
			case 2 : 
				AccountServiceImpl accountservice = new AccountServiceImpl();
				System.out.print("이름을 입력하세요.");
				accountservice.setName(scanner.next());
				accountservice.setAccountNum();
				System.out.print(accountservice.getAccountNum()+"[계좌번호]"+accountservice.getName());
				break;
			case 3 :
				System.out.println("총 회원수는:"+memberService.count());
				break;
			case 4 : 
				MemberBean[] members = memberService.list();
				for(int i=0;i<members.length;i++) {
					System.out.println(members[i].getName());
				}
			
				break;
					
			}
		}
	}
}
