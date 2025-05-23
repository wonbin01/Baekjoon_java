import java.io.*;
public class B2240 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int t=Integer.parseInt(input[0]);
        int w=Integer.parseInt(input[1]);
        int[] jadu=new int[t+1];
        for(int i=1;i<=t;i++)
            jadu[i]=Integer.parseInt(br.readLine());

        int[][] dp=new int[t+1][w+1];
        for(int i=1;i<=t;i++) 
        {
            for(int j=0;j<=w;j++) 
            {
                // 현재 위치: j%2==0이면 1번, 1이면 2번
                int nowTree = (j%2==0) ? 1 : 2;
                if(j==0) {
                    dp[i][j] = dp[i-1][j] + (jadu[i]==nowTree ? 1 : 0);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + (jadu[i]==nowTree ? 1 : 0);
                }
            }
        }
        int max=0;
        for(int j=0;j<=w;j++)
            max=Math.max(max, dp[t][j]);
        System.out.println(max);
    }
}