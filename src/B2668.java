import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class B2668 
{
    static HashMap<Integer,Integer> hm=new HashMap<>();
    static boolean[] finished;
    static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); //첫줄의 개수
        for(int i=0;i<n;i++)
        {
            int num=Integer.parseInt(br.readLine());
            hm.put(i+1,num);
        }
        finished=new boolean[n+1];
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            boolean[] visited=new boolean[n+1];
            if(!finished[i]) dfs(i,i,visited);
        }
        for(int i=1;i<=n;i++)
        {
            if(finished[i]) al.add(i);
        }
        StringBuilder sb=new StringBuilder();
        Collections.sort(al);
        sb.append(al.size()).append("\n");
        for(int x : al) sb.append(x).append("\n");
        System.out.println(sb);
    }
    static void dfs(int start,int cur,boolean[] visited)
    {
        visited[cur]=true;
        int next=hm.get(cur);
        if(!visited[next])
        {
            dfs(start, next, visited);
        }
        else
        {
            if(next==start)
            {
                for(int i=1;i<=n;i++)
                {
                    if(visited[i]) finished[i]=true;
                }
            }
        }
    }
}
