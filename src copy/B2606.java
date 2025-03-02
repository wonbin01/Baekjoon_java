import java.io.*;
import java.util.*;
public class B2606 
{
    static HashMap<Integer,ArrayList<Integer>> hm;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //컴퓨터의 수
        int couple=Integer.parseInt(br.readLine()); //연결된 컴퓨터의 쌍 저장
        hm=new HashMap<>();
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<couple;i++)
        {
            String[] input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]);
            int v2=Integer.parseInt(input[1]);
            hm.get(v1).add(v2);
            hm.get(v2).add(v1);
        }
        bfs(n);
    }
    public static void bfs(int n)
    {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        visited[1]=true;
        int count=0;
        queue.add(1);
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbor : hm.get(node))
            {
                if(!visited[neighbor]) //방문되지 않았다면
                {
                    queue.add(neighbor);
                    visited[neighbor]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
