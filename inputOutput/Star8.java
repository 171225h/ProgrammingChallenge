package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star8 {

   // 2445번    2021.02.15.
   
   /*
    * for문 하나에 다 때려박느라 코드가 괴랄해졌다
    * 다른분들 코드를 보니 정말 깔끔하고 예뻤다..
    * 가독성 좋게 만드는 코드가 더 좋을 때도 있는 것 같다
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());

      for(int i = 0; i<2*n; i++) {
         if(i==n)
            continue;
         for(int j = 0; j<2*n; j++) {
            if(i<n) {
               if(j<=i || 2*n-i-1<=j)
                  bw.write("*");
               else
                  bw.write(" ");
            }
            else {
               if(j<(2*n-i) || j>=i)
                  bw.write("*");
               else
                  bw.write(" ");
            }
         }
         if(i<2*n-1)
            bw.write("\n");
      }
      bw.flush();
      bw.close();
   }

}