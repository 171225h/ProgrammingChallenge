package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WoodCutting {
	
	// 2805번	2021.01.14.
	
	/*
	 * 처음에 풀 때는, count, temp, result를 int형으로 만들고 풀었다
	 * 그랬더니 시간초과가 났다.
	 * 형변환 쪽에서 문제일까? 하고 위의 것들을 다 long으로 바꾸었더니 바로 풀렸다.
	 * 
	 * 문제를 풀고 생각해보니...
	 * 형변환때문에 시간이 오래걸린 것이 아니라
	 * while문 안에서 나무를 세는 부분에서 int보다 더 큰 수가 들어올 때
	 * overflow가 나서 문제가 생긴 것 같다
	 * 시간초과는 bigO가 아닌 이유로도 날 수 있다는 점을 배웠다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 나무 수
		int m = Integer.parseInt(st.nextToken());	// 가져갈 나무 수

		int[] woods = new int[n];
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			woods[i]=Integer.parseInt(st.nextToken());
		
		long left = 0;
		long right = 2000000000;
		long median = (left+right)/2;
		
		long count = 0;
		long temp = 0;
		long result = 0;
		
		while(left<=median) {
			count = 0;
			
			for(int i = 0; i<n; i++) {
				temp = woods[i]-median;
				if(temp>0)
					count+=temp;
			}
			
			if(count<m) {
				right = median-1;
				median = (left+right)/2;
			}
			else {
				result = median;
				left = median+1;
				median = (left+right)/2;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
