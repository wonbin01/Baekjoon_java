import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        solution(input,n);
    }
    public static String solution(String s, int n) {
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c==' ') {
                sb.append(" ");
                continue;
            }
            if(c>='a' && c<='z') {
                char shifted = (char)((c - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            }
            else if(c>='A' && c<='Z') {
                char shifted = (char)((c-'A'+n) % 26 +'A');
                sb.append(shifted);
            }
        }
        return sb.toString();
    }
}