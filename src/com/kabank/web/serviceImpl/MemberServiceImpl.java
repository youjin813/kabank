package com.kabank.web.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private Vector<MemberBean>members;
	private int count;

	public MemberServiceImpl() {
		members = new Vector<MemberBean>(10,10);
		this.count = 1000;
	}

	@Override
	public int createCustomNum() {
		return count++;
	}

	@Override
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		switch (ch) {
		case '1':
		case '3':
			foo = "남";
			break;
		case '2':
		case '4':
			foo = "여";
			break;
		default:
			foo = "다시 입력하세요.";
		}
		return foo;
	}

	@Override
	public int findAge(String ssn) {
		int foo = 0;
		Calendar now = Calendar.getInstance();
		int birthYear = 0;
		char firYear = ssn.charAt(0);
		char secYear = ssn.charAt(1);
		int fsYear = Integer.parseInt(firYear + secYear + "");
		int presentYear = now.get(now.YEAR);
		int gap = presentYear - fsYear;
		if (gap >= 2000) {
			birthYear = Integer.parseInt("20" + firYear + secYear);
		} else {
			birthYear = Integer.parseInt("19" + firYear + secYear);
		}
		foo = presentYear - birthYear;

		return foo;
	}
	@Override
	public void addMember(MemberBean member) {
		members.add(member);
	}

	@Override
	public Vector<MemberBean> list() {
		return members;
	}

	@Override
	public int count() {
		return members.size();
	}

	@Override
	public void deleteAll() {
		members.clear();
	}

	@Override
	public void delete(String id) {
		String res = "";
		for(int i = 0;i < members.size();i++) {
			if(id.equals(members.get(i).getId())) {
				members.removeElementAt(i);
			}
		}
	}
	
	@Override
	public String login(MemberBean member) {
		String res ="ID가 존재하지 않습니다.";		
		for(int i = 0; i < members.size(); i++) {		
			if(member.getId().equals(members.get(i).getId())) {
			 res = (member.getPass().equals(members.get(i).getPass())) ? "로그인 성공":"PASS를 다시 입력하세요." ;
			 return res;          //break는 회사 찍고 퇴근  return res 는회사 안오고 바로 퇴근
			/*if(member.getPass().equals(members.get(i).getPass())) {  	
					res = "로그인 성공";
					break;
				}else {
					res = "pass를 다시 입력하세요.";
				break; }     삼항으로 변경**/ 
			}
		}
			return res;
	}

	@Override
	public MemberBean findById(String showInputDialog) {
		MemberBean m = new MemberBean();        //return 타입 젤 먼저
		for(int i = 0; i < members.size(); i++) {
			if(showInputDialog.equals(members.get(i).getId())) {
				m = members.get(i);
				return m;
			}
		}
		return m;
	}
	@Override
	public Vector<MemberBean> findByName(String showInputDialog) {
		Vector<MemberBean> b = new Vector<MemberBean>(10,10);
		for(int i = 0; i < members.size(); i++) {
				if(showInputDialog.equals(members.get(i).getName())) {
					b.add(members.get(i));
				}
			}
		return b;
	}

}
