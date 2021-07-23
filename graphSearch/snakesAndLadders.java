package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class snakesAndLadders {

	/*
	 * 2021.07.23. 16928번
	 * 
	 * 아니 알고리즘은 보자마자 아 BFS로 풀자고 생각해서 바로 풀었는데
	 * 밑에 사다리, 뱀 넣는 부분에서 거꾸로 넣어서 자꾸 틀렸다
	 * 자잘한 실수 줄이기ㅜ.... 왕속상 3시간동안 풀었어... 
	 */
	
	static int result = 0;
	static boolean[] check;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[101];
		check = new boolean[101];
		count = new int[101];
		count[1]=0;

		int a = 0;
		int b = 0;

		for(int i = 0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			arr[a]=b;
		}
		result = BFS(arr);

		bw.write(result+"");
		bw.flush();
		bw.close();

	}

	private static int BFS(int[] arr) {
		Queue<Integer> que = new LinkedList<>();
		que.add(1);

		int pos = 0;
		int temp = 0;

		while(!que.isEmpty() && !check[100]) {
			pos = que.poll();
			check[pos]=true;

			for(int i = 1; i<=6; i++) {
				temp = pos+i;
				if(temp>100)
					continue;

				if(arr[temp]!=0) {
					if(count[temp]==0)
						count[temp]=count[pos]+1;
					else
						count[temp]=Math.min(count[pos]+1, count[temp]);
					temp=arr[temp];

					if(count[temp]==0)
						count[temp]=count[pos]+1;
					else
						count[temp]=Math.min(count[pos]+1, count[temp]);
				}
				if(count[temp]==0)
					count[temp]=count[pos]+1;
				else
					count[temp]=Math.min(count[pos]+1, count[temp]);

				if(!check[temp])
					que.add(temp);
			}
		}

		return count[100];
	}
}
