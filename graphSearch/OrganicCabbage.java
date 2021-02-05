package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrganicCabbage {   
   
   // 1012¹ø    2021.02.02.
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int testCase = Integer.parseInt(br.readLine());
      
      int row, col, locationNumber, x, y, result;
      int[][] graph = null;
      int[][] check = null;
      StringTokenizer st = null;
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i<testCase; i++) {
         st = new StringTokenizer(br.readLine());
         row = Integer.parseInt(st.nextToken());
         col = Integer.parseInt(st.nextToken());
         locationNumber = Integer.parseInt(st.nextToken());
         
         graph = new int[row][col];
         check = new int[row][col];
         
         for(int j = 0; j<locationNumber; j++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            graph[x][y] = 1;
         }
         
         result = check(graph, check, row, col);
         sb.append(result+"\n");
      }
      
      sb.delete(sb.length()-1, sb.length());
      bw.write(sb.toString());
      bw.flush();
      bw.close();
      
      
   }

   private static int check(int[][] graph, int[][] check, int row, int col) {
      
      int count=0;
      
      for(int i = 0; i<row; i++) {
         for(int j = 0; j<col; j++) {
            if(graph[i][j]==1 && check[i][j]==0)
               count = check(graph, check, row, col, i, j, count);
         }
      }
      
      return count;
   }

   private static int check(int[][] graph, int[][] check, int row, int col, int x, int y, int count) {
      
      check[x][y]=1;
      count++;
      
      if(x+1<row && graph[x+1][y]==1 && check[x+1][y]==0)
         check(graph, check, row, col, x+1, y, count);
      if(y+1<col && graph[x][y+1]==1 && check[x][y+1]==0)
         check(graph, check, row, col, x, y+1, count);
      if(x-1>=0 && graph[x-1][y]==1 && check[x-1][y]==0)
         check(graph, check, row, col, x-1, y, count);
      if(y-1>=0 && graph[x][y-1]==1 && check[x][y-1]==0)
         check(graph, check, row, col, x, y-1, count);
      
      return count;
   }

}