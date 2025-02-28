import java.io.*;
import java.util.*;
public class B1389 
{
    static TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hm=new HashMap<>();
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //유저의 수
        int m=Integer.parseInt(input[1]); //친구 관계의 수
        for(int i=1;i<n+1;i++)
        {
            tm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]); 
            int v2=Integer.parseInt(input[1]);
            tm.get(v1).add(v2);
            tm.get(v2).add(v1);
        }
        for(int i=1;i<n+1;i++)
        {
            Collections.sort(tm.get(i));
            hm.put(i,bfs(i,n));
        }
        int minBacon=Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++)
        {
            minBacon=Math.min(minBacon,hm.get(i));
        }
        for(int i=1;i<n+1;i++)
        {
            if(hm.get(i)==minBacon)
            {
                System.out.println(i);
                return;
            }
        }
    }
    static int bfs(int start,int n)
    {
        Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[n+1];
        boolean[] check=new boolean[n+1];
        int total=0; //다른노드까지의 총 거리 저장
        check[start]=true;
        q.add(start);
        while(!q.isEmpty())
        {
            int node=q.poll();
            int count=visited[node]; //해당 노드까지의 거리 저장
            for (int neighbor : tm.get(node)) 
            {
                if (!check[neighbor]) //아직 방문되지 않은 상태라면
                {
                    visited[neighbor] = count+1; //방문처리해야됨
                    check[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            if(i!=start)
            {
                total+=visited[i];
            }
        }
        return total;
    }
}
