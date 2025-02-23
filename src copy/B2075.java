import java.io.*;
import java.util.*;
public class B2075 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                pq.add(Integer.parseInt(input[j]));
            }
        }
        int target=0;
        for(int i=0;i<n;i++)
        {
            target=pq.poll();
        }
        System.out.println(target);
    }
}
