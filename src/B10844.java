import java.io.*;

public class B10844 
{
    public static void main(String[] args) throws IOException 
    {
        final int MOD = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];

        // 초기값 설정: 길이 1에서 1~9로 시작하는 수는 1개씩
        for (int i = 1; i <= 9; i++) 
        {
            dp[1][i] = 1;
        }

        // 점화식 적용
        for (int i = 2; i <= n; i++) 
        {
            for (int j = 0; j <= 9; j++) 
            {
                if (j > 0) dp[i][j] += dp[i-1][j-1];
                if (j < 9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= MOD;
            }
        }

        // 정답: 길이 n일 때의 전체 계단 수의 개수
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }
}
