import java.io.*;
import java.util.*;
public class B1368 
{
    static int[] dig_cost;
    static int[][] link_cost;
    static boolean[] visited;
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //논의 개수
        dig_cost=new int[n+1]; //우물 파는 데 드는 비용
        link_cost=new int[n+1][n+1]; // 연결하는데 드는 비용
        visited=new boolean[n+1]; //방문되었는지 여부 확인 (사이클 x)
        for(int i=1;i<n+1;i++)
        {
            dig_cost[i]=Integer.parseInt(br.readLine()); //우물을 팔 때 드는 비용
        }
        for(int i=1;i<n+1;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                link_cost[i][j+1]=Integer.parseInt(input[j]);
            }
        }
        System.out.println(find_weight(n));
    }
    static int find_weight(int n)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]); //비용기준 오름차순
        for(int i=1;i<n+1;i++)
        {
            pq.add(new int[] {i,dig_cost[i]}); //논 번호, 우물 파는 비용
        }
        int connected=0;
        int totalWeight=0;
        while(!pq.isEmpty() && connected<n)
        {
            int[] current=pq.poll();
            int node=current[0]; //논 번호
            int cost=current[1]; // 우물 파는 비용
            if(visited[node]) continue; //이미 연결된 논은 무시함
            visited[node]=true;
            totalWeight+=cost;
            connected++;

            for(int i=1;i<n+1;i++)
            {
                if(!visited[i])
                {
                    pq.add(new int[] {i,link_cost[node][i]});
                }
            }
        }
        return totalWeight;
    }
}
