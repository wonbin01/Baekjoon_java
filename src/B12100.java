import java.util.Scanner;

public class B12100
{
    public static int maxblock = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] initial_state = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                initial_state[i][j] = sc.nextInt();
            }
        }

        Findmaxblock(initial_state, 0);
        System.out.println(maxblock);
        sc.close();
    }

    public static void Findmaxblock(int[][] board, int depth) {
        if (depth == 5) 
        {
            int n=board.length;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    maxblock=Math.max(maxblock,board[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) 
        {
            int[][] newboard = copyboard(board);

            if (i == 0) 
            {
                up_dir(newboard);
            } 
            else if (i == 1) 
            {
                down_dir(newboard);
            } 
            else if (i == 2) 
            {
                left_dir(newboard);
            } 
            else if (i == 3) 
            {
                right_dir(newboard);
            }
            Findmaxblock(newboard, depth + 1);
        }
    }

    public static int[][] copyboard(int[][] board) 
    {
        int n = board.length;
        int[][] newboard = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                newboard[i][j]=board[i][j];
            }
        }

        return newboard;
    }

    public static void up_dir(int[][] initial_state) 
    {
        int n = initial_state.length;

        for (int col = 0; col < n; col++) 
        {
            int[] temp = new int[n];
            boolean[] merged = new boolean[n];
            int index = 0;

            for (int row = 0; row < n; row++) 
            {
                if (initial_state[row][col] != 0) 
                {
                    temp[index++] = initial_state[row][col];
                }
            }

            for (int row = 0;row<n-1; row++) 
            {
                if (temp[row] != 0 && temp[row] == temp[row + 1] && !merged[row]) 
                {
                    temp[row] *= 2;
                    merged[row] = true;
                    temp[row + 1] = 0;
                }
            }

            index = 0;
            for (int row = 0; row < n; row++)
            {
                if (temp[row] != 0) 
                {
                    initial_state[index++][col] = temp[row];
                }
            }
            for(int row=index;row<n;row++)
            {
                initial_state[row][col]=0;
            }
        }
    }

    public static void down_dir(int[][] initial_state) {
        int n = initial_state.length;

        for (int col = 0; col < n; col++) {
            int[] temp = new int[n];
            boolean[] merged = new boolean[n];
            int index = 0;

            for (int row = n - 1; row >= 0; row--) {
                if (initial_state[row][col] != 0) {
                    temp[index++] = initial_state[row][col];
                }
            }

            for (int row = 0; row < n - 1; row++) {
                if (temp[row] != 0 && temp[row] == temp[row + 1] && !merged[row]) {
                    temp[row] *= 2;
                    temp[row + 1] = 0;
                    merged[row] = true;
                }
            }

            index = n - 1;
            for (int row = 0; row < n; row++) {
                if (temp[row] != 0) {
                    initial_state[index--][col] = temp[row];
                }
            }
            for(int row=index;row>=0;row--)
            {
                initial_state[row][col]=0;
            }
        }
    }

    public static void left_dir(int[][] initial_state) {
        int n = initial_state.length;

        for (int row = 0; row < n; row++) {
            int[] temp = new int[n];
            boolean[] merged = new boolean[n];
            int index = 0;

            for (int col = 0; col < n; col++) {
                if (initial_state[row][col] != 0) {
                    temp[index++] = initial_state[row][col];
                }
            }

            for (int col = 0; col < n - 1; col++) {
                if (temp[col] != 0 && temp[col] == temp[col + 1] && !merged[col]) {
                    temp[col] *= 2;
                    temp[col + 1] = 0;
                    merged[col] = true;
                }
            }

            index = 0;
            for (int col = 0; col < n; col++) {
                if (temp[col] != 0) {
                    initial_state[row][index++] = temp[col];
                }
            }
            for(int col=index;col<n;col++)
            {
                initial_state[row][col]=0;
            }
        }
    }
    public static void right_dir(int[][] initial_state) {
        int n = initial_state.length;
    
        for (int row = 0; row < n; row++) {
            int[] temp = new int[n];
            boolean[] merged = new boolean[n];
            int index = n - 1; // 오른쪽부터 채움
    
            // 값이 0이 아닌 숫자만 temp로 이동
            for (int col = n - 1; col >= 0; col--) {
                if (initial_state[row][col] != 0) {
                    temp[index--] = initial_state[row][col];
                }
            }
    
            // 병합 처리
            for (int col = n - 1; col > 0; col--) {
                if (temp[col] != 0 && temp[col] == temp[col - 1] && !merged[col]) {
                    temp[col] *= 2;       // 병합
                    temp[col - 1] = 0;    // 병합된 값 제거
                    merged[col] = true;   // 병합 상태 저장
                }
            }
    
            // 병합 결과를 다시 오른쪽으로 채움
            index = n - 1;
            for (int col = n - 1; col >= 0; col--) {
                if (temp[col] != 0) {
                    initial_state[row][index--] = temp[col];
                }
            }
            for(int col=index;col>=0;col--)
            {
                initial_state[row][col]=0;
            }
        }
    }
    
    
}
