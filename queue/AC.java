package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {
	
	//5430��		2020.12.28.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		char temp = 0;						//�ӽ÷� ��ɾ �ϳ��� �ɰ�����
		boolean error = false;				//error�� ������� Ȯ���ϴ� boolean

		String instruction = null;			//��ɾ �����ϴ� String
		StringTokenizer num = null;			//������ ���� �Է¹���
		StringBuilder sb = null;			//result ���� ������ stringBuilder
		Deque<Integer> dq = null;			//���� ���� deque

		boolean head = true;

		for(int i = 0; i<testCase; i++) {
			head = true;
			error = false;

			dq=new LinkedList<>();

			sb = new StringBuilder();						
			instruction = br.readLine();					// ��ɾ�
			br.readLine();									// ������ �� ����
			num = new StringTokenizer(br.readLine(), "[],");// ������ ��

			while(num.hasMoreTokens())						// ������ ���� ���� ������ �Է��� dq�� ����
				dq.add(Integer.parseInt(num.nextToken()));

			for(int j = 0; j<instruction.length(); j++){
				temp = instruction.charAt(j);
				if(temp-'R'==0)
					head = !head;
				else if(temp-'D'==0)
					if(dq.size()==0) {	//�������ǿ���, que�� ��� ���µ� D�� �ϸ� error�� ������ ��
						error = true;
						break;
					}
					else
						if(head)
							dq.poll();
						else
							dq.pollLast();

			}

			//���
			if(error)
				bw.write("error\n");
			else {
				sb.append("[");
				while(!dq.isEmpty()) {
					if(head)
						sb.append(dq.pollFirst()+",");
					else
						sb.append(dq.pollLast()+",");
				}
				// �׳� ������� ���� �����ϱ� ���� �ϳ� �̻� �������� "," ����
				if(sb.length()>=2)
					sb.deleteCharAt(sb.length()-1);
				sb.append("]");
				
				bw.write(sb.toString()+"\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
