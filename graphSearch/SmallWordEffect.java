package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SmallWordEffect {

	/*
	 * 2022.01.21.
	 * 1389번
	 * 
	 * 어제 풀었던 문제와 유사한 문제라 바로 플로이드 알고리즘을 생각할 수 있었다.
	 * 그러나 구현과정에서
	 * for 시작
	 * 		for 끝
	 * 			for 경유
	 * 이렇게 구현해서 계속 틀렸었다.
	 * 
	 * 플로이드 알고리즘을 다시 공부할 수 있었던 좋은 기회 ㅇ0ㅇ
	 */
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());

		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		
		double[][] arr = new double[node+1][node+1];
		for(int i = 1; i<node+1; i++) {
			arr[i][i] = 0;
			for(int j = 1; j<node+1; j++)
				arr[i][j] = Double.POSITIVE_INFINITY;
		}

		int n = 0;
		int m = 0;
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr[n][m] = 1;
			arr[m][n] = 1;
		}

		// floyd warshall algorithm
		for(int i = 1; i<node+1; i++) {			// 경유 노드
			for(int j = 1; j<node+1; j++) {		// 시작 노드
				for(int k = 1; k<node+1; k++) {	// 끝 노드
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}
		
		// 가장 작은 케빈베이컨 수 계산
		int result = Integer.MAX_VALUE;
		int index = 0;
		
		int temp = 0;
		for(int i = 1; i<node+1; i++) {
			temp = 0;
			
			// 각 사람마다 계산
			for(int j = 1; j<node+1; j++) {
				if(i==j)
					continue;
				
				temp += arr[i][j];
			}
			
			// 현재 저장된 것보다 작으면 변경
			if(result > temp) {
				result = temp;
				index = i;
			}
		}
		
		// output
		bw.write(index+"");
		bw.flush();
		bw.close();

		
		
	}

}
