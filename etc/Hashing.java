package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hashing {

   // 15829��   2021.01.25.
   /*
    * ó���� ������ 123457891�� �׳� �����µ� �ڲ� Ʋ�� ���̶���ؼ� ȭ������
    * �׷��ٰ� ������ 1234567891�� �ְ� Ǯ������ �ٷ� Ǯ�ȴ�.
    * 
    * ��� ���� 1234567891�� �ƴ϶� 123456891�� ������ �־ Ʋ�ȴ�.
    * �̷� �Ǽ��� �����ʱ����� ���� �ȿ� ���� �ִ°͵� �ְڴٴ� ������ �����.
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