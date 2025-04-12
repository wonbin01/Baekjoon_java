import java.io.*;
import java.util.*;
public class B1715 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int total=0;
        for(int i=0;i<n;i++)
        {
            pq.add(Integer.parseInt(br.readLine())); //숫자 입력받음
        }
        while(pq.size()>1)
        {
            int left=pq.poll();
            int right=pq.poll();
            int sum=left+right;
            total+=sum;
            pq.add(sum);
        }
        System.out.println(total);
    }
}
