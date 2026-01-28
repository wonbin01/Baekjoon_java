import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2225 {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 합
        int k = Integer.parseInt(input[1]); // 개수
        int[][] dp = new int[k + 1][n + 1];
        // 초기값
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;   // 합 0
        }
        for (int j = 0; j <= n; j++) {
            dp[1][j] = 1;   // 숫자 1개
        }
        // DP
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[k][n]);
    }
}