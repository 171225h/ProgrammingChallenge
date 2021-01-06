package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberCard2 {

	// 10816��	2021.01.06.
	
	/*
	 * �ڷᱸ�� map�� �̿��ؼ� ���� Ǯ �� �ִ� ����!
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int temp = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		// input
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp))	//������ ���� ������ +1
				map.put(temp, map.get(temp)+1);
			else						//������ �߰��ϰ� value�� 1
				map.put(temp, 1);
		}
		
		// map�� �̿�����
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp))
				bw.write(map.get(temp)+"");
			else
				bw.write("0");
			
			if(i<n-1)
				bw.write(" ");
		}
		
		bw.flush();
		bw.close();
	}
}
