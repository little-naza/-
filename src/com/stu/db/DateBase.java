package com.stu.db;

import java.util.ArrayList;

import com.stu.dto.Student;

public class DateBase {// ���ݿ�

	public static void  init() {// ���ݳ�ʼ��
		Student s1=new Student("��ɮ","001",42,"��","��������","�ɰ�","111","��","��");
		Student s2=new Student("�����","002",600,"��","����ɽ","�ɰ�","112","��","��");
		Student s3=new Student("��˽�","003",800,"��","����ׯ","�ɰ�","113","��","��");
		Student s4=new Student("ɳɮ","004",900,"��","��ɳ��","�ɰ�","114","��","��");
		Student s5=new Student("�׹Ǿ�","005",1300,"Ů","�׹Ƕ�","�ɰ�","115","��","��");
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
