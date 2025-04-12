import java.util.Scanner;

public class B9663 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[1];  // 카운트를 배열로 바꾸어 참조로 전달
        boolean[] cols = new boolean[n];  // 각 열에 퀸이 놓였는지 여부
        boolean[] diag1 = new boolean[2 * n - 1];  // 왼쪽 위에서 오른쪽 아래로 가는 대각선
        boolean[] diag2 = new boolean[2 * n - 1];  // 왼쪽 아래에서 오른쪽 위로 가는 대각선
        
        // 퀸 배치
        queen(n, 0, cols, diag1, diag2, cnt);
        System.out.println(cnt[0]);
        sc.close();
    }

    // 퀸을 놓는 재귀 함수
    public static void queen(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int[] cnt) 
    {
        if (row == n) 
        {  // 퀸을 모두 배치한 경우
            cnt[0]++;  // 가능한 배치 하나 증가
            return;
        }

        // 해당 행에 퀸을 놓을 수 있는지 확인
        for (int col = 0; col < n; col++) 
        {
            // 열, 대각선에 퀸이 이미 놓여있는지 확인 (가지치기)
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col])
            {
                continue;  // 퀸을 놓을 수 없는 위치
            }

            // 퀸을 놓고 방문 표시
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            // 다음 행으로 재귀 호출
            queen(n, row + 1, cols, diag1, diag2, cnt);

            // 상태 복원 (백트래킹)
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
}
