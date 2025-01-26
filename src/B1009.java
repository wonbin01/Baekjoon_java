import java.util.Scanner;

public class B1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // �׽�Ʈ ���̽� ����
        
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(); // ���� a
            int b = sc.nextInt(); // ������ �� b
            calculate(a, b);
        }
        
        sc.close();
    }

    public static void calculate(int a, int b) {
        int[] storage = new int[10]; // ���ڸ� �ֱ⸦ ������ �迭
        int x = a % 10; // a�� ���ڸ��� ���
        storage[0] = x;
        int num = 1;

        // a�� ���ڸ��� �ݺ��Ǵ� �ֱ� ã��
        while (true) {
            x = (x * a) % 10; // (x * ���� ��) % 10�� ��� ���
            // �̹� ���� ���� ������ �ݺ� ����
            for (int i = 0; i < num; i++) {
                if (storage[i] == x) {
                    returnResult(storage, num, b);
                    return;
                }
            }
            if (num == 10) break; // 10��°���� ä������ ����
            storage[num] = x; // ���ο� ���ڸ� ����
            num++;
        }

        // b�� �ֱ� ����(num)�� �ʰ��� ���, �������� ��ǻ�� ��ȣ�� ���
        returnResult(storage, num, b);
    }

    // �ֱ��� ���̿� b ���� ���� ����� ���
    private static void returnResult(int[] storage, int num, int b) 
    {
        int index = b % num;
        if (index == 0) 
        {
            if(storage[num-1]==0)
            {
                System.out.println(10);
            }
            else
            {
                System.out.println(storage[num - 1]); // �ֱ��� ������ ��
            }
        } 
        else 
        {
            if(storage[index-1]==0)
            {
                System.out.println(10);
            }
            else
            {
                System.out.println(storage[index - 1]); // �������� 1���� �����ϵ��� ó��

            }
        }
    }
}
