package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AaddB6 {

   // 10953번    2021.02.15.
   
   /*
    * StringTokenizer를 이용해서 숫자만 토큰으로 만들어주자
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int testCase = Integer.parseInt(br.readLine());
      
      StringTokenizer st = null;
      int a, b;
      for(int i = 0; i<testCase; i++) {
         st = new StringTokenizer(br.readLine(), ", \n");
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
         
         bw.write((a+b)+"");
         
         if(i < testCase-1)
            bw.write("\n");
      }
      
      bw.flush();
      bw.close();
   }

}