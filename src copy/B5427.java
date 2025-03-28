import java.io.*;
import java.util.*;

public class B5427 {
    static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]); // 지도 너비
            int h = Integer.parseInt(input[1]); // 지도 높이

            Queue<int[]> fire = new LinkedList<>(); // 불의 이동을 저장하는 큐
            Queue<int[]> sangeun = new LinkedList<>(); // 상근이의 이동을 저장하는 큐
            int[][] fireTime = new int[h][w]; // 불의 시간 기록
            int[][] sangeunTime = new int[h][w]; // 상근이의 시간 기록
            char[][] map = new char[h][w];
            boolean escaped = false;

            // 지도 입력 받기
            for (int height = 0; height < h; height++) {
                String line = br.readLine();
                for (int width = 0; width < w; width++) {
                    char situation = line.charAt(width);
                    map[height][width] = situation;

                    if (situation == '@') { // 상근이의 시작 위치
                        sangeun.add(new int[]{height, width, 0}); // 상근이 위치와 시간
                    } else if (situation == '*') { // 불의 위치
                        fire.add(new int[]{height, width});
                        fireTime[height][width] = 0;
                    }
                }
            }

            // 불 확산 BFS
            while (!fire.isEmpty()) {
                int[] current = fire.poll();
                int currentRow = current[0], currentCol = current[1];
                for (int d = 0; d < 4; d++) {
                    int nx = currentRow + direction[d][0];
                    int ny = currentCol + direction[d][1];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.' && fireTime[nx][ny] == 0) {
                        fireTime[nx][ny] = fireTime[currentRow][currentCol] + 1;
                        fire.add(new int[]{nx, ny});
                    }
                }
            }

            // 상근이 이동 BFS
            while (!sangeun.isEmpty() && !escaped) {
                int[] current = sangeun.poll();
                int currentRow = current[0], currentCol = current[1], currentTime = current[2];
                for (int d = 0; d < 4; d++) {
                    int nx = currentRow + direction[d][0];
                    int ny = currentCol + direction[d][1];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(currentTime + 1).append("\n");
                        escaped = true;
                        break;
                    }
                    if (map[nx][ny] == '.' && sangeunTime[nx][ny] == 0 && (fireTime[nx][ny] == 0 || fireTime[nx][ny] > currentTime + 1)) {
                        sangeunTime[nx][ny] = currentTime + 1;
                        sangeun.add(new int[]{nx, ny, currentTime + 1});
                    }
                }
                if (escaped) break;
            }

            if (!escaped) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
