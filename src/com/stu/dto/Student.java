package com.stu.dto;

public class Student {// ���ݴ������
	private String name;// ����
	private String num;// ѧ��
	private int age;// ����
	private String gender;// �Ա�
	private String nativeplace;// ����
	private String department;// ����ϵ��
	private String phone;// ��ϵ�绰
	private String chang;// ѧ���䶯���
	private String graduate;// �Ƿ��ҵ

	public Student() {  //�޲ι���

	}

	public Student(String name, String num, 
			int age, String gender, String nativeplace, String department, String phone,
			String chang, String graduate) {  //�вι���
		this.name = name;
		this.num = num;
		this.age = age;
		this.gender = gender;
		this.nativeplace = nativeplace;
		this.department = department;
		this.phone = phone;
		this.chang = chang;
		this.graduate = graduate;
	}

	public String toString() {
		System.out.println();
		String s="&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n";
		s+="  ������"+this.name+"\tѧ�ţ�"+this.num+"\t���䣺"+this.age+"\n  �Ա�"+this.gender;
		s+="\t���᣺"+this.nativeplace+"\t����ϵ����"+this.department;
		s+="\n  �绰���룺"+this.phone+"ѧ���䶯�����"+this.chang+"�Ƿ��ҵ��"+this.graduate;
		s+="\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&";
		System.out.println();
		return s;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String sex) {
		this.gender = sex;
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