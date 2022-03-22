package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
	
	/*
	 * 9019
	 * 2022.03.22.
	 * 
	 * 문해프 조교할때 비슷한 문제를 풀어봐서 쉽게 풀었다
	 * 시간초과에서 조금 애먹었는데.. L과 R을 더 빠른 연산으로 구현하는 게 포인트..
	 * 나는 어찌저찌 굴러가게 만들어 놨지만 잘 짠 코드를 보면 참 깔끔하게 만들어두었다..
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int testcase = Integer.parseInt(br.readLine());
		
		int a, b;
		String result = null;
			
		for(int i = 0; i<testcase; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			result = BFS(a, b);
			bw.write(result+"\n");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(5);
		
		bw.flush();
		bw.close();
		
	}

	private static String BFS(int start, int end) {
		
		Queue<Integer> que_i = new LinkedList<>();
		Queue<String> que_s = new LinkedList<>();
		int[] visited = new int[10000];
		
		visited[start] = 1;
		que_i.add(start);
		que_s.add("");
		
		int cur_i, temp_i;
		String cur_s;
		
		while(!que_i.isEmpty()) {
			cur_i = que_i.poll();
			cur_s = que_s.poll();
			
			
			// D 연산
			temp_i = funcD(cur_i);
			if(temp_i==end)
				return cur_s+"D";
			else if(visited[temp_i]==0){
				visited[temp_i]=1;
				que_i.add(temp_i);
				que_s.add(cur_s+"D");
			}
			
			// S 연산
			temp_i = funcS(cur_i);
			if(temp_i==end)
				return cur_s+"S";
			else if(visited[temp_i]==0){
				que_i.add(temp_i);
				que_s.add(cur_s+"S");
			}
			
			// L 연산
			temp_i = funcL(cur_i);
			if(temp_i==end)
				return cur_s+"L";
			else if(visited[temp_i]==0){
				visited[temp_i]=1;
				que_i.add(temp_i);
				que_s.add(cur_s+"L");
			}
			
			// R 연산
			temp_i = funcR(cur_i);
			if(temp_i==end)
				return cur_s+"R";
			else if(visited[temp_i]==0){
				visited[temp_i]=1;
				que_i.add(temp_i);
				que_s.add(cur_s+"R");
			}
			
		}
		
		return null;
	}

	private static int funcR(int cur_i) {
		int n1 = (cur_i - cur_i%1000);
		int n2 = (cur_i - n1 - cur_i%100);
		int n3 = (cur_i - n1 - n2 - cur_i%10);
		int n4 = (cur_i - n1 - n2 - n3);
		
		return n4*1000 + n1/10 + n2/10 + n3/10;
	}

	private static int funcL(int cur_i) {
		
		int n1 = (cur_i - cur_i%1000);
		int n2 = (cur_i - n1 - cur_i%100);
		int n3 = (cur_i - n1 - n2 - cur_i%10);
		int n4 = (cur_i - n1 - n2 - n3);
		
		return n2*10+n3*10+n4*10+n1/1000;
	}

	private static int funcS(int cur_i) {
		if(cur_i==0)
			return 9999;
		else
			return cur_i-1;
	}

	private static int funcD(int cur_i) {
		return (cur_i*2)%10000;
	}

}
