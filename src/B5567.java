import java.io.*;
import java.util.*;
public class B5567 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //동기의 수
        int m= Integer.parseInt(br.readLine()); //리스트의 길이
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();

        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            String[] input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]);
            int v2=Integer.parseInt(input[1]);
            hm.get(v1).add(v2); //친구들의 관계 입력
            hm.get(v2).add(v1);
        }
        bfs(hm,n);

    }
    static void bfs(HashMap<Integer,ArrayList<Integer>> hm, int n) //깊이가 2인 친구들까지만 카운트
    {
        Queue<int[]> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1]; //방문했는지 여부 확인
        queue.add(new int[] {1,0});
        visited[1]=true;
        int total=0;
        while(!queue.isEmpty())
        {
            int[] node=queue.poll();
            int id=node[0]; int depth=node[1]; //id는 학번, depth는 깊이
            for(int neighbor : hm.get(id))
            {
                if(!visited[neighbor]) //아직 방문되지않았다면
                {
                    visited[neighbor]=true;
                    if(depth<2)
                    {
                        total++;
                    }
                    queue.add(new int[] {neighbor,depth+1});
                }
            }
        }
        System.out.println(total);
    }
}
