package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountOfCombinationZero {
   
   // 2004��   2021.01.06.
   /* 
    * ��ĥ�� ����ߴµ� �𸣰ھ ���������� ���� �ô��� �Ʒ��� ���� ��Ʈ�� �־���.
    * https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
    * ó���� 5�� �����µ� �׷����� 5 1�� �Է����� ���ö� ������ �����.
    * �׷��� 5�� 2�� �� �� ���� ������� ������ Ǯ����
    */

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      long n = Long.parseLong(st.nextToken());
      long m = Long.parseLong(st.nextToken());
      
      long nTwo = findTrailingTwos(n);
      long nFive = findTrailingFives(n);
      long n_mTwo = findTrailingTwos(n-m);
      long n_mFive = findTrailingFives(n-m);
      long mTwo = findTrailingTwos(m);
      long mFive = findTrailingFives(m);
      
      
      long resultTwo = nTwo-n_mTwo-mTwo;
      long resultFive = nFive-n_mFive-mFive;
      long result = Math.min(resultTwo, resultFive);
      result = (result<=0) ? 0 : result;
      bw.write(result+"");
      bw.flush();
      bw.close();
      
   }

   public static long findTrailingFives(long n) {
      long count = 0;
      for(long i = 5; n/i>=1; i*=5) {
         count += n/i;
      }
      
      return count;
   }
   
   public static long findTrailingTwos(long n) {
      long count = 0;
      for(long i = 2; n/i>=1; i*=2) {
         count += n/i;
      }
      
      return count;
   }

}