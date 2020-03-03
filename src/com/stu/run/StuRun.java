package com.stu.run;

import java.util.Scanner;

import com.stu.db.DateBase;
import com.stu.dto.Student;
import com.stu.impl.StuImpl;

public class StuRun {// 主方法
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		// 程序运行入口
		DateBase Data = new DateBase();
		Data.init();
		mainmanu();
		// clear1();
		

	}

	public static void mainmanu() throws InterruptedException {// 操作提示
		boolean flag = true;
		while (flag) {
			int a = sc.nextInt();
			show1();
			switch (a) {
			case 1:// 1,显示学生学籍信息。
				break;
			case 2:// 2， 添加学籍信息
				add();
				break;
			case 3:// 3，查找学生学籍信息。
				break;
			case 4:// 4，修改学生学籍信息。
				break;
			case 5:// 5,操作说明
				break;
			}
			System.out.println("输入有误，请重新输入！");
		};

	}

	public static void add() throws InterruptedException {
		Scanner in = new Scanner(System.in);
		boolean choose = true;

		a: while (choose) {
			System.out.println("------------------------------------------------------------------");
			System.out.print("请输入姓名：");
			String name = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入性别：");
			String sex = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入年龄：");
			int age = in.nextInt();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入学号：");
			String num = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入籍贯：");
			String nativeplace = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入所在系部：");
			String department = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入联系电话：");
			String phone = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入学籍变动情况：");
			String change = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("请输入是否毕业：");
			String graduate = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");
			System.out.println("------------------------------------------------------------------");
			clear1();

			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\t姓名：" + name + "\t性别：" + sex + "\t年龄：" + age + "\t学号：" + num);
			System.out.println("\t籍贯：" + nativeplace + "\t所在系部：" + department + "\t联系电话：" + phone + "\t学籍变动情况：" + change
					+ "    是否毕业：" + graduate);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\t请检查信息是否有误    | 重新修改请按  1  |退出请按  2|");
			while (true) {
				String sc = in.nextLine();
				if (sc.equals("1")) {
					continue;
				}
				if (sc.equals("2")) {
					// 接下来是传输值
					Student student = new Student(name, num, age, sex, nativeplace, department, phone, change,
							graduate);
					StuImpl impl = new StuImpl();
					impl.addStu(student);
					break a;
				}
				System.out.println("...输入有误请重新输入...");
			}
		}
	}

	public static void printStuInfo() {// 显示学生信息

	}

	public static void findStuByNum() {// 按学号查找学生信息

	}

	public static void modifyStu() {// 按学号修改学生信息

	}

	public static void deleteStu() {// 删除学生信息

	}

	public static void findByName() {// 按姓名查询学生信息

	}

	public static void sortByNum() {// 按学号对学生信息进行从小到大排序
		DateBase date = new DateBase();
		for (int i = 1; i <= 100; i++) {
			if (date.num[0].compareTo(date.num[i]) > 0) {
				System.out.println();
			}
		}

	}

//----------------------------------------------
	public static void show1() {
		System.out.println("ヽ｀、ヽ｀｀、ヽ 、  ヽ｀、、ヽ ｀ヽ 、ヽ｀ヽ｀ヽ｀、ヽ｀｀     ");
		System.out.println("ヽ｀ヽ、ヽ｀ヽ｀、ヽ｀｀、ヽ 、｀｀ 、ヽヽ｀ヽ｀、ヽ    ヽ ヽ｀");
		System.out.println("ヽ       1,显示学生学籍信息。    2， 添加学籍信息  ヽ｀  、｀ヽ  ヽ");
		System.out.println("、 ｀、ヽ｀ヽ｀ヽ｀ ヽ｀5,操作说明ヽ｀、ヽ ヽ｀ヽ｀    ヽ｀ヽ、");
		System.out.println("｀、｀3，查找学生学籍信息。    4，修改学生学籍信息。、ヽ｀  ヽ");
		System.out.println("｀、、ヽ ｀ヽ 、ヽ｀｀ヽヽ｀ヽ、ヽ｀ヽ｀、ヽ｀｀ヽ｀ヽ｀、  ｀");
		System.out.println("｀、、ヽ ｀ヽ 、ヽ｀｀ヽヽ｀ヽ、ヽ｀ヽ｀、ヽ｀｀ヽ｀ヽ｀、  ｀");
	}

	public static void clear1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		Thread.sleep(2000);
	}
}
