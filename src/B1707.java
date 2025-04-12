import java.io.*;
import java.util.*;
public class B1707 
{
    static int[] visited;
    static boolean isbipartite;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine()); //테스트 케이스의 개수
        String[] input;
        for(int i=0;i<k;i++)
        {
            input=br.readLine().split(" ");
            int v=Integer.parseInt(input[0]); // 정점의 개수
            int e=Integer.parseInt(input[1]); //간선의 개수
            HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>(); //hm에 정점과 연결된 정점을 저장
            for(int p=1;p<v+1;p++)
            {
                hm.put(p,new ArrayList<>());
            }
            for(int j=0;j<e;j++) //간선의 개수 e
            {
                input=br.readLine().split(" ");
                int v1=Integer.parseInt(input[0]); //정점
                int v2=Integer.parseInt(input[1]); //정점
                hm.get(v1).add(v2);
                hm.get(v2).add(v1);
            }
            visited=new int[v+1];
            isbipartite=true;
            for(int j=1;j<=v;j++)
            {
                if(visited[j]==0)
                {
                    if(!bfs(j,hm,v))
                    {
                        isbipartite=false;
                        break;
                    }
                }
            }
            System.out.println(isbipartite ? "YES" : "NO");
        }

    }
    public static boolean bfs(int start,HashMap<Integer,ArrayList<Integer>> hm,int v)
    {
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=1;
        queue.add(start);
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            int currentcolor=visited[node];
            for(int neighbor : hm.get(node))
            {
                if(visited[neighbor]==0)
                {
                    visited[neighbor]=(currentcolor==1) ? 2:1;
                    queue.add(neighbor);
                }
                else if(visited[neighbor]==currentcolor)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
