package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WhatIsRecursion {

	// 17478��	2021.01.07.
	/*
	 * ��������� Ʋ���� �ָ��� ����
	 * 11���� �Ŀ� Ǫ�� �� Ǯ�ȴ�
	 * ���ڿ� �� ����Ʈ�� �ֿ�����
	 */
	
	static StringBuilder sb;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		n = Integer.parseInt(br.readLine());
		String[] set = {"��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n",
				"\"����Լ��� ������?\"\n",
				"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n",
				"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n",
				"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n",
				"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n",
		"��� �亯�Ͽ���.\n"};
		sb = new StringBuilder(set[0]);

		recursion(set, n);
		sb.delete(sb.length()-1, sb.length());

		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
	}

	public static void recursion(String[] set, int count) {
		if(count<0)
			return;
		else if(count == 0) {
			printUnderbar(count);
			sb.append(set[1]);
			printUnderbar(count);
			sb.append(set[5]);
			printUnderbar(count);
			sb.append(set[6]);
		}
		else {
			for(int i = 1; i<7; i++) {
				if(i==5) {
					recursion(set, count-1);
					continue;
				}

				printUnderbar(count);
				sb.append(set[i]);
			}
		}

	}

	public static void printUnderbar(int count) {
		for(int i = 0; i<(n-count)*4; i++)
			sb.append("_");
	}

}
