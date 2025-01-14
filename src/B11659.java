import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ù �� �Է�
        String input = br.readLine();
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]); // ���� ����
        int m = Integer.parseInt(parts[1]); // �ݺ��ϴ� Ƚ��

        // ���� �迭 �Է�
        int[] number = new int[n];
        int[] prefixSum = new int[n + 1]; // ���� �� �迭
        input = br.readLine();
        parts = input.split(" ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(parts[i]);
            prefixSum[i + 1] = prefixSum[i] + number[i]; // ���� �� ���
        }

        // ���� �Է� �� ��� ���
        StringBuilder sb = new StringBuilder(); // ��� �����
        for (int i = 0; i < m; i++) {
            input = br.readLine();
            parts = input.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int result = prefixSum[end] - prefixSum[start - 1]; // ���� �� ���
            sb.append(result).append("\n");
        }

        // ��� ���
        System.out.print(sb.toString());
    }
}
