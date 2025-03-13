import java.io.*;
public class B14501 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] T=new int[n+1]; //상담 기간
        int[] P=new int[n+1]; //보수
        int[] dp=new int[n+2]; //dp -> i번째 날부터 퇴사일까지 얻을 수 있는 최대 이익

        for (int i = 1; i <= n; i++) 
        {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        for(int i=n;i>0;i--)
        {
            if(i+T[i]<=n+1) //퇴사 전에 끝나는 경우
            {
                dp[i]=Math.max(dp[i+1],P[i]+dp[i+T[i]]);
            }
            else
            {
                dp[i]=dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}
