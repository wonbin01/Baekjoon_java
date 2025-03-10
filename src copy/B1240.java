import java.io.*;
import java.util.*;
public class B1240 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //노드의 개수
        int m=Integer.parseInt(input[1]); //거리를 알고 싶은 노드의 쌍
        HashMap<Integer,HashMap<Integer,Integer>> hm=new HashMap<>();
        for(int i=0;i<n-1;i++)
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]); //두 정점
            int v2=Integer.parseInt(input[1]); // 두 정점
            int distance=Integer.parseInt(input[2]);// 두 정점 사이의 거리
            hm.putIfAbsent(v1, new HashMap<>());
            hm.putIfAbsent(v2, new HashMap<>());
            hm.get(v2).put(v1,distance);
            hm.get(v1).put(v2,distance);
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int target_1=Integer.parseInt(input[0]);
            int target_2=Integer.parseInt(input[1]);
            bfs(hm,n,target_1,target_2);
        }
    }
    static void bfs(HashMap<Integer,HashMap<Integer,Integer>> hm,int n,int start,int end)
    {
        Queue<int[]> queue=new LinkedList<>(); //노드와 시작 노드로부터의 거리를 저장
        boolean[] visited=new boolean[n+1]; //방문 여부를 저장
        visited[start]=true; //시작 부분은 방문 처리
        queue.add(new int[] {start,0});
        while(!queue.isEmpty())
        {
            int[] info=queue.poll();
            int node=info[0]; int distance=info[1]; //node는 정점, distance는 시작부분으로부터의 거리
            if(node==end)
            {
                System.out.println(distance);
                break;
            }
            for(int neighbor : hm.get(node).keySet())
            {
                if(!visited[neighbor]) //아직 방문되지 않은 상태라면
                {
                    visited[neighbor]=true; //방문 처리
                    queue.add(new int[] {neighbor,distance+hm.get(node).get(neighbor)});
                }
            }
        }
    }
}
