import java.io.*;
import java.util.*;
public class B2660 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //회원의 수
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>(); //회원들의 친구 관계를 저장
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        while(true)
        {
            String[] in=br.readLine().split(" ");
            int v1=Integer.parseInt(in[0]); // 친구관계 입력
            int v2=Integer.parseInt(in[1]); //친구관계 입력
            if(v1==-1 && v2==-1)
            {
                break;
            }
            hm.get(v1).add(v2);
            hm.get(v2).add(v1); //각각 친구관계 입력함
        }
        int[] depth=new int[n+1];
        int min_score=Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++)
        {
            depth[i]=bfs(i,hm,n);
        }
        ArrayList<Integer> candidate=new ArrayList<>();
        for(int i=1;i<n+1;i++)
        {
            min_score=Math.min(min_score,depth[i]);
        }
        for(int i=1;i<n+1;i++)
        {
            if(depth[i]==min_score)
            {
                candidate.add(i);
            }
        }
        Collections.sort(candidate);
        System.out.println(min_score+" "+ candidate.size());
        for(int can : candidate)
        {
            System.out.print(can + " ");
        }
    }
    static int bfs(int start,HashMap<Integer,ArrayList<Integer>> hm,int n)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{start,0});
        boolean[] visited=new boolean[n+1];
        visited[start]=true;
        int maxdepth=0;
        while(!queue.isEmpty())
        {
            int[] data=queue.poll();
            int node=data[0];
            int depth=data[1];
            
            maxdepth=Math.max(maxdepth,depth);

            for(int neighbor:hm.get(node))
            {
                if(!visited[neighbor])
                {
                    visited[neighbor]=true;
                    queue.add(new int[]{neighbor,depth+1});
                }
            }
        }
        return maxdepth;
    }
}
