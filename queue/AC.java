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
	
	//5430번		2020.12.28.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		char temp = 0;						//임시로 명령어를 하나씩 쪼개받음
		boolean error = false;				//error가 생겼는지 확인하는 boolean

		String instruction = null;			//명령어를 저장하는 String
		StringTokenizer num = null;			//들어오는 수를 입력받음
		StringBuilder sb = null;			//result 값을 저장할 stringBuilder
		Deque<Integer> dq = null;			//수를 담을 deque

		boolean head = true;

		for(int i = 0; i<testCase; i++) {
			head = true;
			error = false;

			dq=new LinkedList<>();

			sb = new StringBuilder();						
			instruction = br.readLine();					// 명령어
			br.readLine();									// 들어오는 수 개수
			num = new StringTokenizer(br.readLine(), "[],");// 들어오는 수

			while(num.hasMoreTokens())						// 들어오는 수가 없을 때까지 입력을 dq에 저장
				dq.add(Integer.parseInt(num.nextToken()));

			for(int j = 0; j<instruction.length(); j++){
				temp = instruction.charAt(j);
				if(temp-'R'==0)
					head = !head;
				else if(temp-'D'==0)
					if(dq.size()==0) {	//문제조건에서, que에 든게 없는데 D를 하면 error로 만들라고 함
						error = true;
						break;
					}
					else
						if(head)
							dq.poll();
						else
							dq.pollLast();

			}

			//출력
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
				// 그냥 비어있을 수도 있으니까 값이 하나 이상 들어왔을때 "," 지움
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
