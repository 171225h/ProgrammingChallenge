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

   // 1753��    2021.01.22.
   
   /*
    * ó���� �б� �������� ����� Ǯ������ �޸� �ʰ��� ����.
    * �� ������ adjacency matrix���� list�� ��µ� �ð��ʰ��� ����
    * ã�ƺ��� priority Queue�� ����ؼ� Ǫ�� ����� �־���.
    * 
    * ȥ�� �����ؼ� Ǯ����������� ������ �ȵż� ���� �ô� ^0^...
    * ���õ� �� �������
    */
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int vertax = Integer.parseInt(st.nextToken());
      int edge = Integer.parseInt(st.nextToken());
      
      int start = Integer.parseInt(br.readLine());
      
      // adjacency matrix�� ���� �޸��ʰ��� ����...
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
      
      // ���
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
    * start���� �� �� �ִ� ������ ���� ª�� �Ÿ��� �迭���·� return�մϴ�. 
    * @param start ���� vertax
    * @param graph �־��� vertax
    * @return      �ִܰŸ� path
    */
   private static double[] djikstra(int start, List<Node>[] graph) {
      /*
       * �Ϲ����� ���ͽ�Ʈ�� �˰����� ���� �ð��ʰ��� �����ϴ�
       * priority Queue�� ����ؼ� Ǯ���.
       */
      
      PriorityQueue<Node> que = new PriorityQueue<>();
      boolean[] visited = new boolean[graph.length];
      double[] path = new double[graph.length];
      
      que.add(new Node(start, 0));
      Arrays.fill(path, Double.POSITIVE_INFINITY);      //INF�� �ʱ�ȭ
      path[start] = 0;               
      
      while(!que.isEmpty()) {
         Node currentNode = que.poll();   // ���� ����� node�� edge�� �����´�
         start = currentNode.vertax;      // �� ���� ���� ���ϴ� node���� Ȯ��
         
         if(visited[start]) continue;   // �湮�� node��� ���� �� �ʿ� x
         
         visited[start] = true;         // �湮�ߴٰ� Ȯ�����ֱ�
         
         for(Node node : graph[start]) {
            // �� �κ��� �Ϲ� ���ͽ�Ʈ�� �˰���� ����!
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