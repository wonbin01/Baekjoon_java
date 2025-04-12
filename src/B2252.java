import java.io.*;
import java.util.*;
public class B2252 
{
    static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
    static int[] parent_count;
    static StringBuilder sb=new StringBuilder();
    static boolean[] written;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //학생의 수
        int m=Integer.parseInt(input[1]); //키를 비교한 횟수
        parent_count=new int[n+1];
        written=new boolean[n+1];
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int front=Integer.parseInt(input[0]); //앞에 서야 하는 학생
            int back=Integer.parseInt(input[1]); //뒤에 서야 하는 학생
            hm.get(front).add(back);
            parent_count[back]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<n+1;i++)
        {
            if(parent_count[i]==0) //부모가 없는 경우
            {
                queue.add(i);
                sb.append(i).append(" "); //출력함함
                written[i]=true; //출력했는 지 여부를 저장장
            }
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int child : hm.get(node))
            {
                if(written[node]==true) //부모 노드가 출력된 경우
                {
                    parent_count[child]--;
                    if(parent_count[child]==0)
                    {
                        sb.append(child).append(" ");
                        written[child]=true;
                        queue.add(child);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
//답이 여러가지 인경우에는 아무거나 출력 -> 번호순대로 출력하자자