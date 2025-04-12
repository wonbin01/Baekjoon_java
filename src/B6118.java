import java.io.*;
import java.util.*;
public class B6118 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //헛간의 개수
        int m=Integer.parseInt(input[1]); //양방향 길
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++) //각 헛간끼리 연결된 부분을 저장
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]);
            int v2=Integer.parseInt(input[1]);
            hm.get(v1).add(v2);
            hm.get(v2).add(v1);
        }
        bfs(hm,n);
    }
    static void bfs(HashMap<Integer,ArrayList<Integer>> hm,int n)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {1,0});
        int[] visited=new int[n+1]; //방문 여부를 확인하는 배열
        visited[1]=-1;
        while(!queue.isEmpty())
        {
            int[] node=queue.poll();
            int house=node[0]; int distance=node[1]; //house는 헛간, distance는 출발지부터의 거리
            for(int neighbor: hm.get(house))
            {
                if(visited[neighbor]==0) //방문되지 않은 상태라면
                {
                    visited[neighbor]=distance+1; //방문처리
                    queue.add(new int[] {neighbor,distance+1});
                }
            }
        }
        int max=0; //최대거리
        int max_house=0; //최대거리 헛간
        int count=0; //최대거리헛간이 몇개인지

        for(int i=2;i<n+1;i++)
        {
            max=Integer.max(max,visited[i]); //최대거리를 확인가능
        }
        for(int i=2;i<n+1;i++)
        {
            if(max==visited[i])
            {
                max_house=i;
                break; //가장 작은거 출력해야하므로
            }
        }
        for(int i=2;i<n+1;i++)
        {
            if(max==visited[i])
            {
                count++;
            }
        }
        System.out.print(max_house+" "+max+" "+count);
    }
}
