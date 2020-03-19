package com.stu.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.stu.db.DateBase;
import com.stu.dto.Student;

public class StuImpl {// 实现操作，增 删 改 查
	private static Boolean flag = true;
	private static Scanner in = new Scanner(System.in);
	private static Student student = new Student();

	public static void mainMenu() {
		try {
			read();
			DateBase.init();
			while (flag) {
				menu();
				System.out.print("请输入你的操作：");
				String sc = in.next();
				try {
					switch (sc) {
					case "1":
						addstu();
						flag = true;
						// 添加学籍信息
						break;
					case "2":
						// 显示
						showStu();
						flag = true;
						break;
					case "3":
						// 修改
						setStu();
						flag = true;
						break;
					case "4":
						// 查询
						findstu();
						flag = true;
						break;
					case "5":
						// 删除
						deletStu();
						flag = true;
						break;
					case "6":
						// 退出
						out();
						out2();
						break;
					case "7":
						help();
						flag = true;
						break;
					default:
						Thread.sleep(500);
						System.out.println("输入有误，请重新输入...");
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("您的輸入可能有误...");
			System.out.println(e.toString());
		}

	}

	private static void deletStu() {
		try {
			while (flag) {
				System.out.println("\t\t 下面是删除信息功能");
				show1();
				System.out.println();
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("**\t\t" + "请输入学号" + "\t\t**");
				String src = in.next();
				student = get(src);
				System.out.println(student.toString());
				System.out.println("**\t\t" + "以上为已有信息，确定要删除？退出可按1" + "\t\t**");
				out();
				if (flag) {

					if (delet(student)) {
						System.out.println("\t【删除成功】");
						System.out.println();
						show1();
						sorting();
						out();
						out2();
					} else {
						System.out.println();
						System.out.println("\t【删除失败】");
						System.out.println("请重试..");

					}

				}

			}
		} catch (Exception e) {

		}
	}

	private static void findstu() {
		try {
			while (flag) {
				System.out.println("**\t\t" + "当前是查找学生学籍功能" + "\t\t**");
				show1();
				System.out.println();
				System.out.println("\t\t**【温馨提示】\t\t**");
				System.out.println("**  您可以通过学号，或者姓名来查找学生学籍信息  **");
				System.out.println("接下来请输入要查询的学生的学号或姓名");
				String src = in.next();
				ArrayList<Student> List = find(src);
				System.out.println("**\t\t 一共" + List.size() + "个学生哦**\t\t");
				for (int i = 0; i < List.size(); i++) {
					System.out.println(List.get(i).toString());
				}
				out();
				out2();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	private static ArrayList<Student> find(String src) throws Exception {
		ArrayList<Student> lis = new ArrayList<Student>();
		Iterator<Student> Ite = DateBase.getsList().iterator();

		System.out.println("\t 亲是要按学号查询还是按姓名查询");
		System.out.println("**\t1,学号    2，姓名\t\t**");
		System.out.println("**\t 如果亲查询关键字有问题退出请按  0\t\t**");
		while (flag) {
			String sc = in.next();
			switch (sc) {
			case "1":
				if (isNum(src)) {
					student = get(src);
					lis.add(student);
					flag = false;
				} else {

					System.out.println("你输入的不是学号吧,怎么跑这来啦？重输..");
					continue;
				}

			case "2":
				if (src.startsWith("0") && src.startsWith("0", 1)) {
					System.out.println("你输的学号怎么跑这来啦？重输..");
					continue;
				} else {
					while (Ite.hasNext()) {
						student = Ite.next();// 依次判断对象
						if (student.getName().indexOf(src) == 0) {
							lis.add(student);
						}
					}

					flag = false;
				}
				break;
			case "0":
				out();
				out2();
				break;
			default:
				System.out.println("输入有误，重输..");
				continue;
			}
		}
		flag = true;
		return lis;
	}

	public static boolean isNum(String a) {// ASCII 判断是否含数字或字母
		for (int i = a.length(); --i >= 0;) {
			int chr = a.charAt(i);// 返回当前字符判断
			if ((chr > 47 && chr < 58) || (chr > 64 && chr < 91) || (chr > 96 && chr < 123)) {
				return true;
			}
		}
		return false;
	}

	private static void setStu() {
		try {
			while (flag) {
				System.out.println("\t\t 当前使用的是修改学籍功能");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("请输入您的学号");
				String src = in.next();
				student = get(src);
				System.out.println(student.toString());
				show2();
				String sc = in.next();
				switch (sc) {
				case "1":// 姓名
					System.out.println("**\t\t 请输入姓名 \t\t**");
					student.setName(in.next());
					break;
				case "2":// 学号
					System.out.println("**\t\t 请输入学号 \t\t**");
					while (true) {
						System.out.println("\t【学号前两位为0，请不要乱输哦】");
						String num = in.next();
						if ((num.startsWith("0")) || num.startsWith("0", 1)) {
							student.setNum(num);
							break;
						} else {
							System.out.println("【头给你打爆，给我乱输..重输】");
							continue;
						}
					}
					break;
				case "3":// 年龄
					System.out.println("**\t\t 请输入年龄 \t\t**");
					while (true) {
						int setAge = in.nextInt();
						if (setAge > 0 && setAge <= 200) {
							student.setAge(setAge);
							break;
						} else {
							System.out.println("【头给你打爆，给我乱输..重输】");
							continue;
						}
					}
					break;
				case "4":// 性别
					System.out.println("\t\t 请输入性别 \t\t**");
					while (true) {
						String gender = in.next();
						if ((gender.equals("男")) || gender.equals("女")) {
							student.setGender(gender);
							break;
						} else {
							System.out.println("【头给你打爆，给我乱输..重输】");
							continue;
						}
					}
					break;
				case "5":// 电话
					System.out.println("**\t\t 请输入电话号码 \t\t**");
					while (true) {
						String phone = in.next();
						if ((phone.startsWith("1") && phone.length() == 11)) {// 用starWith判断字符串是否从指定前缀开始
							student.setGender(phone);
							break;
						} else {
							System.out.println("【头给你打爆，给我乱输..重输】");
							continue;
						}
					}
					break;
				case "6":// 籍贯
					System.out.println("**\t\t 请输入籍贯 \t\t**");
					student.setNativeplace(in.next());
					break;
				case "7":// 所在系部
					System.out.println("**\t\t 请输入所在系部 \t\t**");
					student.setDepartment(in.next());
					break;
				case "8":// 学籍状态
					System.out.println("**\t\t 学籍变动情况  \t\t**");
					student.setChang(in.next());
					break;
				case "9":// 是否毕业
					System.out.println("**\t\t 是否毕业 \t\t**");
					while (true) {
						String graduate = in.next();
						if ((graduate.equals("是")) || graduate.equals("否")) {
							student.setGraduate(graduate);
							break;
						} else {
							System.out.println("【头给你打爆，给我乱输..重输】");
							continue;
						}
					}
					break;
				case "0":// 退出
					out();
					out2();
					break;
				default:
					System.out.println("【输入有误请重试】");

					continue;
				}

				if (flag) {
					System.out.println(student.toString());
					if (setStu(student)) {
						System.out.println("\t\t【修改成功】");
						sorting();
						out();
						out2();
					} else {
						System.out.println("\t\t【修改失败】");
						out();
						out2();
					}
					System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void showStu() throws Exception {
		System.out.println();
		show1();
		System.out.println();
		System.out.println("**\t\t 学籍信息表 \t\t**");
		System.out.println("");
		for (int i = 0; i < DateBase.getsList().size(); i++) {
			System.out.println(DateBase.getsList().get(i).toString());
		}
		out3();
	}

	private static void addstu() throws Exception {
		try {
			while (flag) {
				Student student = new Student();
				System.out.println("\t\t【正在使用的是添加学生信息功能...】");
				show1();
				System.out.println();
				System.out.println("**\t\t 请输入姓名 \t\t**");
				student.setName(in.next());
				System.out.println("**\t\t 请输入年龄 \t\t**");
				while (true) {
					int setAge = in.nextInt();
					if (setAge > 0 && setAge <= 200) {
						student.setAge(setAge);
						break;
					} else {
						System.out.println("【头给你打爆，给我乱输..重输】");
						continue;
					}
				}

				System.out.println("\t\t 请输入性别 \t\t**");
				while (true) {
					String gender = in.next();
					if ((gender.equals("男")) || gender.equals("女")) {
						student.setGender(gender);
						break;
					} else {
						System.out.println("【头给你打爆，给我乱输..重输】");
						continue;
					}
				}

				System.out.println("**\t\t 请输入学号 \t\t**");
				while (flag) {
					System.out.println("\t【学号前两位为0，请不要乱输哦】");
					String num = in.next();
					if ((pan(num) == true) && (num.startsWith("0")) && num.startsWith("0", 1)) {
						student.setNum(num);
						flag = false;
					} else {
						System.out.println("【头给你打爆，给我乱输..重输】");
						continue;
					}
				}
				flag = true;
				System.out.println("**\t\t 请输入籍贯 \t\t**");
				student.setNativeplace(in.next());
				System.out.println("**\t\t 请输入所在系部 \t\t**");
				student.setDepartment(in.next());
				System.out.println("**\t\t 请输入电话号码 \t\t**");
				while (true) {
					String phone = in.next();
					if ((phone.startsWith("1") && phone.length() == 11)) {// 用starWith判断字符串是否从指定前缀开始
						student.setPhone(phone);
						break;
					} else {
						System.out.println("【头给你打爆，给我乱输..重输】");
						continue;
					}
				}
				System.out.println("**\t\t 学籍变动情况  \t\t**");
				student.setChang(in.next());
				System.out.println("**\t\t 是否毕业 \t\t**");
				while (true) {
					String graduate = in.next();
					if ((graduate.equals("是")) || graduate.equals("否")) {
						student.setGraduate(graduate);
						break;
					} else {
						System.out.println("【头给你打爆，给我乱输..重输】");
						continue;
					}
				}
				System.out.println();
				System.out.println("\t 【正在设置...】");
				System.out.println();
				System.out.println("\t 【请检查信息是否有误】");
				System.out.println(student.toString());

				if (add(student)) {
					System.out.println("\t 【添加成功】");
					out();
					out2();
				}

			}
			sorting();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public static boolean pan(String num) {
		for (int i = 0; i < DateBase.getsList().size(); i++) {
			if ((DateBase.getsList().get(i).getNum()).compareTo(num) == 0) {
				return false;
			}
		}
		return true;
	}

	private static void menu() throws Exception {// 菜单
		show1();
		System.out.print("\n**" + "\t\t 1,录入学籍信息\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 2,显示学籍信息\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 3,修改学籍信息\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 4,查询学籍信息\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 5,删除学籍信息\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 6,退出学籍管理系统\t\t**");
		System.out.println();
		System.out.println("\n**" + "\t\t 7,使用帮助\t\t**");
		show1();
		System.out.println();
	}

	private static void help() throws Exception {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\t\t 下面是对您可能有帮助的一些信息");
		String a = "\t\t\t【注意事项】";
		a += "\n在添加信息时，学号请以  00 开头哦。";
		a += "\n您的性别请在男，女之间任意挑选，但不要随性发挥哦。";
		a += "\n电话号码限制为11位，且必须为  1开头，不允许使用座机短位号码（敬请谅解，此处不含歧视座机）";
		a += "\n如果任有许多您不满意的地方请联系我，我改还不行嘛，亲别生气。";
		a += "\n该系统尚不完善，任在改进，希望使用是敬请谅解";
		a += "\n作者：匿名上书                                   最近更新时间：2020年";
		System.out.println(a);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

		out3();
	}

	private static void read() {
		while (true) {
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("\t\t\t【使用须知】");
			String a = "\n\t您好，欢迎使用本系统.";
			a += "\n\t该系统可能有些您不满意的地方敬请谅解，我们会继续改进..";
			a += "\n\t我们可能会获取您的一些权限和一些您的日常操作来改进产品。";
			a += "\n\t在您使用过程中如果涉及一些隐私，我们郑重承诺，绝不外泄，如果您有任何问题可与我联系";
			a += "\n\t\t\t希望您使用愉快";
			System.out.println(a);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("\n\t 是否已经阅读并同意该须知");
			System.out.println("\t同意请按 1，不同意请按2并退出");
			String cherk = in.next();
			if (cherk.equals("1")) {
				break;
			}
			if (cherk.equals("2")) {

				flag = false;
				break;

			}
		}

	}

//------ 辅助类方法--------------- 辅助类方法---------------- 辅助类方法--------------------------------
//----------- 辅助类方法--------------------- 辅助类方法------------------ 辅助类方法-------------------

	// 删除
	public static boolean delet(Student stu) {

		return DateBase.sList.remove(stu);
	}

	private static boolean setStu(Student s) {
		DateBase.sList.remove(get(s.getNum()));
		return DateBase.getsList().add(s);
	}

	// 找到相应学生的学籍信息
	private static Student get(String num) {

		for (int i = 0; i < DateBase.sList.size(); i++) {
			if ((DateBase.getsList().get(i).getNum()).compareTo(num) == 0) {
				return DateBase.getsList().get(i);
			}
		}

		return null;
	}

	// 增加
	private static boolean add(Student stu) {

		return DateBase.sList.add(stu);
	}

	// 排序，compareto左边大于右边则大于一
	private static void sorting() {

		ArrayList<Student> list = DateBase.getsList();
		Student stu = new Student();
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - i - 1; j++) {
				if (list.get(j).getNum().compareTo(list.get(j + 1).getNum()) > 0) {
					stu = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, stu);
				}
			}
		}
	}

	// 显示方法
	private static void show1() throws Exception {
		System.out.println();
		for (int i = 1; i < 45; i++) {
			System.out.print("&");
			Thread.sleep(50);
		}
	}

	private static void show2() throws Exception {
		System.out.println();
		show1();
		System.out.println();
		System.out.println();
		System.out.print("\n**" + "\t\t 1，修改姓名\t\t**");
		System.out.print("\n**" + "\t\t 2，修改学号\t\t**");
		System.out.print("\n**" + "\t\t 3，修改年龄\t\t**");
		System.out.print("\n**" + "\t\t 4，修改性别\t\t**");
		System.out.print("\n**" + "\t\t 5，修改电话号码\t\t**");
		System.out.print("\n**" + "\t\t 6，修改籍贯\t\t**");
		System.out.print("\n**" + "\t\t 7，修改所在系部\t\t**");
		System.out.print("\n**" + "\t\t 8，修改学籍状态\t\t**");
		System.out.print("\n**" + "\t\t 9，是否毕业\t\t**");
		System.out.print("\n**" + "\t\t 0，退出    \t\t**");
		System.out.println();
		show1();
		System.out.println();
	}

	// 退出方法
	public static void out() {// 两个条件
		try {
			System.out.println();
			System.out.println("是否确定退出？" + "1.是    2.否");
			while (true) {
				String a = in.next();
				if (a.equals("1")) {
					flag = false;
					break;
				} else if (a.equals("2")) {
					flag = true;
					break;
				} else {
					System.out.println("输入有误，请重新输入。");
				}
			}
		} catch (Exception e) {
			System.out.println("报错了，你到底对它干了什么？");
			System.out.println(e.toString());
		}

	}

	private static void out2() throws Exception {// 退出返回显示

		if (flag) {
			Thread.sleep(500);
			System.out.println("\t\t\t 正在返回...");
		} else {
			Thread.sleep(500);
			System.out.println("\t\t\t 欢迎下次使用...");
		}
	}

	private static void out3() {// 一个条件

		try {
			while (flag) {
				System.out.println("退出请按1");
				String sc = in.next();
				if (sc.equals("1")) {
					flag = false;
					break;
				} else {
					System.out.println("输入有误..");
				}
			}
		} catch (Exception e) {
			System.out.println("报错了，你到底对它干了什么？");
			System.out.println(e.toString());
		}

	}

}
