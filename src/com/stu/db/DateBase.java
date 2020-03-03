package com.stu.db;

public class DateBase {// 数据库

	public DateBase() {
		name = new String[101];
		num = new String[101];
		age = new int[101];
		sex = new String[101];
		nativeplace = new String[101];
		department = new String[101];
		phone = new String[101];
		chang = new String[101];
		graduate = new String[101];
	}

	public void init() {// 数据初始化
		name[0] = "无";
		num[0] = "无";
		age[0] = 0;
		sex[0] = "无";
		nativeplace[0] = "无";
		department[0] = "无";
		phone[0] = "无";
		chang[0] = "无";
		graduate[0] = "无";
	}

	public String name[];// 姓名
	public String num[];// 学号
	public int age[];// 年龄
	public String sex[];// 性别
	public String nativeplace[];// 籍贯
	public String department[];// 所在系部
	public String phone[];// 联系电话
	public String chang[];// 学籍变动情况
	public String graduate[];// 是否毕业

}
