package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumDecomposition {
   
   // 2225번    2021.03.08.
   
   /*
    * https://sihyungyou.github.io/baekjoon-2225/
    * 1시간 내로 풀기 실패 ㅜ.ㅠ
    * 
    * 패턴을 파악하는게 중요함!
    * 2차원 배열로 생각 했을 때,
    * dp[k][n]+=dp[k-1][n-L]로 생각할 수 있는데
    * 이때 L은 0부터~n까지이다
    * 
    * 패턴을 파악할때 마지막 수를 고정한다는 등 생각해서 풀기
    * 너무 복잡하게 dp[k-1]에서 다 더해서 곱하고 줄세우고... 등등 생각하지 말기!
    */

   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int[][] dp = new int[201][201];
      int mod = 1000000000;

      for(int i = 0; i<201; i++) {
         dp[1][i] = 1;
         dp[0][i] = 1;
      }

      for(int i=2; i<201; i++) {
         for(int j=0; j<201; j++) { 
            for(int l=0; l<=j; l++) {
               
               dp[i][j] = (dp[i-1][j-l]+dp[i][j])%mod;
            
            }
         }
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      bw.write(dp[k][n]+"");
      bw.flush();
      bw.close();
   }

}