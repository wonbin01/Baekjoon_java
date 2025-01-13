import java.util.*;

public class test
{
    public static int index = 0;
    public static int max = 0;
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] number = new long[n]; // 배열 크기를 n으로 설정
        for (int i = 0; i < n; i++)
        {
            number[i] = sc.nextLong(); // long 타입의 값 입력
        }
        Arrays.sort(number); // 오름차순으로 정렬
        
        int cnt = 1;
        for (int i = 1; i < n; i++) // 숫자 개수 카운트
        {
            if (number[i] == number[i - 1]) // 이전 숫자와 같다면
            {
                cnt++;
            }
            else
            {
                if (cnt > max)
                {
                    max = cnt;
                    index = i - 1; // 최빈값 인덱스 업데이트
                }
                cnt = 1; // 카운트 리셋
            }
        }
        
        // 마지막 그룹도 체크
        if (cnt > max)
        {
            max = cnt;
            index = n - 1;
        }
        
        System.out.println(number[index]); // 최빈값 출력
        sc.close();
    }
}
