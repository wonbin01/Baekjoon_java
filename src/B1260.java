import java.io.*;
import java.util.*;
public class B1260 
{
    static StringBuilder sb_dfs=new StringBuilder();
    static StringBuilder sb_bfs=new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //정점의 개수
        int m=Integer.parseInt(input[1]); //간선의 개수    
        int v=Integer.parseInt(input[2]); //탐색을 시작하는 번호
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++) //정점과 간선들이 연결된 정보를 저장함
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]); 
            int v2=Integer.parseInt(input[1]);
            hm.get(v1).add(v2);
            hm.get(v2).add(v1);
        }
        boolean[] dfs_visited=new boolean[n+1];
        boolean[] bfs_visited=new boolean[n+1];
        dfs(v,hm,dfs_visited);
        bfs(v,hm,bfs_visited);
        System.out.print(sb_dfs);
        System.out.println(sb_bfs);
    }
    public static void dfs(int start,HashMap<Integer,ArrayList<Integer>> hm,boolean[] dfs_visited)
    {
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        while(!stack.isEmpty())
        {
            int node=stack.pop();
            if(!dfs_visited[node])
            {
                dfs_visited[node]=true;
                sb_dfs.append(node).append(" ");
            }
            List<Integer> neighbors=hm.get(node);
            Collections.sort(neighbors,Collections.reverseOrder()); //번호가 작은순서대로 방문
            for(int neighbor : neighbors)
            {
                if(!dfs_visited[neighbor])
                {
                    stack.push(neighbor);
                }
            }
        }
        sb_dfs.append("\n");
    }
    public static void bfs(int start,HashMap<Integer,ArrayList<Integer>> hm,boolean[] bfs_visited)
    {
        //queue 사용
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            if(!bfs_visited[node])
            {
                bfs_visited[node]=true;
                sb_dfs.append(node).append(" ");
            }
            List<Integer> neighbors=hm.get(node);
            Collections.sort(neighbors);
            for(int neighbor : neighbors)
            {
                if(!bfs_visited[neighbor])
                {
                    queue.add(neighbor);
                }
            }
        }
    }
}
