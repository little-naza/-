package com.stu.dto;

public class Student {// 数据传输对象
	private String name;// 姓名
	private String num;// 学号
	private int age;// 年龄
	private String gender;// 性别
	private String nativeplace;// 籍贯
	private String department;// 所在系部
	private String phone;// 联系电话
	private String chang;// 学籍变动情况
	private String graduate;// 是否毕业

	public Student() {  //无参构造

	}

	public Student(String name, String num, 
			int age, String gender, String nativeplace, String department, String phone,
			String chang, String graduate) {  //有参构造
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
		s+="  姓名："+this.name+"\t学号："+this.num+"\t年龄："+this.age+"\n  性别："+this.gender;
		s+="\t籍贯："+this.nativeplace+"\t所在系部："+this.department;
		s+="\n  电话号码："+this.phone+"学籍变动情况："+this.chang+"是否毕业："+this.graduate;
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