package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GasStation {

	// 13305��	2021.01.06.
	
	/*
	 * ����̳� �׳� Ʋ�ȴµ� int������ �ƴ� long������ �Է��� ���ͼ� Ʋ�ȴ�
	 * ������ ���� Ȯ���ϱ�!
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int countOfload = Integer.parseInt(br.readLine())-1;
		long[] gasStation = new long[countOfload];
		long[] load = new long[countOfload];
		long loadSum = 0;
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<countOfload; i++) {
			load[i]=Long.parseLong(st.nextToken());
			loadSum+=load[i];
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<countOfload; i++) {
			gasStation[i]=Long.parseLong(st.nextToken());
		}

		
		long minStation = gasStation[0];
		long dpLoad = load[0];
		long result = gasStation[0]*loadSum;
		
		for(int i = 1; i<countOfload; i++) {
			if(minStation>gasStation[i]) {
				result-=minStation*(loadSum-dpLoad);
				minStation=gasStation[i];
				result+=minStation*(loadSum-dpLoad);
			}
			dpLoad+=load[i];
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
