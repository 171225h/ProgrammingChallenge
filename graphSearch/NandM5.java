package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM5 {

	static int arr[];
	static int check[];

	/*
	 * 15654
	 * 2022.03.20.
	 * 
	 * DFS로 쉽게 풀 수 있는 문제
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());


		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		check = new int[n];

		for(int i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		DFS(m, "");


	}

	public static void DFS(int cnt, String s) {
		if(cnt<=0) {
			System.out.println(s);
			return;
		}

		for(int i = 0; i<arr.length; i++) {
			if(check[i]==0) {
				check[i]=1;
				DFS(cnt-1, s+arr[i]+" ");
				check[i]=0;
			}
		}
	}

}
