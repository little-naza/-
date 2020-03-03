package com.stu.impl;


import com.stu.dto.Student;

public class StuImpl {// 实现操作，增 删 改 查

	public static boolean addStu(Student S) throws InterruptedException {// 录入学生信息
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
