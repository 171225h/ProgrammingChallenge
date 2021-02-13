package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianHeap{

   // 1655��    2021.2.10.
   
   /*
    * Ǯ�ٰ� ���� ��Ʈ�� �ôµ� MaxHeap�� MinHeap�� ����� ��Ʈ����.
    * �������� ��Ʈ�� ���� ���� Ǯ����.
    * ������ ����� ���� �ƴϳ� �����ϱⰡ ���� �����س��Ⱑ ����� ����
    * 
    * MaxHeap�� MinHeap�� ũ�� ���̴�
    * ���� ���ų� MaxHeap�� 1 Ŀ���Ѵ�.
    * ������ �ؿ�...
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringBuilder result = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      int temp = 0;

      PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> MinHeap = new PriorityQueue<>();


      //���� ���� �ִ����� �ְ� ū ���� �ּ����� ���� �� ����� �ִ������� poll;
      for(int i = 0; i<n; i++) {
         temp = Integer.parseInt(br.readLine());
         if(MaxHeap.isEmpty())   // ��������� ������ �ϳ� �ְ� ����!
            MaxHeap.add(temp);
         else {
            if(MaxHeap.size()>MinHeap.size()) {   
               // max�� Ŭ��
               if(MaxHeap.peek()>temp) {   // temp�� ������ ũ�⸦ ���߱����� Max���� ���� ū ���� Min�� �ִ´�
                  MaxHeap.add(temp);
                  temp = MaxHeap.poll();
                  MinHeap.add(temp);
               }
               else                   // �ƴϸ� �׳� Min�� ������ �ȴ�
                  MinHeap.add(temp);
            }
            else {
               // max, min ũ�Ⱑ ������
               if(MaxHeap.peek()<temp && MinHeap.peek()>temp) // MaxHeap�� MinHeap�� ���̿� ���̶�� �׳� Max�� �ִ´�
                  MaxHeap.add(temp);
               else if(MaxHeap.peek() > temp)               // Max�� ������ ������ Max�� �ְ�
                  MaxHeap.add(temp);
               else if(MinHeap.peek()<temp) {               // Min�� ������ ũ�ٸ� Min���� ���� ������ ���� Max�� �־��ش�
                  MinHeap.add(temp);
                  temp = MinHeap.poll();
                  MaxHeap.add(temp);
               }
               else {                                 // �� �ܿ��� Max��!
                  MaxHeap.add(temp);
               }
            }
         }
         
         // ���� if else���� �� ���� ���� �� ������, �����ϱ� ���� ��ó�� ���α�� �Ѵ�
         result.append(MaxHeap.peek()+"\n");
      }

      result.delete(result.length()-1, result.length());
      bw.write(result.toString());
      bw.flush();
      bw.close();
   }
}