package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star16 {

   // 10991��    2021.02.15.
   
   /*
    * ���� ��Ģ�� ã�� �Ϳ� ���ϴٴ� ���� �˾Ҵ�.
    * �� 10~20�а� ������ ���鼭 ��Ģ�� ã�ƺ��� ������ �⸣��
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      
      for(int i = 1; i<=n; i++) {
         for(int j = 1; j<=n+i-1; j++) {
            if(i%2==1) {   // Ȧ�� ��
               if(j%2==n%2 && j >= n-i && j <= n+i ) {
                  bw.write("*");
               }
               else
                  bw.write(" ");
               
            }
            else {         // ¦�� ��
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