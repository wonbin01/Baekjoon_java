import java.util.Scanner;

public class B11729 
{
    static StringBuilder sb = new StringBuilder(); // 출력 내용을 저장할 StringBuilder

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n을 입력받음

        // 하노이탑의 최소 이동 횟수
        int result = (int) Math.pow(2, n) - 1; 
        System.out.println(result);

        // 하노이탑 이동 과정 저장
        hanoi(n, 1, 3, 2);

        // 저장된 결과를 한 번에 출력
        System.out.print(sb.toString());
        sc.close();
    }

    // 하노이탑 재귀 함수
    public static void hanoi(int n, int start, int end, int temp)
    {
        if (n == 1) 
        {
            // 가장 작은 디스크를 목적지로 이동 (StringBuilder에 추가)
            sb.append(start).append(" ").append(end).append("\n");
        } 
        else 
        {
            // n-1개의 디스크를 임시 막대로 이동
            hanoi(n - 1, start, temp, end);
            // 가장 큰 디스크를 목적지로 이동
            sb.append(start).append(" ").append(end).append("\n");
            // n-1개의 디스크를 목적지로 이동
            hanoi(n - 1, temp, end, start);
        }
    }
}
