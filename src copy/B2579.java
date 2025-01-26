import java.io.*;

public class B2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 계단 개수 입력
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        
        // 계단 점수 입력
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        
        // 계단 점수 저장할 배열
        int[] score = new int[n + 1];
        
        // 초기값 처리
        score[1] = stair[1];
        if (n >= 2) {
            score[2] = stair[1] + stair[2];
        }
        if (n >= 3) {
            score[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
        }
        
        // 동적 프로그래밍 계산
        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i - 2], score[i - 3] + stair[i - 1]) + stair[i];
        }
        
        // 결과 출력
        System.out.println(score[n]);
    }
}
