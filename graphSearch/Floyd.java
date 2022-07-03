package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Floyd {
	
	// 11404�� 	2021.06.26.
	
	/*
	 * Fail
	 * 
	 * Floyd�� ��� ¥���ϴ����� �� ���������
	 * INF ó������ ���� ���� �߸��ϰ� �־��ٴ� ���� �˾Ҵ�.
	 * ���������� �̰��� �ذ��ϱ� ���ؼ� ����� 100,000���϶�� �˷��ش�
	 * 
	 * ���� floyd �˰����� ���ư��� for���� �߸� �ۼ��߱⿡ ��� �߸��� ���� �����ϴ� ���� Ȯ���ߴ�.
	 * ������ ��Ȯ�ϰ� ��� ���ư����� �����ϰ� ��������!
	 * */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int INF = 100000000;
		
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[city+1][city+1];
		
		// initialization
		for(int i = 0; i <= city; i++) {
			for(int j = 0; j <= city; j++) {
				if(i==j)
					continue;
				graph[i][j] = INF;
			}
		}
		
		StringTokenizer st = null;
		int start, end, cost;
		for(int i = 0; i<bus; i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			
			if(graph[start][end] > cost)
				graph[start][end] = cost;
		}
		
		for(int k = 1; k<=city; k++) {
			for(int i = 1; i<=city; i++) {

				for(int j = 1; j<=city; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for(int i = 1; i<=city; i++) {
			for(int j = 1; j<=city; j++) {
				if(graph[i][j]==INF)
					bw.write(0+" ");
				else
					bw.write(graph[i][j]+" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}

}
