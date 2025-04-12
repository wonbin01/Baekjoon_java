import java.util.Scanner;

public class B9663 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[1];  // ī��Ʈ�� �迭�� �ٲپ� ������ ����
        boolean[] cols = new boolean[n];  // �� ���� ���� �������� ����
        boolean[] diag1 = new boolean[2 * n - 1];  // ���� ������ ������ �Ʒ��� ���� �밢��
        boolean[] diag2 = new boolean[2 * n - 1];  // ���� �Ʒ����� ������ ���� ���� �밢��
        
        // �� ��ġ
        queen(n, 0, cols, diag1, diag2, cnt);
        System.out.println(cnt[0]);
        sc.close();
    }

    // ���� ���� ��� �Լ�
    public static void queen(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int[] cnt) 
    {
        if (row == n) 
        {  // ���� ��� ��ġ�� ���
            cnt[0]++;  // ������ ��ġ �ϳ� ����
            return;
        }

        // �ش� �࿡ ���� ���� �� �ִ��� Ȯ��
        for (int col = 0; col < n; col++) 
        {
            // ��, �밢���� ���� �̹� �����ִ��� Ȯ�� (����ġ��)
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col])
            {
                continue;  // ���� ���� �� ���� ��ġ
            }

            // ���� ���� �湮 ǥ��
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            // ���� ������ ��� ȣ��
            queen(n, row + 1, cols, diag1, diag2, cnt);

            // ���� ���� (��Ʈ��ŷ)
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
}
