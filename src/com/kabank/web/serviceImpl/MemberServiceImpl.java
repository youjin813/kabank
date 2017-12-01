package com.kabank.web.serviceImpl;

import java.util.Calendar;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] members;
	private int count;

	public MemberServiceImpl(int count) {
		members = new MemberBean[count];
		this.count = 0;
	}

	@Override
	public int count() {
		return this.count;
	}

	@Override
	public int createCustomNum() {
		int foo = 0;
		return foo;
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

	public void addMember(MemberBean member) {
		members[count] = member;
		count++;

	}

	@Override
	public MemberBean[] list() {
		return members;
	}
}
