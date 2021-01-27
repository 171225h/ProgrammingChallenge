package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hashing {

   // 15829번   2021.01.25.
   /*
    * 처음엔 나눌때 123457891로 그냥 나눴는데 자꾸 틀린 답이라고해서 화가났다
    * 그러다가 변수에 1234567891을 넣고 풀었더니 바로 풀렸다.
    * 
    * 계속 값을 1234567891이 아니라 123456891로 나누고 있어서 틀렸다.
    * 이런 실수를 하지않기위해 변수 안에 값을 넣는것도 있겠다는 생각이 들었다.
    */
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int l = Integer.parseInt(br.readLine());
      String s = br.readLine();
      
      long result = 0;
      long temp = 1;
      int prime = 1234567891;
      
      for(int i = 0; i<l; i++) {
         result += (((s.charAt(i)-'a'+1)% prime) * temp) % prime;
         temp = (temp * 31)%prime;
      }
      
      System.out.println(Integer.MAX_VALUE);
      
      bw.write(result%prime+"");
      bw.flush();
      bw.close();
   }

}