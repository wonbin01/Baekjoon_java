import java.io.*;
import java.util.*;
public class B1927 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            int k=Integer.parseInt(br.readLine());
            if(k==0) //k가 0인 경우에는 가장 작은 값을 출력 후 제거
            {
                if(pq.isEmpty()) //비어있는 경우에는 0을 출력
                {
                    sb.append(0).append("\n");
                }
                else //비어있지 않은 경우에는 가장 작은 값을 출력 후 제거
                {
                    int value=pq.poll();
                    sb.append(value).append("\n");
                }
            }
            else
            {
                pq.add(k);
            }
        }
        System.out.print(sb);
    }
}
