package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountOfCombinationZero {
   
   // 2004번   2021.01.06.
   /* 
    * 며칠간 고민했는데 모르겠어서 질문란에서 글을 봤더니 아래와 같은 힌트가 있었다.
    * https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
    * 처음엔 5만 세었는데 그러고보니 5 1이 입력으로 들어올때 문제가 생겼다.
    * 그래서 5랑 2를 둘 다 세는 방법으로 문제를 풀었다
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