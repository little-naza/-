package com.stu.db;

public class DateBase {// ���ݿ�

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

	public void init() {// ���ݳ�ʼ��
		name[0] = "��";
		num[0] = "��";
		age[0] = 0;
		sex[0] = "��";
		nativeplace[0] = "��";
		department[0] = "��";
		phone[0] = "��";
		chang[0] = "��";
		graduate[0] = "��";
	}

	public String name[];// ����
	public String num[];// ѧ��
	public int age[];// ����
	public String sex[];// �Ա�
	public String nativeplace[];// ����
	public String department[];// ����ϵ��
	public String phone[];// ��ϵ�绰
	public String chang[];// ѧ���䶯���
	public String graduate[];// �Ƿ��ҵ

}
