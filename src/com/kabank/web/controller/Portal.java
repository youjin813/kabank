package com.kabank.web.controller;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;


public class Portal {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
 		MemberBean member = null;
		while (true){
			switch(JOptionPane.showInputDialog("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수 4.회원목록 5.로그인 \n"
					+ " 6.회원검색 7.이름 검색 8.비번수정 9.회원탈퇴 10.회원전체삭제")) {
			case "0" :JOptionPane.showMessageDialog(null, "종료"); 
				return;
			case "1":
				String spec = JOptionPane.showInputDialog("이름/주민번호/id/pass");// 홍/800101-123456/hong/1
				String[] dummy = {
						"홍길동/800101-123456/hong/1",
						"김유신/900203-134567/kim/1",
						"김유신/950203-134567/kys/1",
						"이이/920304-189456/lee/1",
						"유관순/580910-223456/you/1",
						"신사임당/950101-273456/shin/1"
				};
				for(int i=0;i<dummy.length;i++) {
					member = new MemberBean();
					String[]arr =dummy[i].split("/");
					member.setName(arr[0]);
					member.setSsn(arr[1]);
					member.setId(arr[2]);
					member.setPass(arr[3]);
					member.setCustomNum(memberService.createCustomNum());
					member.setGender(memberService.findGender(member.getSsn()));
					member.setAge(memberService.findAge(member.getSsn()));
					memberService.addMember(member);
					}
				break;
			case "2" : 
				AccountServiceImpl accountservice = new AccountServiceImpl();
				JOptionPane.showInputDialog("이름을 입력하세요.");
				accountservice.setAccountNum();
				System.out.print(accountservice.getAccountNum()+"[계좌번호]"+accountservice.getName());
				break;
			case "3" :
				JOptionPane.showInputDialog("총 회원수는:"+memberService.count());
				break;
			case "4" : 
				JOptionPane.showMessageDialog(null, memberService.list());
				break;
			case "5" :
				String[] arr = JOptionPane.showInputDialog("ENTER ID/PASS").split("/");
				member = new MemberBean(); 		
				member.setId(arr[0]);
				member.setPass(arr[1]);
				JOptionPane.showMessageDialog(null,memberService.login(member));
				break;
			case "6" :
				//member = memberService.findById(JOptionPane.showInputDialog("ENTER SEARCH ID"));   shallow copy , new 사용하지 말고 copy사용
				JOptionPane.showMessageDialog(null,memberService.findById(JOptionPane.showInputDialog("ENTER SEARCH ID")).toString());
				break;
			case "7" :
				JOptionPane.showMessageDialog(null, memberService.findByName(JOptionPane.showInputDialog("ENTER SEARCH NAME")));
				break;
			case "8" :
				
				break;
			case "9" :
				memberService.delete(JOptionPane.showInputDialog("아이디를 입력하세요"));
				break;
			case "10":
				memberService.deleteAll();
				break;
				}
					
			}
		}
	}

