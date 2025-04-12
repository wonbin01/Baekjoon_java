import java.io.*;
import java.util.*;
public class B2637 
{
    static HashMap<Integer,HashMap<Integer,Integer>> hm=new HashMap<>(); //상관관계를 저장
    static HashMap<Integer,HashMap<Integer,Integer>> part_count=new HashMap<>(); // 노드들에서 부품의 개수 저장
    static int[] indegree; //부모의 개수를 저장
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //자연수 n (1~N-1까지는 기본 부품이나 중간 부품의 번호), N이 완제품
        int m=Integer.parseInt(br.readLine()); //부품을 완성하는데 필요한 부품들간의 관계
        indegree=new int[n+1];
        for(int i=1;i<n+1;i++)
        {
            hm.put(i,new HashMap<>());
            part_count.put(i,new HashMap<>());
        }
        for(int i=0;i<m;i++)
        {
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]); //x를 만드는데
            int y=Integer.parseInt(input[1]); //부품 y가
            int k=Integer.parseInt(input[2]); //k개 필요함
            hm.get(y).putIfAbsent(x, k);
            indegree[x]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<n+1;i++)
        {
            if(indegree[i]==0) //기본 부품이라면
            {
                queue.add(i);
                part_count.get(i).put(i,1); //기본 부품들 parts 하나씩 넣음
            }
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int child : hm.get(node).keySet())
            {
                indegree[child]--;
                for(int part : part_count.get(node).keySet())
                {
                    int required=hm.get(node).get(child) * part_count.get(node).get(part) + part_count.get(child).getOrDefault(part, 0);
                    part_count.get(child).put(part,required);
                }
                if(indegree[child]==0)
                {
                    queue.add(child);
                }
            }
        } //완제품 : n
        List<Integer> sortedKeys=new ArrayList<>(part_count.get(n).keySet());
        Collections.sort(sortedKeys);
        for(int key : sortedKeys)
        {
            sb.append(key).append(" ").append(part_count.get(n).get(key)).append("\n");
        }
        System.out.print(sb);
    }
}
