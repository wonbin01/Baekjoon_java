import java.io.*;
import java.util.*;

public class B4949 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while (true) 
        {
            input = br.readLine();
            if (input.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } 
                else if (ch == ')') 
                {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } 
                    else 
                    {
                        isBalanced = false;
                        break;
                    }
                } 
                else if (ch == ']') 
                {
                    if (!stack.isEmpty() && stack.peek() == '[') 
                    {
                        stack.pop();
                    } 
                    else 
                    {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) 
            {
                sb.append("yes\n");
            } 
            else 
            {
                sb.append("no\n");
            }
        }

        System.out.print(sb);
    }
}
