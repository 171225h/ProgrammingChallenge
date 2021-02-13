package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeap{

   // 1655번    2021.2.10.
   
   /*
    * 풀다가 힘들어서 힌트를 봤는데 MaxHeap과 MinHeap을 쓰라는 힌트였다.
    * 결정적인 힌트로 인해 쉽게 풀었다.
    * 문제가 어려운 편은 아니나 생각하기가 위를 생각해내기가 어려운 문제
    * 
    * MaxHeap과 MinHeap의 크기 차이는
    * 서로 같거나 MaxHeap이 1 커야한다.
    * 설명은 밑에...
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringBuilder result = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      int temp = 0;

      PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> MinHeap = new PriorityQueue<>();


      //작은 수는 최대힙에 넣고 큰 수는 최소힙에 넣은 후 결과는 최대힙에서 poll;
      for(int i = 0; i<n; i++) {
         temp = Integer.parseInt(br.readLine());
         if(MaxHeap.isEmpty())   // 비어있으면 무조건 하나 넣고 시작!
            MaxHeap.add(temp);
         else {
            if(MaxHeap.size()>MinHeap.size()) {   
               // max가 클때
               if(MaxHeap.peek()>temp) {   // temp가 작으면 크기를 맞추기위해 Max에서 가장 큰 것을 Min에 넣는다
                  MaxHeap.add(temp);
                  temp = MaxHeap.poll();
                  MinHeap.add(temp);
               }
               else                   // 아니면 그냥 Min에 넣으면 된다
                  MinHeap.add(temp);
            }
            else {
               // max, min 크기가 같을떄
               if(MaxHeap.peek()<temp && MinHeap.peek()>temp) // MaxHeap과 MinHeap의 사이에 값이라면 그냥 Max에 넣는다
                  MaxHeap.add(temp);
               else if(MaxHeap.peek() > temp)               // Max의 값보다 작으면 Max에 넣고
                  MaxHeap.add(temp);
               else if(MinHeap.peek()<temp) {               // Min의 값보다 크다면 Min에서 가장 작은걸 빼서 Max에 넣어준다
                  MinHeap.add(temp);
                  temp = MinHeap.poll();
                  MaxHeap.add(temp);
               }
               else {                                 // 그 외에는 Max에!
                  MaxHeap.add(temp);
               }
            }
         }
         
         // 위의 if else문을 더 좋게 만들 수 있지만, 설명하기 쉽게 위처럼 납두기로 한다
         result.append(MaxHeap.peek()+"\n");
      }

      result.delete(result.length()-1, result.length());
      bw.write(result.toString());
      bw.flush();
      bw.close();
   }
}