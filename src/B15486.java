import java.io.*;

public class B15486 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] company=new int[n+1][2];
        int[] dp=new int[n+2]; // n+2로 넉넉하게 선언 (index overflow 방지)

        for(int i=1;i<=n;i++) 
        {
            String[] input=br.readLine().split(" ");
            company[i][0]=Integer.parseInt(input[0]);
            company[i][1]=Integer.parseInt(input[1]);
        }

        for(int i=1;i<=n;i++) 
        {
            dp[i] = Math.max(dp[i], dp[i-1]); // 이전까지의 최대값 유지

            int end = i + company[i][0];
            if(end <= n+1) 
            {
                dp[end]=Math.max(dp[end],dp[i]+company[i][1]);
            }
        }

        int max = 0;
        for(int i=1;i<=n+1;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
