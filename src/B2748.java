import java.io.*;
public class B2748 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dp=new long[n+1];
        dp[0]=0; dp[1]=1;
        if(n<=1)
        {
            System.out.println(dp[n]);
            return;
        }
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
