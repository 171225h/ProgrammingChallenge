package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star17 {

   // 10992번   2021.02.15.
   
   /*
    * 10991번 응용!
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      
      for(int i = 1; i<=n; i++) {
         for(int j = 1; j<n+i; j++) {
            if(i%2==n%2) {
               if(i==n || (j==n-i+1 || j==n+i-1))
                  bw.write("*");
               else
                  bw.write(" ");
            }
            else {
               if(j==n-i+1 || j==n+i-1)
                  bw.write("*");
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