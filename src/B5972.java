import java.io.*;
import java.util.*;
public class B5972 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //n개의 헛간
        int m=Integer.parseInt(input[1]); //m개의 양방향 길
        HashMap<Integer,ArrayList<int[]>> hm=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int a1=Integer.parseInt(input[0]); //헛간의 위치
            int b1=Integer.parseInt(input[1]); //헛간의 위치
            int pay=Integer.parseInt(input[2]); //헛간 사이의 보상
            hm.putIfAbsent(a1, new ArrayList<>());
            hm.putIfAbsent(b1,new ArrayList<>());
            hm.get(a1).add(new int[] {b1,pay});
            hm.get(b1).add(new int[] {a1,pay});
        }
        int[] visited=new int[n+1];
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        Arrays.fill(visited,Integer.MAX_VALUE);
        visited[1]=0;
        queue.add(new int[] {1,0}); //현재 위치와 현재까지의 비용
        while(!queue.isEmpty())
        {
            int[] cur=queue.poll();
            int current_position=cur[0];
            int current_pay=cur[1];
            if(current_pay>visited[current_position]) continue;
            if(!hm.containsKey(current_position)) continue;
            for(int[] nx : hm.get(current_position))
            {
                int next=nx[0];
                int next_pay=nx[1];
                if(visited[next] > current_pay+next_pay)
                {
                    visited[next]=current_pay+next_pay;
                    queue.add(new int[] {next,visited[next]});
                }
            }
        }
        System.out.println(visited[n]);
    }
}
