import java.io.*;
import java.util.Arrays;

public class B31929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int[] victory_score = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) victory_score[i] = Integer.parseInt(input[i]);

        int m = Integer.parseInt(br.readLine());
        int[] loss_score = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) loss_score[i] = Integer.parseInt(input[i]);
        int k = Integer.parseInt(br.readLine());
        int[][] dp=new int[n+1][m+1]; //i번 승리하고 j번 패배했을 때 최대 점수수
        for(int[] row : dp)
        {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0]=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                int cur=dp[i][j];
                if(i<n) //승리
                {
                    dp[i+1][j]=Math.max(dp[i+1][j],cur+victory_score[i]);
                }
                if(j<m)
                {
                    int b=cur%k;
                    if(b<0) b+=k;
                    int loss=(b>0) ? Math.min(loss_score[j],b) : loss_score[j];
                    dp[i][j+1]=Math.max(dp[i][j+1],cur-loss);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}