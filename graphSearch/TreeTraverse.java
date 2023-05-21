package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TreeTraverse {

	/*
	 * fail
	 * 1991
	 * 2022.03.23.
	 * 
	 * node class를 안만들고 풀려고 시도!
	 * 
	 * 예전 수업시간에 Stack과 Queue를 이용해서 전위, 후위 순회를 만들 수 있다는 것이 기억나서 구현!
	 * 그러나 중위를 어떻게하는지 모르겠어서 괴발새발 만들었더니 돌긴 하지만...
	 * 부모노드가 자식노드보다 먼저 등장하지 않으면 돌아가지 않는다는 것을 질문란에서 찾아볼 수 있었다
	 * 
	 * 테스트 케이스가 다 돌아간다고 정답이 아닌것을... 로직이 정확한지 이해하고 제출하도록하자
	 * 
	 * 내가 느끼기에 가장 깔끔한 코드! 아래를 참고해서 작성할 예정
	 * https://dhbang.tistory.com/27
	 */


	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int num = Integer.parseInt(br.readLine());

		tree = new int[26][2];

		int root, left, right;
		for(int i = 0; i<num; i++) {
			st = new StringTokenizer(br.readLine());

			root = st.nextToken().charAt(0) - 'A';
			left = st.nextToken().charAt(0) - 'A';
			right = st.nextToken().charAt(0) - 'A';

			tree[root][0] = left < 0 ? -1 : left;
			tree[root][1] = right < 0 ? -1 : right;
		}

		StringBuilder pre = preorder(0);
		StringBuilder in = inorder(0);
		StringBuilder post = postorder(0);

		bw.write(pre.toString()+"\n");
		bw.write(in.toString()+"\n");
		bw.write(post.toString()+"");


		bw.flush();
		bw.close();

	}

	private static StringBuilder postorder(int root) {
		if(root == -1)
			return new StringBuilder();

		StringBuilder sb = new StringBuilder();

		sb.append(postorder(tree[root][0]));
		sb.append(postorder(tree[root][1]));
		sb.append((char)(root+'A'));

		return sb;
	}

	private static StringBuilder inorder(int root) {
		if(root == -1)
			return new StringBuilder();

		StringBuilder sb = new StringBuilder();

		sb.append(inorder(tree[root][0]));
		sb.append((char)(root+'A'));
		sb.append(inorder(tree[root][1]));


		return sb;
	}

	private static StringBuilder preorder(int root) {

		if(root == -1)
			return new StringBuilder();

		StringBuilder sb = new StringBuilder();

		sb.append((char)(root+'A'));
		sb.append(preorder(tree[root][0]));
		sb.append(preorder(tree[root][1]));

		return sb;
	}


}
