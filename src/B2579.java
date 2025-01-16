import java.io.*;

public class B2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // ��� ���� �Է�
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        
        // ��� ���� �Է�
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        
        // ��� ���� ������ �迭
        int[] score = new int[n + 1];
        
        // �ʱⰪ ó��
        score[1] = stair[1];
        if (n >= 2) {
            score[2] = stair[1] + stair[2];
        }
        if (n >= 3) {
            score[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
        }
        
        // ���� ���α׷��� ���
        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i - 2], score[i - 3] + stair[i - 1]) + stair[i];
        }
        
        // ��� ���
        System.out.println(score[n]);
    }
}
