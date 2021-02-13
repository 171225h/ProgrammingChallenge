package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router {

	// 2110번 	2021.02.13.
	
	/*
	 * 처음에 푼 풀이로 답이 안나오자 테스트 케이스를 찾기 위해
	 * 질문 탭에 갔지만 아래와 같은 글을 만나고 내 접근이 틀렸다는 것을 알았다.
	 * https://www.acmicpc.net/board/view/8301
	 * 
	 * 이진탐색을 다양하게 활용할 수 있다는 것을 잘 알게된 문제
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// 집 수
		int c = Integer.parseInt(st.nextToken());	// 설치할 공유기

		int[] arr = new int[n];

		for(int i = 0; i<n; i++)
			arr[i]=Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		long left = 0;
		long right = arr[n-1]-arr[0];
		long mid=0;
		long result = mid;

		while(left<=right) {

			mid = (left+right)/2;

			if(promising(mid, c-1, arr)) {
				left = mid+1;
				result = Math.max(mid, result);
				//System.out.println("result = "+result);
			}
			else {
				right = mid-1;
			}
		}

		bw.write(result+"");
		bw.flush();
		bw.close();


	}

	/**
	 * length만큼 거리를 벌리면서 router를 c개 설치할 수 있는지 확인합니다.
	 * @param length	거리
	 * @param count		router 개수
	 * @param arr		router 설치할 집 위치
	 * @return	설치가 되면 true, 아니면 false
	 */
	private static boolean promising(long length, int count, int[] arr) {
		int temp = 0;

		for(int i = 1; i<arr.length; i++) {
			temp = temp + arr[i]-arr[i-1];
			if(temp>=length) {
				count--;
				temp = 0;
			}
		}

		if(count<=0)
			return true;
		else
			return false;
	}

}
