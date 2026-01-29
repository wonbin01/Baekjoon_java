import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018 {
    static final int ROW = 8;
    static final int COL = 8;
    static char[][] whiteFirst = new char[][] {{'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'}};

    static char[][] blackFirst = new char[][] {{'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'},
                                               {'B','W','B','W','B','W','B','W'},
                                               {'W','B','W','B','W','B','W','B'}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 세로
        int m = Integer.parseInt(input[1]); // 가로
        char[][] board = new char[n][m]; // 판의 정보
        int min = Integer.MAX_VALUE; // 최소로 칠하는 칸의 개수
        for(int i=0;i<n;i++) {
            String row = br.readLine();
            for(int j=0;j<m;j++) {
                char c = row.charAt(j);
                board[i][j] = c;
            }
        }
        //0~n까지 순회하면서 8*8 뜯어서 개수 세기
        for(int i=0;i<=n-8;i++) {
            for(int j=0;j<=m-8;j++) {
                char[][] candidateBoard = makeCandidateBoard(i, j, board);
                min = Math.min(min, calculateColorBoard(candidateBoard));
            }
        }
        System.out.println(min);
    }
    static char[][] makeCandidateBoard(int row, int col, char[][] board) {
        // 후보 체스판을 만들어 주는 메서드
        char[][] candidateBoard = new char[ROW][COL];
        for(int i=0;i<ROW;i++) {
            for(int j=0;j<COL;j++) {
                candidateBoard[i][j] = board[row+i][col+j];
            }
        }
        return candidateBoard;
    }

    static int calculateColorBoard(char[][] candidateBoard) {
        int whitecnt = 0;
        int blackcnt = 0;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(candidateBoard[i][j] != whiteFirst[i][j]) {
                    whitecnt++;
                }
                if(candidateBoard[i][j] != blackFirst[i][j]) {
                    blackcnt++;
                }
            }
        }
        return Math.min(whitecnt,blackcnt);
    }
}

