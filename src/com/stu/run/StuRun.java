package com.stu.run;

import java.util.Scanner;

import com.stu.db.DateBase;
import com.stu.dto.Student;
import com.stu.impl.StuImpl;

public class StuRun {// ������
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		// �����������
		DateBase Data = new DateBase();
		Data.init();
		mainmanu();
		// clear1();
		

	}

	public static void mainmanu() throws InterruptedException {// ������ʾ
		boolean flag = true;
		while (flag) {
			int a = sc.nextInt();
			show1();
			switch (a) {
			case 1:// 1,��ʾѧ��ѧ����Ϣ��
				break;
			case 2:// 2�� ���ѧ����Ϣ
				add();
				break;
			case 3:// 3������ѧ��ѧ����Ϣ��
				break;
			case 4:// 4���޸�ѧ��ѧ����Ϣ��
				break;
			case 5:// 5,����˵��
				break;
			}
			System.out.println("�����������������룡");
		};

	}

	public static void add() throws InterruptedException {
		Scanner in = new Scanner(System.in);
		boolean choose = true;

		a: while (choose) {
			System.out.println("------------------------------------------------------------------");
			System.out.print("������������");
			String name = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("�������Ա�");
			String sex = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("���������䣺");
			int age = in.nextInt();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("������ѧ�ţ�");
			String num = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("�����뼮�᣺");
			String nativeplace = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("����������ϵ����");
			String department = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("��������ϵ�绰��");
			String phone = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("������ѧ���䶯�����");
			String change = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");

			System.out.print("�������Ƿ��ҵ��");
			String graduate = in.nextLine();
			System.out.println("\t\t\t\t\t\t\t\t||");
			System.out.println("------------------------------------------------------------------");
			clear1();

			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\t������" + name + "\t�Ա�" + sex + "\t���䣺" + age + "\tѧ�ţ�" + num);
			System.out.println("\t���᣺" + nativeplace + "\t����ϵ����" + department + "\t��ϵ�绰��" + phone + "\tѧ���䶯�����" + change
					+ "    �Ƿ��ҵ��" + graduate);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\t������Ϣ�Ƿ�����    | �����޸��밴  1  |�˳��밴  2|");
			while (true) {
				String sc = in.nextLine();
				if (sc.equals("1")) {
					continue;
				}
				if (sc.equals("2")) {
					// �������Ǵ���ֵ
					Student student = new Student(name, num, age, sex, nativeplace, department, phone, change,
							graduate);
					StuImpl impl = new StuImpl();
					impl.addStu(student);
					break a;
				}
				System.out.println("...������������������...");
			}
		}
	}

	public static void printStuInfo() {// ��ʾѧ����Ϣ

	}

	public static void findStuByNum() {// ��ѧ�Ų���ѧ����Ϣ

	}

	public static void modifyStu() {// ��ѧ���޸�ѧ����Ϣ

	}

	public static void deleteStu() {// ɾ��ѧ����Ϣ

	}

	public static void findByName() {// ��������ѯѧ����Ϣ

	}

	public static void sortByNum() {// ��ѧ�Ŷ�ѧ����Ϣ���д�С��������
		DateBase date = new DateBase();
		for (int i = 1; i <= 100; i++) {
			if (date.num[0].compareTo(date.num[i]) > 0) {
				System.out.println();
			}
		}

	}

//----------------------------------------------
	public static void show1() {
		System.out.println("�c�ࡢ�c��ࡢ�c ��  �c�ࡢ���c ��c ���c��c��c�ࡢ�c���     ");
		System.out.println("�c��c���c��c�ࡢ�c��ࡢ�c ����� ���c�c��c�ࡢ�c    �c �c��");
		System.out.println("�c       1,��ʾѧ��ѧ����Ϣ��    2�� ���ѧ����Ϣ  �c��  ����c  �c");
		System.out.println("�� �ࡢ�c��c��c�� �c��5,����˵���c�ࡢ�c �c��c��    �c��c��");
		System.out.println("�ࡢ��3������ѧ��ѧ����Ϣ��    4���޸�ѧ��ѧ����Ϣ�����c��  �c");
		System.out.println("�ࡢ���c ��c ���c���c�c��c���c��c�ࡢ�c���c��c�ࡢ  ��");
		System.out.println("�ࡢ���c ��c ���c���c�c��c���c��c�ࡢ�c���c��c�ࡢ  ��");
	}

	public static void clear1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		Thread.sleep(2000);
	}
}
