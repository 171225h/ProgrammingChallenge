package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FindingPassword {

   // 17219번    2021.01.25.
   
   /*
    * map으로 가볍게 풀 수 있다.
    */
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      Map<String, String> passwordList = new HashMap<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      String site = null;
      String password = null;
      for(int i = 0; i<n; i++) {
         st = new StringTokenizer(br.readLine());
         
         site = st.nextToken();
         password = st.nextToken();
         
         passwordList.put(site, password);
      }
   
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i<m; i++) {
         site = br.readLine();
         sb.append(passwordList.get(site));
         if(i<m-1)
            sb.append("\n");
      }
      
      bw.write(sb.toString());
      bw.flush();
      bw.close();
   }

}