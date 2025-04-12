import java.io.*;
import java.util.*;
public class B1005 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); //테스트 케이스의 개수
        for(int i=0;i<t;i++)
        {
            HashMap<Integer,ArrayList<Integer>> child=new HashMap<>(); //자식의 정보를 담음음
            String[] input=br.readLine().split(" ");
            int n=Integer.parseInt(input[0]); //건물의 개수
            int k=Integer.parseInt(input[1]); //건설순서 규칙의 총 개수
            int[] timer=new int[n+1]; //건설에 걸리는 시간
            int[] inDegree=new int[n+1]; //각 노드의 부모 노드의 수수
            for(int j=1;j<n+1;j++)
            {
                child.put(j,new ArrayList<>());
            }
            input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                timer[j+1]=Integer.parseInt(input[j]);
            }
            for(int j=0;j<k;j++)
            {
                input=br.readLine().split(" ");
                int x=Integer.parseInt(input[0]);
                int y=Integer.parseInt(input[1]); //x를 다 지은 다음에 y를 짓는 것이 가능함
                child.get(x).add(y); //방향성 있는 그래프를 만듦
                inDegree[y]++; //y의 부모 노드의 수 증가
            }
            int w=Integer.parseInt(br.readLine()); // 승리하기 위해 건설해야되는 건물의 번호
            System.out.println(find_min_time(child, timer, w, inDegree));
        }
    }
    static int find_min_time(HashMap<Integer,ArrayList<Integer>> child,int[] timer,int target,int[] inDegree)
    {
        int[] dp=new int[timer.length]; //각 노드까지의 최소 시간을 저장
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<timer.length;i++)
        {
            if(inDegree[i]==0) //부모 노드가 없다면면
            {
                queue.add(i);
                dp[i]=timer[i];
            }
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int c : child.get(node))
            {
                dp[c]=Math.max(dp[c],dp[node]+timer[c]);
                inDegree[c]--;
                if(inDegree[c]==0)
                {
                    queue.add(c);
                }
            }
        }
        return dp[target];
    }
}
