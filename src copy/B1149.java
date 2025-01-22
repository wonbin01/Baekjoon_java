import java.util.Scanner;

public class B1149
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] house = new int[n][3];
        int[][] dp = new int[n][3]; // dp[i][j]: i��° ���� j������ ĥ�� ���� �ּ� ���

        // �Է� �ޱ�
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        // �ʱⰪ ���� (ù ��° ��)
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        // DP ���̺� ä���
        for (int i = 1; i < n; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // ���� ���
        int result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(result);

        sc.close();
    }
}
