package com.stu.db;

import java.util.ArrayList;

import com.stu.dto.Student;

public class DateBase {// 数据库

	public static void  init() {// 数据初始化
		Student s1=new Student("唐僧","001",42,"男","东土大唐","仙班","111","无","是");
		Student s2=new Student("孙悟空","002",600,"男","花果山","仙班","112","无","是");
		Student s3=new Student("猪八戒","003",800,"男","高老庄","仙班","113","无","是");
		Student s4=new Student("沙僧","004",900,"男","流沙河","仙班","114","无","是");
		Student s5=new Student("白骨精","005",1300,"女","白骨洞","仙班","115","无","是");
		getsList().add(s1);
		getsList().add(s2);
		getsList().add(s3);
		getsList().add(s4);
		getsList().add(s5);

	}
	public static ArrayList<Student> sList=new ArrayList<Student>();

	public static  ArrayList<Student> getsList() {
		return sList;
	}

	public static void setsList(ArrayList<Student> sList) {
		DateBase.sList = sList;
	}

}
