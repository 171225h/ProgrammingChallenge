package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfSection {
	
	/*
	 * 11659
	 * 2022.03.19.
	 * 
	 * 이중 for문으로 푸니 시간초과...
	 * sum = arr[b]-arr[a-1]만 알아낸다면 금방 푼다
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
		}
		
		int a, b;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			bw.write(arr[b]-arr[a-1]+"");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
		
		
		
		
	}

}
