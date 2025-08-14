import java.io.*;
import java.util.Arrays;

public class B17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // DP 배열 정의:
        // dp[i][j][0]: (i, j)에 왼쪽 위에서 오는 경우의 최소 비용
        // dp[i][j][1]: (i, j)에 바로 위에서 오는 경우의 최소 비용
        // dp[i][j][2]: (i, j)에 오른쪽 위에서 오는 경우의 최소 비용
        int[][][] dp = new int[n][m][3];
        final int INF = 1000001; // 충분히 큰 값으로 무한대 설정

        // 첫 번째 행(i=0) 초기화
        for (int j = 0; j < m; j++) {
            Arrays.fill(dp[0][j], map[0][j]);
        }

        // 두 번째 행부터 DP 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1. 왼쪽 위에서 오는 경우 (dp[i][j][0])
                int leftPrev = (j > 0) ? Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) : INF;
                dp[i][j][0] = map[i][j] + leftPrev;

                // 2. 바로 위에서 오는 경우 (dp[i][j][1])
                int topPrev = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                dp[i][j][1] = map[i][j] + topPrev;

                // 3. 오른쪽 위에서 오는 경우 (dp[i][j][2])
                int rightPrev = (j < m - 1) ? Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) : INF;
                dp[i][j][2] = map[i][j] + rightPrev;
            }
        }
        
        // 마지막 행에서 최소 연료 비용 찾기
        int minFuel = INF;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                minFuel = Math.min(dp[n - 1][j][k], minFuel);
            }
        }
        System.out.println(minFuel);
    }
}