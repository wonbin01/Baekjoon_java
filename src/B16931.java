import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16931 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int total = 0;

        // 방향: 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = board[i][j];

                if (h > 0) {
                    // 위 + 아래
                    total += 2;
                }

                // 4방향 비교
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    int neighbor = 0;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        neighbor = board[nx][ny];
                    }

                    if (h > neighbor) {
                        total += (h - neighbor);
                    }
                }
            }
        }

        System.out.println(total);
    }
}
