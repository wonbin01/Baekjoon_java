import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B20055 {
    public static void main(String[] args) throws IOException {
        int level = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 길이가 2n의 벨트, 1번이 올리는 칸, n번이 내리는 칸
        int k = Integer.parseInt(input[1]); // 내구도 0인 칸 개수 k개 이상이면 종료
        int[] box = new int[2 * n + 1]; // 1~2n
        input = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            box[i + 1] = Integer.parseInt(input[i]);
        }

        int current_up = 1;
        int current_remove = n;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] floor = new boolean[2 * n + 1];
        int zeroCnt = 0; // 내구도가 0인 칸 수

        while (true) {
            level++;

            // 1. 벨트 회전
            current_up--;
            if (current_up == 0) current_up = 2 * n;
            current_remove--;
            if (current_remove == 0) current_remove = 2 * n;

            // 내리는 칸에 로봇 있으면 제거
            if (floor[current_remove]) {
                box[current_remove]--;
                floor[current_remove] = false;
            }

            // 2. 로봇 이동
            int size = queue.size();
            int[] candidate = new int[size];
            for (int i = 0; i < size; i++) candidate[i] = queue.poll();

            for (int i = 0; i < size; i++) {
                int cur_floor = candidate[i];
                int next_floor = cur_floor + 1;
                if (next_floor == 2 * n + 1) next_floor = 1;

                if (next_floor == current_remove) { // 내리는 위치
                    box[current_remove]--;
                    floor[cur_floor] = false;
                    floor[current_remove]=false;
                    continue;
                }

                if (!floor[next_floor] && box[next_floor] >= 1) { // 이동 가능
                    floor[next_floor] = true;
                    box[next_floor]--;
                    if (box[next_floor] == 0) zeroCnt++; // 내구도 0이면 카운트
                    floor[cur_floor] = false;
                    queue.add(next_floor);
                } else { // 이동 불가
                    queue.add(cur_floor);
                }
            }

            // 3. 로봇 올리기
            if (box[current_up] > 0) {
                box[current_up]--;
                if (box[current_up] == 0) zeroCnt++;
                floor[current_up] = true;
                queue.add(current_up);
            }

            // 4. 종료 조건
            if (zeroCnt >= k) break;
        }

        System.out.println(level);
    }
}
