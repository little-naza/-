package com.stu.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.stu.db.DateBase;
import com.stu.dto.Student;

public class StuImpl {// ʵ�ֲ������� ɾ �� ��
	private static Boolean flag = true;
	private static Scanner in = new Scanner(System.in);
	private static Student student = new Student();

	public static void mainMenu() {
		try {
			read();
			DateBase.init();
			while (flag) {
				menu();
				System.out.print("��������Ĳ�����");
				String sc = in.next();
				try {
					switch (sc) {
					case "1":
						addstu();
						flag = true;
						// ���ѧ����Ϣ
						break;
					case "2":
						// ��ʾ
						showStu();
						flag = true;
						break;
					case "3":
						// �޸�
						setStu();
						flag = true;
						break;
					case "4":
						// ��ѯ
						findstu();
						flag = true;
						break;
					case "5":
						// ɾ��
						deletStu();
						flag = true;
						break;
					case "6":
						// �˳�
						out();
						out2();
						break;
					case "7":
						help();
						flag = true;
						break;
					default:
						Thread.sleep(500);
						System.out.println("������������������...");
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("����ݔ���������...");
			System.out.println(e.toString());
		}

	}

	private static void deletStu() {
		try {
			while (flag) {
				System.out.println("\t\t ������ɾ����Ϣ����");
				show1();
				System.out.println();
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("**\t\t" + "������ѧ��" + "\t\t**");
				String src = in.next();
				student = get(src);
				System.out.println(student.toString());
				System.out.println("**\t\t" + "����Ϊ������Ϣ��ȷ��Ҫɾ�����˳��ɰ�1" + "\t\t**");
				out();
				if (flag) {

					if (delet(student)) {
						System.out.println("\t��ɾ���ɹ���");
						System.out.println();
						show1();
						sorting();
						out();
						out2();
					} else {
						System.out.println();
						System.out.println("\t��ɾ��ʧ�ܡ�");
						System.out.println("������..");

					}

				}

			}
		} catch (Exception e) {

		}
	}

	private static void findstu() {
		try {
			while (flag) {
				System.out.println("**\t\t" + "��ǰ�ǲ���ѧ��ѧ������" + "\t\t**");
				show1();
				System.out.println();
				System.out.println("\t\t**����ܰ��ʾ��\t\t**");
				System.out.println("**  ������ͨ��ѧ�ţ���������������ѧ��ѧ����Ϣ  **");
				System.out.println("������������Ҫ��ѯ��ѧ����ѧ�Ż�����");
				String src = in.next();
				ArrayList<Student> List = find(src);
				System.out.println("**\t\t һ��" + List.size() + "��ѧ��Ŷ**\t\t");
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

		System.out.println("\t ����Ҫ��ѧ�Ų�ѯ���ǰ�������ѯ");
		System.out.println("**\t1,ѧ��    2������\t\t**");
		System.out.println("**\t ����ײ�ѯ�ؼ����������˳��밴  0\t\t**");
		while (flag) {
			String sc = in.next();
			switch (sc) {
			case "1":
				if (isNum(src)) {
					student = get(src);
					lis.add(student);
					flag = false;
				} else {

					System.out.println("������Ĳ���ѧ�Ű�,��ô��������������..");
					continue;
				}

			case "2":
				if (src.startsWith("0") && src.startsWith("0", 1)) {
					System.out.println("�����ѧ����ô��������������..");
					continue;
				} else {
					while (Ite.hasNext()) {
						student = Ite.next();// �����ж϶���
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
				System.out.println("������������..");
				continue;
			}
		}
		flag = true;
		return lis;
	}

	public static boolean isNum(String a) {// ASCII �ж��Ƿ����ֻ���ĸ
		for (int i = a.length(); --i >= 0;) {
			int chr = a.charAt(i);// ���ص�ǰ�ַ��ж�
			if ((chr > 47 && chr < 58) || (chr > 64 && chr < 91) || (chr > 96 && chr < 123)) {
				return true;
			}
		}
		return false;
	}

	private static void setStu() {
		try {
			while (flag) {
				System.out.println("\t\t ��ǰʹ�õ����޸�ѧ������");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("����������ѧ��");
				String src = in.next();
				student = get(src);
				System.out.println(student.toString());
				show2();
				String sc = in.next();
				switch (sc) {
				case "1":// ����
					System.out.println("**\t\t ���������� \t\t**");
					student.setName(in.next());
					break;
				case "2":// ѧ��
					System.out.println("**\t\t ������ѧ�� \t\t**");
					while (true) {
						System.out.println("\t��ѧ��ǰ��λΪ0���벻Ҫ����Ŷ��");
						String num = in.next();
						if ((num.startsWith("0")) || num.startsWith("0", 1)) {
							student.setNum(num);
							break;
						} else {
							System.out.println("��ͷ����򱬣���������..���䡿");
							continue;
						}
					}
					break;
				case "3":// ����
					System.out.println("**\t\t ���������� \t\t**");
					while (true) {
						int setAge = in.nextInt();
						if (setAge > 0 && setAge <= 200) {
							student.setAge(setAge);
							break;
						} else {
							System.out.println("��ͷ����򱬣���������..���䡿");
							continue;
						}
					}
					break;
				case "4":// �Ա�
					System.out.println("\t\t �������Ա� \t\t**");
					while (true) {
						String gender = in.next();
						if ((gender.equals("��")) || gender.equals("Ů")) {
							student.setGender(gender);
							break;
						} else {
							System.out.println("��ͷ����򱬣���������..���䡿");
							continue;
						}
					}
					break;
				case "5":// �绰
					System.out.println("**\t\t ������绰���� \t\t**");
					while (true) {
						String phone = in.next();
						if ((phone.startsWith("1") && phone.length() == 11)) {// ��starWith�ж��ַ����Ƿ��ָ��ǰ׺��ʼ
							student.setGender(phone);
							break;
						} else {
							System.out.println("��ͷ����򱬣���������..���䡿");
							continue;
						}
					}
					break;
				case "6":// ����
					System.out.println("**\t\t �����뼮�� \t\t**");
					student.setNativeplace(in.next());
					break;
				case "7":// ����ϵ��
					System.out.println("**\t\t ����������ϵ�� \t\t**");
					student.setDepartment(in.next());
					break;
				case "8":// ѧ��״̬
					System.out.println("**\t\t ѧ���䶯���  \t\t**");
					student.setChang(in.next());
					break;
				case "9":// �Ƿ��ҵ
					System.out.println("**\t\t �Ƿ��ҵ \t\t**");
					while (true) {
						String graduate = in.next();
						if ((graduate.equals("��")) || graduate.equals("��")) {
							student.setGraduate(graduate);
							break;
						} else {
							System.out.println("��ͷ����򱬣���������..���䡿");
							continue;
						}
					}
					break;
				case "0":// �˳�
					out();
					out2();
					break;
				default:
					System.out.println("���������������ԡ�");

					continue;
				}

				if (flag) {
					System.out.println(student.toString());
					if (setStu(student)) {
						System.out.println("\t\t���޸ĳɹ���");
						sorting();
						out();
						out2();
					} else {
						System.out.println("\t\t���޸�ʧ�ܡ�");
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
		System.out.println("**\t\t ѧ����Ϣ�� \t\t**");
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
				System.out.println("\t\t������ʹ�õ������ѧ����Ϣ����...��");
				show1();
				System.out.println();
				System.out.println("**\t\t ���������� \t\t**");
				student.setName(in.next());
				System.out.println("**\t\t ���������� \t\t**");
				while (true) {
					int setAge = in.nextInt();
					if (setAge > 0 && setAge <= 200) {
						student.setAge(setAge);
						break;
					} else {
						System.out.println("��ͷ����򱬣���������..���䡿");
						continue;
					}
				}

				System.out.println("\t\t �������Ա� \t\t**");
				while (true) {
					String gender = in.next();
					if ((gender.equals("��")) || gender.equals("Ů")) {
						student.setGender(gender);
						break;
					} else {
						System.out.println("��ͷ����򱬣���������..���䡿");
						continue;
					}
				}

				System.out.println("**\t\t ������ѧ�� \t\t**");
				while (flag) {
					System.out.println("\t��ѧ��ǰ��λΪ0���벻Ҫ����Ŷ��");
					String num = in.next();
					if ((pan(num) == true) && (num.startsWith("0")) && num.startsWith("0", 1)) {
						student.setNum(num);
						flag = false;
					} else {
						System.out.println("��ͷ����򱬣���������..���䡿");
						continue;
					}
				}
				flag = true;
				System.out.println("**\t\t �����뼮�� \t\t**");
				student.setNativeplace(in.next());
				System.out.println("**\t\t ����������ϵ�� \t\t**");
				student.setDepartment(in.next());
				System.out.println("**\t\t ������绰���� \t\t**");
				while (true) {
					String phone = in.next();
					if ((phone.startsWith("1") && phone.length() == 11)) {// ��starWith�ж��ַ����Ƿ��ָ��ǰ׺��ʼ
						student.setPhone(phone);
						break;
					} else {
						System.out.println("��ͷ����򱬣���������..���䡿");
						continue;
					}
				}
				System.out.println("**\t\t ѧ���䶯���  \t\t**");
				student.setChang(in.next());
				System.out.println("**\t\t �Ƿ��ҵ \t\t**");
				while (true) {
					String graduate = in.next();
					if ((graduate.equals("��")) || graduate.equals("��")) {
						student.setGraduate(graduate);
						break;
					} else {
						System.out.println("��ͷ����򱬣���������..���䡿");
						continue;
					}
				}
				System.out.println();
				System.out.println("\t ����������...��");
				System.out.println();
				System.out.println("\t ��������Ϣ�Ƿ�����");
				System.out.println(student.toString());

				if (add(student)) {
					System.out.println("\t ����ӳɹ���");
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

	private static void menu() throws Exception {// �˵�
		show1();
		System.out.print("\n**" + "\t\t 1,¼��ѧ����Ϣ\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 2,��ʾѧ����Ϣ\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 3,�޸�ѧ����Ϣ\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 4,��ѯѧ����Ϣ\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 5,ɾ��ѧ����Ϣ\t\t**");
		System.out.println();
		System.out.print("\n**" + "\t\t 6,�˳�ѧ������ϵͳ\t\t**");
		System.out.println();
		System.out.println("\n**" + "\t\t 7,ʹ�ð���\t\t**");
		show1();
		System.out.println();
	}

	private static void help() throws Exception {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\t\t �����Ƕ��������а�����һЩ��Ϣ");
		String a = "\t\t\t��ע�����";
		a += "\n�������Ϣʱ��ѧ������  00 ��ͷŶ��";
		a += "\n�����Ա������У�Ů֮��������ѡ������Ҫ���Է���Ŷ��";
		a += "\n�绰��������Ϊ11λ���ұ���Ϊ  1��ͷ��������ʹ��������λ���루�����½⣬�˴���������������";
		a += "\n������������������ĵط�����ϵ�ң��ҸĻ�������ױ�������";
		a += "\n��ϵͳ�в����ƣ����ڸĽ���ϣ��ʹ���Ǿ����½�";
		a += "\n���ߣ���������                                   �������ʱ�䣺2020��";
		System.out.println(a);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

		out3();
	}

	private static void read() {
		while (true) {
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("\t\t\t��ʹ����֪��");
			String a = "\n\t���ã���ӭʹ�ñ�ϵͳ.";
			a += "\n\t��ϵͳ������Щ��������ĵط������½⣬���ǻ�����Ľ�..";
			a += "\n\t���ǿ��ܻ��ȡ����һЩȨ�޺�һЩ�����ճ��������Ľ���Ʒ��";
			a += "\n\t����ʹ�ù���������漰һЩ��˽������֣�س�ŵ��������й����������κ������������ϵ";
			a += "\n\t\t\tϣ����ʹ�����";
			System.out.println(a);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("\n\t �Ƿ��Ѿ��Ķ���ͬ�����֪");
			System.out.println("\tͬ���밴 1����ͬ���밴2���˳�");
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

//------ �����෽��--------------- �����෽��---------------- �����෽��--------------------------------
//----------- �����෽��--------------------- �����෽��------------------ �����෽��-------------------

	// ɾ��
	public static boolean delet(Student stu) {

		return DateBase.sList.remove(stu);
	}

	private static boolean setStu(Student s) {
		DateBase.sList.remove(get(s.getNum()));
		return DateBase.getsList().add(s);
	}

	// �ҵ���Ӧѧ����ѧ����Ϣ
	private static Student get(String num) {

		for (int i = 0; i < DateBase.sList.size(); i++) {
			if ((DateBase.getsList().get(i).getNum()).compareTo(num) == 0) {
				return DateBase.getsList().get(i);
			}
		}

		return null;
	}

	// ����
	private static boolean add(Student stu) {

		return DateBase.sList.add(stu);
	}

	// ����compareto��ߴ����ұ������һ
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

	// ��ʾ����
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
		System.out.print("\n**" + "\t\t 1���޸�����\t\t**");
		System.out.print("\n**" + "\t\t 2���޸�ѧ��\t\t**");
		System.out.print("\n**" + "\t\t 3���޸�����\t\t**");
		System.out.print("\n**" + "\t\t 4���޸��Ա�\t\t**");
		System.out.print("\n**" + "\t\t 5���޸ĵ绰����\t\t**");
		System.out.print("\n**" + "\t\t 6���޸ļ���\t\t**");
		System.out.print("\n**" + "\t\t 7���޸�����ϵ��\t\t**");
		System.out.print("\n**" + "\t\t 8���޸�ѧ��״̬\t\t**");
		System.out.print("\n**" + "\t\t 9���Ƿ��ҵ\t\t**");
		System.out.print("\n**" + "\t\t 0���˳�    \t\t**");
		System.out.println();
		show1();
		System.out.println();
	}

	// �˳�����
	public static void out() {// ��������
		try {
			System.out.println();
			System.out.println("�Ƿ�ȷ���˳���" + "1.��    2.��");
			while (true) {
				String a = in.next();
				if (a.equals("1")) {
					flag = false;
					break;
				} else if (a.equals("2")) {
					flag = true;
					break;
				} else {
					System.out.println("�����������������롣");
				}
			}
		} catch (Exception e) {
			System.out.println("�����ˣ��㵽�׶�������ʲô��");
			System.out.println(e.toString());
		}

	}

	private static void out2() throws Exception {// �˳�������ʾ

		if (flag) {
			Thread.sleep(500);
			System.out.println("\t\t\t ���ڷ���...");
		} else {
			Thread.sleep(500);
			System.out.println("\t\t\t ��ӭ�´�ʹ��...");
		}
	}

	private static void out3() {// һ������

		try {
			while (flag) {
				System.out.println("�˳��밴1");
				String sc = in.next();
				if (sc.equals("1")) {
					flag = false;
					break;
				} else {
					System.out.println("��������..");
				}
			}
		} catch (Exception e) {
			System.out.println("�����ˣ��㵽�׶�������ʲô��");
			System.out.println(e.toString());
		}

	}

}
