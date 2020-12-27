package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GCDandLCM {

	//2609번 2020.12.27.
	/*
	 * 최대공약수는 두 수의  약수들의 교집합
	 * 최소공배수는 두 수의 약수들의 합집합
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int tempN = n;
		int tempM = m;
		
		int[] nSet = new int[n+1];
		int[] mSet = new int[m+1];
		
		for(int i = 2; i<=n; i++) {
			while(tempN%i==0) {
				tempN/=i;
				nSet[i]++;
			}
		}
		
		for(int i = 2; i<=m; i++) {
			while(tempM%i==0) {
				tempM/=i;
				mSet[i]++;
			}
		}
		
		int GCD = 1;
		
		
		for(int i = 2; i<=Math.min(n, m); i++) {
			if(nSet[i]!=0 && mSet[i]!=0) {
				GCD *= Math.pow(i, Math.min(nSet[i], mSet[i]));
			}
		}
		
		bw.write(GCD+"\n");
		bw.write((n*m)/GCD+"");
		bw.flush();
		bw.close();
	}

}
