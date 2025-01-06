import java.util.Scanner;

public class B11729 
{
    static StringBuilder sb = new StringBuilder(); // ��� ������ ������ StringBuilder

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n�� �Է¹���

        // �ϳ���ž�� �ּ� �̵� Ƚ��
        int result = (int) Math.pow(2, n) - 1; 
        System.out.println(result);

        // �ϳ���ž �̵� ���� ����
        hanoi(n, 1, 3, 2);

        // ����� ����� �� ���� ���
        System.out.print(sb.toString());
        sc.close();
    }

    // �ϳ���ž ��� �Լ�
    public static void hanoi(int n, int start, int end, int temp)
    {
        if (n == 1) 
        {
            // ���� ���� ��ũ�� �������� �̵� (StringBuilder�� �߰�)
            sb.append(start).append(" ").append(end).append("\n");
        } 
        else 
        {
            // n-1���� ��ũ�� �ӽ� ����� �̵�
            hanoi(n - 1, start, temp, end);
            // ���� ū ��ũ�� �������� �̵�
            sb.append(start).append(" ").append(end).append("\n");
            // n-1���� ��ũ�� �������� �̵�
            hanoi(n - 1, temp, end, start);
        }
    }
}
