package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfSection5 {
   
   /*
    * 11660
    * 2022.03.23.
    * 
    * 며칠전에 푼 문제랑 매우매우 유사한 문제!
    * DSLR처럼 풀면 된다~
    */
   
   static int[][] arr;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      arr = new int[n+1][n+1];
      
      for(int i = 0; i<n; i++) {
         
         st = new StringTokenizer(br.readLine());
         
         for(int j = 0; j<n; j++) {
            arr[i+1][j+1] = Integer.parseInt(st.nextToken()) + arr[i+1][j];
         }
      }
      
      int x1, x2, y1, y2, sum;
      
      for(int i = 0; i<m; i++) {
         st = new StringTokenizer(br.readLine());
         
         x1 = Integer.parseInt(st.nextToken());
         y1 = Integer.parseInt(st.nextToken());
         
         x2 = Integer.parseInt(st.nextToken());
         y2 = Integer.parseInt(st.nextToken());
         
         sum = a2b(x1, y1, x2, y2);
      
         bw.write(sum+"\n");
      }
      
      bw.flush();
      bw.close();
      
   }

   private static int a2b(int x1, int y1, int x2, int y2) {
      
      int result = 0;
      
      for(int i = x1; i<= x2; i++) {
         result += arr[i][y2] - arr[i][y1-1];
      }
      
      return result;
   }

}