package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumDecomposition {
   
   // 2225��    2021.03.08.
   
   /*
    * https://sihyungyou.github.io/baekjoon-2225/
    * 1�ð� ���� Ǯ�� ���� ��.��
    * 
    * ������ �ľ��ϴ°� �߿���!
    * 2���� �迭�� ���� ���� ��,
    * dp[k][n]+=dp[k-1][n-L]�� ������ �� �ִµ�
    * �̶� L�� 0����~n�����̴�
    * 
    * ������ �ľ��Ҷ� ������ ���� �����Ѵٴ� �� �����ؼ� Ǯ��
    * �ʹ� �����ϰ� dp[k-1]���� �� ���ؼ� ���ϰ� �ټ����... ��� �������� ����!
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