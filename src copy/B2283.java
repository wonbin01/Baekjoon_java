import java.io.*;
import java.util.*;
public class B2283 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); // 구간의 개수
        int target=Integer.parseInt(input[1]); //길이의 총합
        int max=0;
        int[][] number=new int[n][2];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            number[i][0]=Integer.parseInt(input[0]);
            number[i][1]=Integer.parseInt(input[1]);
            max=Math.max(max,number[i][1]);
        }
        int start=0; int end=0;
        int[] find_gap=new int[max+1];
        Arrays.fill(find_gap,Integer.MAX_VALUE);
        while(end<max)
        {
            int result=0;
            for (int i = 0; i < n; i++) 
            {
                int temp1 = Math.max(start, number[i][0]);
                int temp2 = Math.min(end, number[i][1]);

                if (temp1 <= temp2) 
                {
                    result += (temp2 - temp1); //temp2가 더 큰 경우에만 더함
                }
            }
            int gap=end-start;
            if(result==target) find_gap[gap]=Math.min(find_gap[gap],start); //같은 경우에는 gap차이에 맞게 저장

            if(end<max) end++;
            else
            {
                start++;
                end=start+1;
            }
        }
        int gap=Integer.MAX_VALUE;
        int en=0;
        for(int i=0;i<=max;i++)
        {
            if(find_gap[i]!=Integer.MAX_VALUE)
            {
                gap=Math.min(gap,find_gap[i]);
                en=find_gap[i]+i;
            }
        }
        sb.append(gap).append(" ").append(en);
        System.out.println(sb);
    }
}
