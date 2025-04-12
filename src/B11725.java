import java.io.*;
import java.util.*;
public class B11725 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //노드의 개수
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)
        {
            String[] input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]);
            int v2=Integer.parseInt(input[1]);
            hm.get(v1).add(v2); //두 정점을 이어주는 과정
            hm.get(v2).add(v1);
        }
        bfs(hm,n);
        System.out.print(sb);
    }
    static void bfs(HashMap<Integer,ArrayList<Integer>> hm,int n)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        boolean[] visited=new boolean[n+1]; //방문했는지 여부를 확인하는 배열
        visited[1]=true;
        int[] parent=new int[n+1]; //부모 노드를 저장하는 배열
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbor : hm.get(node))
            {
                if(!visited[neighbor]) //아직 방문하지 않은 노드라면
                {
                    visited[neighbor]=true;
                    queue.add(neighbor);
                    parent[neighbor]=node;
                }
            }
        }
        for(int i=2;i<n+1;i++)
        {
            sb.append(parent[i]).append("\n");
        }
    }
}
