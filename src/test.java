import java.io.*;

public class test {
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n을 입력받음

        int[] min_func = new int[1000001]; // 최소 연산 횟수 저장
        int[] route = new int[1000001];   // 경로 추적용 배열

        min_func[1] = 0; // 1은 연산 필요 없음
        for (int i = 2; i <= n; i++) {
            // 기본적으로 1을 뺀 경우로 초기화
            min_func[i] = min_func[i - 1] + 1;
            route[i] = i - 1;

            // 2로 나눌 수 있는 경우
            if (i % 2 == 0 && min_func[i] > min_func[i / 2] + 1) {
                min_func[i] = min_func[i / 2] + 1;
                route[i] = i / 2;
            }

            // 3으로 나눌 수 있는 경우
            if (i % 3 == 0 && min_func[i] > min_func[i / 3] + 1) {
                min_func[i] = min_func[i / 3] + 1;
                route[i] = i / 3;
            }
        }

        // 최소 연산 횟수 출력
        sb.append(min_func[n]).append("\n");

        // 경로 추적
        while (n > 0) {
            sb.append(n).append(" ");
            n = route[n];
        }

        System.out.print(sb);
    }
}
