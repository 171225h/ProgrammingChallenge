package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindParentNode {
	
	/*
	 * fail
	 * 11725
	 * 2022.03.20.
	 * 
	 * tree�� ���鶧 ���� ����� ������? �� �� �����ؾߵǴ� �����̤�
	 * arr�� ������ΰ� list�� �����...
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		// tree �ʱ�ȭ
		ArrayList<ArrayList> arr = new ArrayList<>();
		for(int i = 0; i<=n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		// input
		StringTokenizer st = null;
		
		int a, b;
		for(int i = 1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			// ������̱� ������ �� �� �־���
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		int[] result = BFS(arr);
		
		// output
		for(int i = 2; i<=n; i++)
			bw.write(result[i]+"\n");
		bw.flush();
		bw.close();
	}

	public static int[] BFS(ArrayList<ArrayList> arr) {
		int[] result = new int[arr.size()];
		
		Queue<Integer> que = new LinkedList<>();
		ArrayList<Integer> tempArr = null;
		
		// root node�� 1�� ������ �־���
		int parentNode = 1;
		que.add(parentNode);
		
		
		while(!que.isEmpty()) {
			parentNode = que.poll();
			tempArr = arr.get(parentNode);
			
			for(int i = 0; i<tempArr.size(); i++) {
				
				// �ѹ��� �湮���� �ʾ��� ��, que�� �־��ְ�, �θ��� ǥ��
				if(result[tempArr.get(i)]==0) {
					que.add(tempArr.get(i));
					result[tempArr.get(i)] = parentNode;
				}
			}
		}

		return result;
	}

}
