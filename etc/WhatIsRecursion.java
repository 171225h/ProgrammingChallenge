package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WhatIsRecursion {

	// 17478번	2021.01.07.
	/*
	 * 출력형식이 틀려서 애먹은 문제
	 * 11개월 후에 푸니 또 풀렸다
	 * 문자열 비교 사이트를 애용하자
	 */
	
	static StringBuilder sb;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		n = Integer.parseInt(br.readLine());
		String[] set = {"어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n",
				"\"재귀함수가 뭔가요?\"\n",
				"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
				"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
		"라고 답변하였지.\n"};
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
