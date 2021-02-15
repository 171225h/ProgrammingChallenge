package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star16 {

   // 10991번    2021.02.15.
   
   /*
    * 내가 규칙을 찾는 것에 약하다는 것을 알았다.
    * 한 10~20분간 손으로 쓰면서 규칙을 찾아보는 습관을 기르자
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      
      for(int i = 1; i<=n; i++) {
         for(int j = 1; j<=n+i-1; j++) {
            if(i%2==1) {   // 홀수 줄
               if(j%2==n%2 && j >= n-i && j <= n+i ) {
                  bw.write("*");
               }
               else
                  bw.write(" ");
               
            }
            else {         // 짝수 줄
               if(j%2 != n%2 && j > n-i && j < n+i ) {
                  bw.write("*");
               }
               else
                  bw.write(" ");
               
            }
         }
         
         if(i<n)
            bw.write("\n");
      }
      
      bw.flush();
      bw.close();
   }

}