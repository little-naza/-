package com.stu.impl;


import com.stu.dto.Student;

public class StuImpl {// ʵ�ֲ������� ɾ �� ��

	public static boolean addStu(Student S) throws InterruptedException {// ¼��ѧ����Ϣ
		S.getStu();
		return false;
	}
	
	
	public static void clear1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		Thread.sleep(2000);
	}

}
