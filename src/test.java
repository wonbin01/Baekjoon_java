import java.util.*;

public class test {
    public static int cctv_cnt = 0; // CCTV의 개수
    public static int minBlindSpot = Integer.MAX_VALUE; // 최소 사각지대 크기
    public static List<int[]> cctvs = new ArrayList<>(); // CCTV 위치와 종류

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int[][] work_place = new int[n][m]; // 사무실

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                work_place[i][j] = sc.nextInt();
                if (work_place[i][j] != 0 && work_place[i][j] != 6) {
                    cctvs.add(new int[]{i, j, work_place[i][j]}); // CCTV 위치와 종류 저장
                    cctv_cnt++;
                }
            }
        }
        Findmin(work_place, 0);
        System.out.println(minBlindSpot);
        sc.close();
    }

    public static void Findmin(int[][] work_place, int cnt) {
        int n = work_place.length;
        int m = work_place[0].length;

        if (cnt == cctv_cnt) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (work_place[i][j] == 0) {
                        count++;
                    }
                }
            }
            minBlindSpot = Math.min(minBlindSpot, count);
            return;
        }

        // 현재 처리할 CCTV 정보
        int[] cctv = cctvs.get(cnt);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        // CCTV 방향 설정
        int[][] directions;
        if (type == 1) {
            directions = new int[][]{{0}, {1}, {2}, {3}}; // 1개 방향
        } else if (type == 2) {
            directions = new int[][]{{0, 1}, {2, 3}}; // 반대 방향 2개
        } else if (type == 3) {
            directions = new int[][]{{0, 3}, {1, 3}, {1, 2}, {0, 2}}; // 직각 방향 2개
        } else if (type == 4) {
            directions = new int[][]{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}; // 3개 방향
        } else { // type == 5
            directions = new int[][]{{0, 1, 2, 3}}; // 4개 방향
        }

        for (int[] dirSet : directions) {
            int[][] newboard = copyboard(work_place);
            for (int dir : dirSet) {
                mark(newboard, x, y, dir);
            }
            Findmin(newboard, cnt + 1);
        }
    }

    public static int[][] copyboard(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] newboard = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, newboard[i], 0, m);
        }
        return newboard;
    }

    public static void mark(int[][] board, int x, int y, int dir) {
        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != 6) {
            if (board[nx][ny] == 0) {
                board[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }
}
