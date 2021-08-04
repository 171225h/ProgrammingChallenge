package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CoordinateCompress {
	
	// 18870번 2021.08.04.
	/*
	 * set에 중복 없애고 sort, map에 넣은 후 count도 같이 넣어줌
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp = 0;
		int[] tempArr = new int[n];

		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i<n; i++) {
			temp = Integer.parseInt(st.nextToken());
			set.add(temp);
			tempArr[i] = temp;
		}

		ArrayList<Integer> arr = new ArrayList<>(set);
		Collections.sort(arr);

		for(int i = 0; i<arr.size(); i++) 
			map.put(arr.get(i), i);

		for(int i = 0; i<n; i++)
			sb.append(map.get(tempArr[i])+" ");
		sb.delete(sb.length()-1, sb.length());

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
