import java.io.*;
import java.util.*;
public class B2623 
{
   static StringBuilder sb=new StringBuilder();
   static HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
   static int[] parent;
   static boolean[] visited;
   public static void main(String[] args) throws IOException
   {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String[] input=br.readLine().split(" ");
      int n=Integer.parseInt(input[0]); //가수의 수
      int m=Integer.parseInt(input[1]); //보조 pd의 수
      parent=new int[n+1]; //직계 부모의 수를 저장하도록
      visited=new boolean[n+1]; //출력된지 확인함
      for(int i=1;i<n+1;i++)
      {
         hm.put(i,new ArrayList<>());
      }
      for(int i=0;i<m;i++)
      {
         input=br.readLine().split(" ");
         int k=Integer.parseInt(input[0]); //각 pd의 출연가수의 수
         int[] singer=new int[k+1]; //가수의 순서대로 저장
         for(int j=1;j<k+1;j++)
         {
            singer[j]=Integer.parseInt(input[j]);
         }
         for(int j=1;j<k;j++)
         {
            if(!hm.get(singer[j]).contains(singer[j+1])) //포함하고 있지 않은 경우
            {
               hm.get(singer[j]).add(singer[j+1]); //자식 추가
               parent[singer[j+1]]++;  //부모를 추가
            }
         }
      }
      Queue<Integer> queue=new LinkedList<>();
      for(int i=1;i<n+1;i++)
      {
         if(parent[i]==0) //부모가 없는 경우
         {
            queue.add(i);
            sb.append(i).append("\n"); // 부모가 없으니까 출력
            visited[i]=true; //출력 표시
         }
      }

      int processedNodes=0; //처리된 노드의 수
      while(!queue.isEmpty()) //queue가 비어있지 않은 경우
      {
         int node=queue.poll();
         processedNodes++;
         for(int child : hm.get(node))
         {
            parent[child]--;
            if(parent[child]==0 && !visited[child]) //부모가 모두 출력된 경우 + 아직 출력되지 않은 경우
            {
               queue.add(child);
               sb.append(child).append("\n");
               visited[child]=true;
            }
         }
      }
      if(processedNodes==n)
      {
         System.out.print(sb);
      }
      else
      {
         System.out.println(0);
      }
      //순서를 정할 수 없는 경우에는 0을 출력 -> 사이클이 존재하는 경우
   }
}
