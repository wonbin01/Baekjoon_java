import java.io.*;

public class B12852 {
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // n�� �Է¹���
        int n = Integer.parseInt(input);
        int temp=n;

        int[] min_func = new int[1000001];
        int[] route = new int[1000001]; // ��� ������ �迭

        min_func[1] = 0; // 1�� ���� �ʿ� ����
        if (n >= 2) min_func[2] = 1;
        if (n >= 3) min_func[3] = 1;

        // �ּ� ���� Ƚ�� ��� �� ��� ����
        for (int i = 4; i <= n; i++) {
            if (i % 3 != 0 && i % 2 != 0) { // 2�� 3���� �������� ������
                min_func[i] = min_func[i - 1] + 1;
                route[i] = i - 1; // ���� ��� ����
            } else if (i % 2 == 0 && i % 3 != 0) { // 2�θ� ������ ��
                if (min_func[i - 1] < min_func[i / 2]) {
                    min_func[i] = min_func[i - 1] + 1;
                    route[i] = i - 1;
                } else {
                    min_func[i] = min_func[i / 2] + 1;
                    route[i] = i / 2;
                }
            } else if (i % 2 != 0 && i % 3 == 0) { // 3���θ� ������ ��
                if (min_func[i - 1] < min_func[i / 3]) {
                    min_func[i] = min_func[i - 1] + 1;
                    route[i] = i - 1;
                } else {
                    min_func[i] = min_func[i / 3] + 1;
                    route[i] = i / 3;
                }
            } else if (i % 2 == 0 && i % 3 == 0) { // 2�� 3 ��� ������ ��
                int temp1 = Math.min(min_func[i / 3], min_func[i / 2]) + 1;
                int temp2 = min_func[i - 1] + 1;

                if (temp1 < temp2) {
                    min_func[i] = temp1;
                    if (min_func[i / 3] < min_func[i / 2]) {
                        route[i] = i / 3;
                    } else {
                        route[i] = i / 2;
                    }
                } else {
                    min_func[i] = temp2;
                    route[i] = i - 1;
                }
            }
        }

        // �ּ� ���� Ƚ�� ���
        sb.append(min_func[n]).append("\n");

        // ��� ����
        while (n > 0) 
        {
            sb.append(n).append(" ");
            if(n==1) break;
            n = route[n]; // ���� ��η� �̵�
        }
        if(temp>1)
        {
            sb.append(1);
            System.out.print(sb);
        }

        else
        {
            System.out.print(sb);
        }
    }
}
