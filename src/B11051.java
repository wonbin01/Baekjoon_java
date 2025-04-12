import java.io.*;

public class B11051 {
    public static final int MOD = 10007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        // DP 배열 초기화
        int[][] dp = new int[1002][1002];
        for(int i=0;i<=1000;i++)
        {
            dp[i][0]=1; dp[i][i]=1;
            for(int j=1;j<i;j++)
            {
                dp[i][j]=(dp[i-1][j]+dp[i-1][j-1])%MOD;
            }
        }
        System.out.println(dp[n][k]%MOD);
    }
}
