import java.io.*;
import java.util.PriorityQueue;
public class B2170 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long length=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0])
            {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            int s1=Integer.parseInt(input[0]);
            int s2=Integer.parseInt(input[1]);
            pq.add(new int[] {s1,s2});
        }
        int pre=Integer.MIN_VALUE;
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int start=curr[0]; int end=curr[1];
            if(pre==Integer.MIN_VALUE)
            {
                length+=end-start;
                pre=end;
            }
            else
            {
                if(start>=pre)
                {
                    length+=end-start;
                    pre=end;
                }
                else if(start<pre && end>pre)
                {
                    length+=end-pre;
                    pre=end;
                }
                else if(end<=pre)
                {
                    continue;
                }
            }
        }
        System.out.println(length);
    }
}
