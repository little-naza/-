package com.stu.dto;

import com.stu.db.DateBase;

public class Student {// ���ݴ������
	private String name;// ����
	private String num;// ѧ��
	private int age;// ����
	private String sex;// �Ա�
	private String nativeplace;// ����
	private String department;// ����ϵ��
	private String phone;// ��ϵ�绰
	private String chang;// ѧ���䶯���
	private String graduate;// �Ƿ��ҵ

	public Student() {

	}


	
	
	public Student(String name, String num, int age, String sex, String nativeplace, String department, String phone,
			String chang, String graduate) {
		this.name = name;
		this.num = num;
		this.age = age;
		this.sex = sex;
		this.nativeplace = nativeplace;
		this.department = department;
		this.phone = phone;
		this.chang = chang;
		this.graduate = graduate;
	}

	public void getStu() {
		DateBase date = new DateBase();
		date.name[0] = this.name;
		date.num[0] = this.num;
		date.age[0] = this.age;
		date.sex[0] = this.sex;
		date.nativeplace[0] = this.nativeplace;
		date.department[0] = this.department;
		date.phone[0] = this.phone;
		date.chang[0] = this.chang;
		date.graduate[0] = this.graduate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getChang() {
		return chang;
	}

	public void setChang(String chang) {
		this.chang = chang;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

}