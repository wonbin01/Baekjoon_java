import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<n;i++) {
            String input = br.readLine();
            if(checkGoodString(input)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean checkGoodString(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length();i++) {
            char candidate = input.charAt(i);
            if(stack.isEmpty() || stack.peek() != candidate) {
                stack.push(candidate);
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == candidate) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
