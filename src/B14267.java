import java.io.*;
import java.util.*;
public class B14267 
{
    static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
    static int[] compliment; //직원들의 칭찬의 정도를 저장
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //회사의 직원 수
        compliment=new int[n+1];
        int m=Integer.parseInt(input[1]); // 최초의 칭찬 횟수
        input=br.readLine().split(" ");
        int root=0;
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            if(Integer.parseInt(input[i])==-1)
            {
                root=i+1;
                continue;
            }
            int senior=Integer.parseInt(input[i]); //직속 상사의 번호
            hm.get(senior).add(i+1);
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int member=Integer.parseInt(input[0]); //칭찬받은 직원 번호
            int magnitude=Integer.parseInt(input[1]); // 칭찬의 수치
            compliment[member]+=magnitude;
        }
        bfs(root);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<n+1;i++)
        {
            sb.append(compliment[i]).append(" ");
        }
        System.out.println(sb);
    }
    static void bfs(int root)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbor : hm.get(node))
            {
                compliment[neighbor]+=compliment[node];
                queue.add(neighbor);
            }
        }
    }   
}
