package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LANcable {

	// 1654번	2021.01.14.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());	// 소유한 k개의 랜선
		int n = Integer.parseInt(st.nextToken());	// n개로 만들자
		
		int[] lans = new int[k];	// 소유한 랜선 길이 저장
		
		for(int i = 0; i<k; i++) 
			lans[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(lans);
		
		long left = 1;					// 랜선의 길이는 1부터
		long right = lans[k-1];			// 가장 긴 길이까지!
		long median = (right+left)/2;
		long length = 1;
		long result = -1;
		int count = 0;					// length로 몇개의 cable을 만들 수 있는지
		
		while(left<=right) {		
			count = 0;
			length = median;
			for(int i = 0; i<k; i++) {
				count+=lans[i]/length;
			}
			
			
			if(count<n) {	// n개만큼 만들어야하는데 n개보다 모자르면 더 길이가 짧아야 함
				right=median-1;
				median = (right+left)/2;
			}
			else {			// 그게 아니라면 더 긴 길이가 있을 수 있으니 길이를 더 길게해서!
				left=median+1;
				median = (right+left)/2;
				result = length;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	
	}

}
