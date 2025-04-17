import java.io.*;
public class B1912 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n];
        int[] dp=new int[n];
        int max=-Integer.MAX_VALUE;
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            num[i]=Integer.parseInt(input[i]);
        }
        dp[0]=num[0];
        max=dp[0];
        if(n==1)
        {
            System.out.println(num[0]);
            return ;
        }
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1]+num[i],num[i]);
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
