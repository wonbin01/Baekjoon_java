import java.io.*;

public class B25956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] title = new int[n];
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            title[i] = Integer.parseInt(br.readLine());
        }

        int[] stack = new int[n]; // 트리 구조를 역추적하기 위한 스택
        int top = -1; // 스택의 top

        for (int i = n - 1; i >= 0; i--) {
            // 현재 노드가 자식이 될 수 있는 조건은, 스택에 쌓인 노드보다 레벨이 1 작을 때
            while (top >= 0 && title[i] >= stack[top]) {
                top--; // 자식 노드가 될 수 없는 것들은 제거
            }

            if (top >= 0 && title[i] + 1 == stack[top]) {
                cnt[i] = 1; // 바로 다음이 자식이면 하나
                // 이후 같은 레벨의 형제가 있다면 그것들도 자식으로 포함
                int j = i + 1;
                while (j < n && title[j] == title[i] + 1) {
                    cnt[i] += cnt[j];
                    j++;
                }
            }

            // 계층 구조가 잘못된 경우 (2 이상 차이 나는 경우)
            if (i < n - 1 && title[i] < title[i + 1] && title[i + 1] - title[i] >= 2) {
                System.out.println(-1);
                return;
            }

            stack[++top] = title[i]; // 현재 노드를 스택에 push
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int c : cnt) {
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
