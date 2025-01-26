import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력
        String input = br.readLine();
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]); // 수의 개수
        int m = Integer.parseInt(parts[1]); // 반복하는 횟수

        // 숫자 배열 입력
        int[] number = new int[n];
        int[] prefixSum = new int[n + 1]; // 누적 합 배열
        input = br.readLine();
        parts = input.split(" ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(parts[i]);
            prefixSum[i + 1] = prefixSum[i] + number[i]; // 누적 합 계산
        }

        // 구간 입력 및 결과 계산
        StringBuilder sb = new StringBuilder(); // 결과 저장용
        for (int i = 0; i < m; i++) {
            input = br.readLine();
            parts = input.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int result = prefixSum[end] - prefixSum[start - 1]; // 구간 합 계산
            sb.append(result).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
