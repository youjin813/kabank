package com.kabank.web.service;

import java.util.Vector;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void addMember(MemberBean member);
	public Vector<MemberBean> list();
	public int count();
	public void deleteAll();
	public void delete(String id);
	public String login(MemberBean member);
	public MemberBean findById(String showInputDialog);
	public Object findByName(String showInputDialog);
}
