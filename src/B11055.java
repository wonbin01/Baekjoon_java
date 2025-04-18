import java.io.*;
public class B11055 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n]; //수를 저장하는 배열
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            num[i]=Integer.parseInt(input[i]);
        }
        long[] dp=new long[n];
        dp[0]=num[0];
        if(n==1)
        {
            System.out.println(dp[0]);
            return;
        }
        for(int i=1;i<n;i++)
        {
            dp[i]=num[i];
            for(int j=0;j<i;j++)
            {
                if(num[j]<num[i])
                {
                    dp[i]=Math.max(dp[i],dp[j]+num[i]);
                }
            }
        }
        long max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
