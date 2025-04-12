import java.io.*;
import java.util.*;
public class B1766
{
    static HashMap<Integer,ArrayList<Integer>> ParentToChild=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //문제의 수
        int m=Integer.parseInt(input[1]); //정보의 개수
        boolean[] visited=new boolean[n+1]; //출력의 정보를 저장
        int[] parent_count=new int[n+1]; //부모의 수를 저장
        for(int i=1;i<n+1;i++)
        {
            ParentToChild.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int A=Integer.parseInt(input[0]);
            int B=Integer.parseInt(input[1]); //A문제를 B보다 먼저 풀어야됨
            ParentToChild.get(A).add(B);
            parent_count[B]++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<=n;i++)
        {
            if(parent_count[i]==0)
            {
                pq.add(i);
            }
        }
        while(!pq.isEmpty())
        {
            int current=pq.poll();
            sb.append(current).append(" ");
            visited[current]=true;

            for(int childNode : ParentToChild.get(current))
            {
                parent_count[childNode]--;
                if(!visited[childNode] && parent_count[childNode]==0) //방문되지 않았고, childNode의 부모들을 모두 출력 한 경우
                {
                    pq.add(childNode);
                }
            }
        }
        System.out.println(sb);
    }
}