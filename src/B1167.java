import java.io.*;
import java.util.*;
public class B1167 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int v=Integer.parseInt(br.readLine()); //정점의 개수
        Map<Integer,HashMap<Integer,Integer>> map=new HashMap<>(); //weight도도 저장
        for(int i=0;i<v;i++)
        {
            String[] input=br.readLine().split(" ");
            int head=Integer.parseInt(input[0]);
            int index=1; //현재 인덱스 저장
            while(true)
            {
                int node=Integer.parseInt(input[index]);
                if(node==-1)
                {
                    break;
                }
                else //-1이 아닌경우
                {
                    index++;
                    int weight=Integer.parseInt(input[index]);
                    map.putIfAbsent(head, new HashMap<>());
                    map.putIfAbsent(node, new HashMap<>());
                    map.get(head).put(node,weight);
                    map.get(node).put(head,weight);
                    index++;
                }
            }
        }
        // 첫번 째 bfs : 가장 먼 정점을 찾음
        int[] firstBfsResult=bfs(map,v,1);
        int farthestNode=firstBfsResult[0];
        //두 번째 bfs
        int[] secondBfsResult=bfs(map,v,farthestNode);
        int treeDiameter=secondBfsResult[1];
        System.out.println(treeDiameter);
    }

    static int[] bfs(Map<Integer,HashMap<Integer,Integer>> map, int v,int start)
    {
        Queue<int[]> queue=new LinkedList<>();
        boolean[] visited=new boolean[v+1]; //방문했는 지 여부 확인
        visited[start]=true;
        int maxdistance=0;
        int farthestNode=start;
        queue.add(new int[]{start,0}); // queue에 집어넣음
        while(!queue.isEmpty())
        {
            int[] pop=queue.poll();
            int node=pop[0]; int distance=pop[1]; //햔재 노드와 거리를 기록
            if(distance > maxdistance)
            {
                maxdistance=distance;
                farthestNode=node;
            }
            for(int neighbor : map.get(node).keySet())
            {
                if(!visited[neighbor]) //아직 방문되지 않은 경우
                {
                    visited[neighbor]=true; //방문처리
                    queue.add(new int[]{neighbor,distance+map.get(node).get(neighbor)});
                }
            }
        }
        return new int[] {farthestNode,maxdistance};
    }
}
