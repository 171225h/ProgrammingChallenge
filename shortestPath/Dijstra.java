package shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijstra {

   // 1753번    2021.01.22.
   
   /*
    * 처음에 학교 수업에서 배운대로 풀었더니 메모리 초과가 났다.
    * 그 다음에 adjacency matrix말고 list를 썼는데 시간초과가 났다
    * 찾아보니 priority Queue를 사용해서 푸는 방법이 있었다.
    * 
    * 혼자 생각해서 풀어보려고했지만 맘같이 안돼서 답을 봤다 ^0^...
    * 오늘도 또 배워간다
    */
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int vertax = Integer.parseInt(st.nextToken());
      int edge = Integer.parseInt(st.nextToken());
      
      int start = Integer.parseInt(br.readLine());
      
      // adjacency matrix를 쓰면 메모리초과가 난다...
      List<Node>[] graph = new ArrayList[vertax+1];

      for(int i = 1; i<=vertax; i++)
         graph[i] = new ArrayList<>();
      
      int x, y, weight;
      for(int i = 0; i<edge; i++) {
         st = new StringTokenizer(br.readLine());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());
         weight = Integer.parseInt(st.nextToken());
         
         graph[x].add(new Node(y, weight));
      }
      
      double[] result = djikstra(start, graph);
      
      // 출력
      for(int i = 1; i<=vertax; i++) {
         if(result[i]==Double.POSITIVE_INFINITY)
            bw.write("INF");
         else
            bw.write((int)result[i]+"");
         
         if(i<vertax)
            bw.newLine();
      }
      
      bw.flush();
      bw.close();
   }

   /**
    * start에서 갈 수 있는 노드들의 가장 짧은 거리를 배열형태로 return합니다. 
    * @param start 시작 vertax
    * @param graph 주어진 vertax
    * @return      최단거리 path
    */
   private static double[] djikstra(int start, List<Node>[] graph) {
      /*
       * 일반적인 다익스트라 알고리즘을 쓰면 시간초과로 터집니다
       * priority Queue를 사용해서 풀어보자.
       */
      
      PriorityQueue<Node> que = new PriorityQueue<>();
      boolean[] visited = new boolean[graph.length];
      double[] path = new double[graph.length];
      
      que.add(new Node(start, 0));
      Arrays.fill(path, Double.POSITIVE_INFINITY);      //INF로 초기화
      path[start] = 0;               
      
      while(!que.isEmpty()) {
         Node currentNode = que.poll();   // 가장 가까운 node의 edge를 꺼내온다
         start = currentNode.vertax;      // 이 노드는 어디로 향하는 node인지 확인
         
         if(visited[start]) continue;   // 방문한 node라면 굳이 갈 필요 x
         
         visited[start] = true;         // 방문했다고 확인해주기
         
         for(Node node : graph[start]) {
            // 이 부분은 일반 다익스트라 알고리즘과 같음!
            if(path[node.vertax] > path[start]+node.weight) {
               path[node.vertax] = path[start] + node.weight;
               que.add(new Node(node.vertax, (int)path[node.vertax]));
            }
         }
      }
      
      return path;
   }
}

class Node implements Comparable<Node>{
   int vertax;
   double weight;
   Node next;

   public Node(int vertax, int weight) {
      this.vertax = vertax;
      this.weight = weight;
      next = null;
   }

   @Override
   public int compareTo(Node node) {
         
      return (int)(weight-node.weight);
   }
}