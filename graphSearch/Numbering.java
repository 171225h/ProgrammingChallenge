package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Numbering {

   // 2667��    2021.02.02.
   
   /*
    * �����ذ����α׷��ֿ��� Ǯ� ����!
    * ���� ������������ �����϶�� �� ������ ��� Ʋ�ȴ�.
    * ������ ������ �� ����
    */
   
   static int[][] graph;
   static int[][] check;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      graph = new int[n][n];
      check = new int[n][n];
      
      String s = null;
      for(int i = 0; i<n; i++) {
         s = br.readLine();
         for(int j = 0; j<n; j++) {
            graph[i][j]=s.charAt(j)-'0';
         }
      }
      
      int result;
      ArrayList<Integer> arr = new ArrayList<>();
      
      for(int i = 0; i<n; i++) {
         for(int j = 0; j<n; j++) {
            if(graph[i][j]==1 && check[i][j]==0) {
               result = checking(i, j, 0);
               arr.add(result);
            }
         }
      }
      
      Collections.sort(arr);

      bw.write(arr.size()+"\n");
      for(int i = 0; i<arr.size(); i++)
         bw.write(arr.get(i)+"\n");
      bw.flush();
      bw.close();
   }

   private static int checking(int x, int y, int count) {
      
      check[x][y]=1;
      count++;
      
      if(x+1 < graph.length && graph[x+1][y]==1 && check[x+1][y]==0)
         count = checking(x+1, y, count);
      if(y+1 < graph.length && graph[x][y+1]==1 && check[x][y+1]==0)
         count = checking(x, y+1, count);
      if(x-1 >= 0 && graph[x-1][y]==1 && check[x-1][y]==0)
         count = checking(x-1, y, count);
      if(y-1 >= 0 && graph[x][y-1]==1 && check[x][y-1]==0)
         count = checking(x, y-1, count);
      
      return count;
   }

}