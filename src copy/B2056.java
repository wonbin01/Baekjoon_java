import java.io.*;
import java.util.*;
public class B2056 
{
    static HashMap<Integer,ArrayList<Integer>>parent_child=new HashMap<>(); //부모 -> 자식 저장
    static int[] time; // 해당 작업하는데 걸리는 시간
    static int[] parent_count; //부모가 얼마나 있는지
    static int[] dp; // 해당 작업이 끝나는 시간을 저장
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //작업의 개수
        time=new int[n+1]; 
        parent_count=new int[n+1];
        dp=new int[n+1];
        for(int i=1;i<n+1;i++)
        {
            parent_child.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            time[i+1]=Integer.parseInt(input[0]); // 해당 작업에 걸리는 시간
            int k=Integer.parseInt(input[1]); // 선행관계에 있는 작업의 개수
            if(k!=0)
            {
                for(int j=2;j<k+2;j++)
                {
                    int c=Integer.parseInt(input[j]);
                    parent_child.get(c).add(i+1);
                    parent_count[i+1]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<n+1;i++)
        {
            if(parent_count[i]==0)
            {
                queue.add(i);
                dp[i]=time[i];
            }
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbor : parent_child.get(node))
            {
                parent_count[neighbor]--;
                dp[neighbor]=Math.max(dp[neighbor],time[neighbor]+dp[node]);
                if(parent_count[neighbor]==0)
                {
                    queue.add(neighbor);
                }
            }
        }
        int max=0;
        for(int finish : dp)
        {
            max=Math.max(max,finish);
        }
        System.out.println(max);
    }
}
