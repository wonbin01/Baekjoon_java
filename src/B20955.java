import java.io.*;
import java.util.*;
public class B20955 
{
    static HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //뉴런의 개수
        int m=Integer.parseInt(input[1]); //시냅스의 개수
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int u=Integer.parseInt(input[0]); //두 뉴런의 번호
            int v=Integer.parseInt(input[1]); //두 뉴런의 번호
            hm.get(u).add(v);
            hm.get(v).add(u); //두 뉴런을 연결해줌
        }
        visited=new boolean[n+1];
        int group_cnt=0;
        for(int i=1;i<n+1;i++)
        {
            if(!visited[i]) //방문되지 않았다면 실행
            {
                group_cnt++;
                visited[i]=true; //시작부분 방문처리
                find_groupcnt(i, n);
            }
        }
        int cal=2*group_cnt-1+m-n;
        System.out.println(cal);

    }
    static void find_groupcnt(int start,int n)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbor : hm.get(node))
            {
                if(!visited[neighbor]) //방문되지 않았다면
                {
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
// (덩어리-1) + (덩어리-1+m)-n+1
        //2덩어리-1+m-n