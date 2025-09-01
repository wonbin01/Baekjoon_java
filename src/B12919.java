import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        Queue<String> queue = new LinkedList<>();
        queue.add(t);
        
        int ans = 0;
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (current.equals(s)) {
                ans = 1;
                break;
            }

            if (current.length() <= s.length()) {
                continue;
            }

            // 역연산 1: 마지막이 'A'일 때
            if (current.charAt(current.length() - 1) == 'A') {
                queue.add(current.substring(0, current.length() - 1));
            }
            
            // 역연산 2: 첫 번째가 'B'일 때
            if (current.charAt(0) == 'B') {
                StringBuilder sb = new StringBuilder(current);
                sb.reverse();
                queue.add(sb.substring(0, sb.length() - 1).toString());
            }
        }
        System.out.println(ans);
    }
}