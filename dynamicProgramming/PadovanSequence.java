package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PadovanSequence {

   // 9461번    2021.03.08.
   
   /*
    * dp[i]=dp[i-2]+dp[i-3]
    * 규칙을 확인하고 배열을 long배열로 해주자!
    * int로 하면 오버플로우가 남..
    */
   
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      long[] dp = new long[101];
      
      dp[1]=1;
      dp[2]=1;
      dp[3]=1;
      
      for(int i = 4; i<101; i++)
         dp[i]=dp[i-2]+dp[i-3];
      
      
      int n = Integer.parseInt(br.readLine());
      int temp;
      
      for(int i = 0; i<n; i++) {
         temp = Integer.parseInt(br.readLine());
         bw.write(dp[temp]+"");
         
         if(i<n-1)
            bw.newLine();
      }
      
      bw.flush();
      bw.close();
   }

}