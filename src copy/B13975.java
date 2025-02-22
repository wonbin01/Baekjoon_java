import java.io.*;
import java.util.*;
public class B13975 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); //테스트 케이스
        for(int i=0;i<t;i++)
        {
            int k=Integer.parseInt(br.readLine()); //소설을 구성하는 장의 수
            String[] input=br.readLine().split(" ");
            PriorityQueue<Long> pq=new PriorityQueue<>();
            for(int j=0;j<k;j++)
            {
                pq.add(Long.parseLong(input[j]));
            }
            long totalCost=0;
            while(pq.size()>1)
            {
                long left=pq.poll();
                long right=pq.poll();
                long sum=left+right;
                totalCost+=sum;
                pq.add(sum);
            }
            System.out.println(totalCost);
        }
    }
}
