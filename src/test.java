import java.util.Scanner;

public class test {
    public static int cctv_cnt = 0; // CCTV의 개수
    public static int minBlindSpot = Integer.MAX_VALUE; // 최소 사각지대 크기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int[][] work_place = new int[n][m]; // 사무실

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                work_place[i][j] = sc.nextInt();
                if (work_place[i][j] != 0 && work_place[i][j] != 6) {
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

        int[][] newboard = copyboard(work_place);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (work_place[i][j] >= 1 && work_place[i][j] <= 5) {
                    if (work_place[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            copyArray(work_place, newboard);
                            applyDirection(newboard, i, j, k);
                            Findmin(newboard, cnt + 1);
                        }
                    } else if (work_place[i][j] == 2) {
                        for (int k = 0; k < 2; k++) {
                            copyArray(work_place, newboard);
                            applyDirection(newboard, i, j, k);
                            applyDirection(newboard, i, j, (k + 2) % 4);
                            Findmin(newboard, cnt + 1);
                        }
                    } else if (work_place[i][j] == 3) {
                        for (int k = 0; k < 4; k++) {
                            copyArray(work_place, newboard);
                            applyDirection(newboard, i, j, k);
                            applyDirection(newboard, i, j, (k + 1) % 4);
                            Findmin(newboard, cnt + 1);
                        }
                    } else if (work_place[i][j] == 4) {
                        for (int k = 0; k < 4; k++) {
                            copyArray(work_place, newboard);
                            applyDirection(newboard, i, j, k);
                            applyDirection(newboard, i, j, (k + 1) % 4);
                            applyDirection(newboard, i, j, (k + 2) % 4);
                            Findmin(newboard, cnt + 1);
                        }
                    } else if (work_place[i][j] == 5) {
                        copyArray(work_place, newboard);
                        for (int k = 0; k < 4; k++) {
                            applyDirection(newboard, i, j, k);
                        }
                        Findmin(newboard, cnt + 1);
                    }
                    return; // 현재 CCTV 처리 후 종료
                }
            }
        }
    }

    public static void applyDirection(int[][] board, int row, int col, int dir) {
        int n = board.length;
        int m = board[0].length;

        if (dir == 0) { // 위쪽
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][col] == 6) break;
                if (board[i][col] == 0) board[i][col] = -1;
            }
        } else if (dir == 1) { // 아래쪽
            for (int i = row + 1; i < n; i++) {
                if (board[i][col] == 6) break;
                if (board[i][col] == 0) board[i][col] = -1;
            }
        } else if (dir == 2) { // 왼쪽
            for (int i = col - 1; i >= 0; i--) {
                if (board[row][i] == 6) break;
                if (board[row][i] == 0) board[row][i] = -1;
            }
        } else if (dir == 3) { // 오른쪽
            for (int i = col + 1; i < m; i++) {
                if (board[row][i] == 6) break;
                if (board[row][i] == 0) board[row][i] = -1;
            }
        }
    }

    public static void copyArray(int[][] src, int[][] dest) {
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
        }
    }

    public static int[][] copyboard(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] newboard = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newboard[i][j] = board[i][j];
            }
        }
        return newboard;
    }
}
