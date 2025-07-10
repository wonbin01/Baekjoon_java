import java.io.*;
import java.util.*;
class B15903
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //카드의 개수
        int m=Integer.parseInt(input[1]); //합체 수
        input=br.readLine().split(" ");
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            pq.add(Long.parseLong(input[i]));
        }
        for(int i=0;i<m;i++)
        {
            Long num1=pq.poll();
            Long num2=pq.poll();
            Long new_card=num1+num2;
            pq.add(new_card); pq.add(new_card);
        }
        long result=0;
        for(Long num : pq)
        {
            result+=num;
        }
        System.out.println(result);
    }
}