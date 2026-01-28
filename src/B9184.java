import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9184 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        initialize();
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k <= 20; k++) {
                    if (i < j && j < k) {
                        dp[i][j][k] =
                                dp[i][j][k-1]
                            + dp[i][j-1][k-1]
                            - dp[i][j-1][k];
                    } else {
                        dp[i][j][k] =
                                dp[i-1][j][k]
                            + dp[i-1][j-1][k]
                            + dp[i-1][j][k-1]
                            - dp[i-1][j-1][k-1];
                    }
                }
            }
        }

        while (true) {
            String[] input = br.readLine().split(" ");
            int[] numbers = new int[3];
            for(int i=0;i<3;i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            if(checkExit(numbers)) {
                break;
            }
            String result = makeValidOutput(numbers);
            sb.append(result);
        }
        System.out.println(sb.toString());
    }
    static boolean checkExit(int[] numbers) {
        boolean exit = true;
        for(int n : numbers) {
            if(n!=-1) {
                return false;
            }
        }
        return exit;
    }

    static String makeValidOutput(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int result = recursive(numbers[0], numbers[1], numbers[2]);
        sb.append('w').append("(").append(numbers[0]).append(", ").append(numbers[1])
        .append(", ").append(numbers[2]).append(") ").append("= ").append(result).append("\n");
        return sb.toString();
    }

    static int recursive(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) {
            return 1;
        }
        else if(a>20 || b>20 || c>20) {
            return dp[20][20][20];
        }
        else {
            return dp[a][b][c];
        }

    }

    static void initialize() {
        for(int i=0;i<=20;i++) {
            for(int j=0;j<=20;j++) {
                dp[0][i][j]=1;
                dp[i][0][j]=1;
                dp[i][j][0]=1;
            }
        }
    }
}