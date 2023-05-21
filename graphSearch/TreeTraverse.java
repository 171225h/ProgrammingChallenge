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
	 * node class�� �ȸ���� Ǯ���� �õ�!
	 * 
	 * ���� �����ð��� Stack�� Queue�� �̿��ؼ� ����, ���� ��ȸ�� ���� �� �ִٴ� ���� ��ﳪ�� ����!
	 * �׷��� ������ ����ϴ��� �𸣰ھ ���߻��� ��������� ���� ������...
	 * �θ��尡 �ڽĳ�庸�� ���� �������� ������ ���ư��� �ʴ´ٴ� ���� ���������� ã�ƺ� �� �־���
	 * 
	 * �׽�Ʈ ���̽��� �� ���ư��ٰ� ������ �ƴѰ���... ������ ��Ȯ���� �����ϰ� �����ϵ�������
	 * 
	 * ���� �����⿡ ���� ����� �ڵ�! �Ʒ��� �����ؼ� �ۼ��� ����
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
