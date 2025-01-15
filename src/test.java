import java.io.*;

public class test {
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n�� �Է¹���

        int[] min_func = new int[1000001]; // �ּ� ���� Ƚ�� ����
        int[] route = new int[1000001];   // ��� ������ �迭

        min_func[1] = 0; // 1�� ���� �ʿ� ����
        for (int i = 2; i <= n; i++) {
            // �⺻������ 1�� �� ���� �ʱ�ȭ
            min_func[i] = min_func[i - 1] + 1;
            route[i] = i - 1;

            // 2�� ���� �� �ִ� ���
            if (i % 2 == 0 && min_func[i] > min_func[i / 2] + 1) {
                min_func[i] = min_func[i / 2] + 1;
                route[i] = i / 2;
            }

            // 3���� ���� �� �ִ� ���
            if (i % 3 == 0 && min_func[i] > min_func[i / 3] + 1) {
                min_func[i] = min_func[i / 3] + 1;
                route[i] = i / 3;
            }
        }

        // �ּ� ���� Ƚ�� ���
        sb.append(min_func[n]).append("\n");

        // ��� ����
        while (n > 0) {
            sb.append(n).append(" ");
            n = route[n];
        }

        System.out.print(sb);
    }
}
