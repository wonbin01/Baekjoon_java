import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B5525 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n+1개의 I, n개의 O
        int length = Integer.parseInt(br.readLine()); // 문자열의 길이
        String s = br.readLine(); // 문자열
        findPN(s, length, n);
    }

    static void findPN(String s, int length, int n) {
        int count = 0;   // 연속된 IOI 개수
        int answer = 0;

        for (int i = 1; i < length - 1; i++) {
            if (s.charAt(i - 1) == 'I' &&
                s.charAt(i) == 'O' &&
                s.charAt(i + 1) == 'I') {
        count++;
        if (count >= n) answer++;
        i++; // IOI에서 다음 I는 이미 사용했으므로 한 칸 점프
        } else {
            count = 0;
            }
        }
        System.out.println(answer);
        }
    }
