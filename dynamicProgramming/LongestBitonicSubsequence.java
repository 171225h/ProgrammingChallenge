package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LongestBitonicSubsequence {

	// 11054¹ø 	2021.02.24.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dpIn = new int[n];
		int[] dpDe = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int result = 0;
		for(int i = 0; i<n; i++) {
			dpIn[i]=1;
			for(int j = 0; j<i; j++) {
				if(arr[j]<arr[i])
					dpIn[i]=Math.max(dpIn[i], dpIn[j]+1);
			}
		}
		for(int i = n-1; i>-1; i--) {
			dpDe[i]=1;
			for(int j = n-1; j>i; j--) {
				if(arr[j]<arr[i])
					dpDe[i]=Math.max(dpDe[i], dpDe[j]+1);
			}
		}

		for(int i = 0; i<n; i++) {
			if(result<dpIn[i]+dpDe[i]-1)
				result=dpIn[i]+dpDe[i]-1;
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
