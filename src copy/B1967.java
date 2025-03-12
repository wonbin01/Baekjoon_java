import java.io.*;
import java.util.*;
public class B1967 
{
    static HashMap<Integer,HashMap<Integer,Integer>>hm;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input;
        hm=new HashMap<>();
        for(int i=1;i<n+1;i++)
        {
            hm.putIfAbsent(i, new HashMap<>());
        }
        for(int i=0;i<n-1;i++)
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]); //부모 정점
            int v2=Integer.parseInt(input[1]); //자식 정점
            int weight=Integer.parseInt(input[2]); //간선의 가중치
            hm.get(v1).putIfAbsent(v2,weight);
            hm.get(v2).putIfAbsent(v1,weight);
        }

        int[] target1=bfs(n,1); //처음에 루트로부터 가장 먼 노드를 찾음
        int node=target1[0];

        int[] target2=bfs(n,node); //두번째에 트리의 지름을 구함
        int max_distance=target2[1];
        System.out.println(max_distance);
    }
    public static int[] bfs(int n,int start)
    {
        Queue<int[]> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1]; //방문 여부를 저장
        int max=0; //최대 크기를 저장하는 변수
        int target=-1;
        visited[start]=true;
        queue.add(new int[] {start,0});
        while(!queue.isEmpty())
        {
            int[] node=queue.poll();
            int v=node[0]; int distance=node[1]; //v는 정점, distance는 출발점부터의 거리
            if(max<=distance)
            {
                target=v;
                max=distance;
            }
            for(int neighbor : hm.get(v).keySet())
            {
                if(!visited[neighbor])
                {
                    visited[neighbor]=true;
                    queue.add(new int[] {neighbor,distance+hm.get(v).get(neighbor)});
                }
            }
        }
        int[] clue=new int[] {target,max};
        return clue;
    }
}
