import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10]; // n자리의 뒷자리는 i인 경우의 수
        for(int i=0;i<=9;i++) {
            dp[1][i]=1;
        }

        for(int i=2;i<=n;i++) {
            for(int j=0;j<=9;j++) {
                for(int k=0;k<=j;k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }
        int answer=0;
        for(int i=0;i<=9;i++) {
            answer = (answer+dp[n][i]) %10007;
        }
        System.out.println(answer);
    }
}