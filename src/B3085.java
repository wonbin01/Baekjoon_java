import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3085 {
    static int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static int total = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 보드의 크기
        char[][] board = new char[n][n]; // 보드
        for(int i=0;i<n;i++) {
            String input = br.readLine(); 
            for(int j=0;j<n;j++) {
                char c = input.charAt(j);
                board[i][j] = c;
            }
        }
        calculateColor(board, n);
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                changeLocation(i, j, board, n);
            }
        }
        System.out.println(total);
    }
    static void changeLocation(int row, int col, char[][] board, int n) {
        char color = board[row][col];
        char[][] copy = new char[n][n];
        for(int i=0;i<n;i++) {
            copy[i] = board[i].clone();
        }
        for(int i=0;i<4;i++) {
            int nx = row + direction[i][0];
            int ny = col + direction[i][1];
            if(nx>=0 && nx < n && ny>=0 && ny<n && color!=board[nx][ny]) { //색깔이 다른 경우
                char change = board[nx][ny];
                copy[row][col] = change;
                copy[nx][ny] = color;
                calculateColor(copy, n);
                copy[row][col] = color;
                copy[nx][ny] = change;
            }
        }
    }

    static void calculateColor(char[][] copy,int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                char color = copy[i][j];
                for(int r=0;r<4;r++) {
                    int cnt=1;
                    int row_direction = direction[r][0];
                    int col_direction = direction[r][1];
                    int nx = i+row_direction; int ny = j+col_direction;
                    while(nx>=0 && nx<n && ny>=0 && ny<n && color == copy[nx][ny]) {
                        cnt++;
                        nx+=row_direction; ny+=col_direction;
                    }
                    total = Math.max(cnt, total);
                }
            }
        }
    }
}
