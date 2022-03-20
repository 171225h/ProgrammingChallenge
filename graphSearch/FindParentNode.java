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
	 * tree를 만들때 뭐로 만들면 좋을까? 를 잘 생각해야되는 문제ㅜㅜ
	 * arr로 만들것인가 list로 만들까...
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		// tree 초기화
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
			
			// 양방향이기 때문에 둘 다 넣어줌
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
		
		// root node는 1로 문제로 주어짐
		int parentNode = 1;
		que.add(parentNode);
		
		
		while(!que.isEmpty()) {
			parentNode = que.poll();
			tempArr = arr.get(parentNode);
			
			for(int i = 0; i<tempArr.size(); i++) {
				
				// 한번도 방문하지 않았을 때, que에 넣어주고, 부모노드 표시
				if(result[tempArr.get(i)]==0) {
					que.add(tempArr.get(i));
					result[tempArr.get(i)] = parentNode;
				}
			}
		}

		return result;
	}

}
