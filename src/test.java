import java.util.*;

public class test
{
    public static int index = 0;
    public static int max = 0;
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] number = new long[n]; // �迭 ũ�⸦ n���� ����
        for (int i = 0; i < n; i++)
        {
            number[i] = sc.nextLong(); // long Ÿ���� �� �Է�
        }
        Arrays.sort(number); // ������������ ����
        
        int cnt = 1;
        for (int i = 1; i < n; i++) // ���� ���� ī��Ʈ
        {
            if (number[i] == number[i - 1]) // ���� ���ڿ� ���ٸ�
            {
                cnt++;
            }
            else
            {
                if (cnt > max)
                {
                    max = cnt;
                    index = i - 1; // �ֺ� �ε��� ������Ʈ
                }
                cnt = 1; // ī��Ʈ ����
            }
        }
        
        // ������ �׷쵵 üũ
        if (cnt > max)
        {
            max = cnt;
            index = n - 1;
        }
        
        System.out.println(number[index]); // �ֺ� ���
        sc.close();
    }
}
