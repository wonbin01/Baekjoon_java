import java.io.*;
public class B2156 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] podo=new int[n];
        for(int i=0;i<n;i++)
        {
            podo[i]=Integer.parseInt(br.readLine());
        }
        int[][] dp=new int[n][3];
        dp[0][0]=0;
        dp[0][1]=podo[0]; //0번째 포도주일때, 최대 포도주
        dp[0][2]=0;
        if(n==1)
        {
            System.out.println(dp[0][1]);
            return;
        }
        dp[1][0]=Math.max(dp[0][0],Math.max(dp[0][1],dp[0][2]));
        dp[1][1]=dp[0][0]+podo[1];
        dp[1][2]=dp[0][1]+podo[1];
        for(int i=2;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
            dp[i][1]=dp[i-1][0]+podo[i];
            dp[i][2]=dp[i-1][1]+podo[i];
        }
        int result=Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
        System.out.println(result);
    }
}
