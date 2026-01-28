import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            String input = br.readLine();
            checkVPS(input);
        }
    }
    static void checkVPS(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length();i++) {
            char candidate = input.charAt(i);
            if(stack.isEmpty()) {
                stack.push(candidate);
                continue;
            }
            if(!stack.isEmpty() && stack.peek()=='(' && candidate==')') {
                stack.pop();
                continue;
            }
            stack.push(candidate);
        }
        if(stack.isEmpty()) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
