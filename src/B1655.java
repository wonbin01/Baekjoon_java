import java.io.*;
import java.util.*;
public class B1655 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine()); //말하는 수의 개수
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder()); //중간값 이하의 숫자들을 저장
        PriorityQueue<Integer> min=new PriorityQueue<>(); //중간값 이상의 숫자들을 저장
        for(int i=0;i<n;i++)
        {
            int num=Integer.parseInt(br.readLine());
            if(max.size()==min.size()) max.offer(num);
            else min.offer(num);

            if(!min.isEmpty() && max.peek()>min.peek())
            {
                int maxtop=max.poll();
                int mintop=min.poll();
                max.offer(mintop);
                min.offer(maxtop);
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.print(sb);
    }
}
