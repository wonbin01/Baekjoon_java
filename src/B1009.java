import java.util.Scanner;

public class B1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수
        
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(); // 숫자 a
            int b = sc.nextInt(); // 제곱할 수 b
            calculate(a, b);
        }
        
        sc.close();
    }

    public static void calculate(int a, int b) {
        int[] storage = new int[10]; // 끝자리 주기를 저장할 배열
        int x = a % 10; // a의 끝자리만 사용
        storage[0] = x;
        int num = 1;

        // a의 끝자리가 반복되는 주기 찾기
        while (true) {
            x = (x * a) % 10; // (x * 이전 값) % 10을 계속 계산
            // 이미 나온 값이 있으면 반복 종료
            for (int i = 0; i < num; i++) {
                if (storage[i] == x) {
                    returnResult(storage, num, b);
                    return;
                }
            }
            if (num == 10) break; // 10번째까지 채워지면 종료
            storage[num] = x; // 새로운 끝자리 저장
            num++;
        }

        // b가 주기 길이(num)를 초과한 경우, 나머지로 컴퓨터 번호를 계산
        returnResult(storage, num, b);
    }

    // 주기의 길이와 b 값에 맞춰 결과를 출력
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
                System.out.println(storage[num - 1]); // 주기의 마지막 값
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
                System.out.println(storage[index - 1]); // 나머지가 1부터 시작하도록 처리

            }
        }
    }
}
