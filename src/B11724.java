import java.io.*;
import java.util.*;
public class B11724 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //정점의 개수
        int m=Integer.parseInt(input[1]); //간선의 개수
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>(); //연결된 요소들을 저장하는 공간
        for(int i=1;i<=n;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int key1=Integer.parseInt(input[0]);
            int key2=Integer.parseInt(input[1]);
            hm.get(key1).add(key2); //연결된 요소 저장
            hm.get(key2).add(key1); //연결되 요소 저장
        }
        boolean[] visited=new boolean[n+1]; //연결된 요소를 세기 위한 dfs
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,hm,visited);
            }
        }
        System.out.println(count);

    }
    public static void dfs(int node,HashMap<Integer,ArrayList<Integer>> hm, boolean[] visited)
    {
        visited[node]= true;
        for(int neighbor : hm.get(node))
        {
            if(!visited[neighbor])
            {
                dfs(neighbor,hm,visited);
            }
        }
    }
}
