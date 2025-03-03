import java.io.*;
import java.util.*;
public class B2617 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,ArrayList<Integer>> big=new HashMap<>(); // 구슬의 무게 중 큰 거를 가리킴
        HashMap<Integer,ArrayList<Integer>> small=new HashMap<>(); //구슬의 무게 중 작은 거를 가리킴
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //구슬의 개수
        int m=Integer.parseInt(input[1]); //실험 결과의 회수
        int middle=n/2+1;
        int result=0;
        for(int i=1;i<n+1;i++)
        {
            big.put(i,new ArrayList<>());
            small.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int v1=Integer.parseInt(input[0]); //구슬의 무게가 큰거
            int v2=Integer.parseInt(input[1]); //구슬의 무게가 작은거
            big.get(v1).add(v2);
            small.get(v2).add(v1);
        }
        for(int i=1;i<n+1;i++)
        {
            int big_count=bfs(i,big);
            int small_count=bfs(i,small);
            if(big_count>=middle || small_count>=middle)
            {
                result++;
            }
        }
        System.out.println(result);
    }
    public static int bfs(int start,HashMap<Integer,ArrayList<Integer>> hm) //count>=middle이면 성립
    {
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        queue.add(start);
        visited.add(start);
        int count=0;
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(Integer neighbor : hm.get(node))
            {
                    if(!visited.contains(neighbor)) ///같은 곳을 여러번 방문할 수 있으므로 visited로 확인필요
                    {
                        visited.add(neighbor);
                        queue.add(neighbor);
                        count++;
                    }
            }
        }
        return count;
    }
}
