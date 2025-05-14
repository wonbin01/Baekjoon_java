import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B28125 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hm = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 특수 문자 → 알파벳 매핑
        hm.put("@", "a");
        hm.put("[", "c");
        hm.put("!", "i");
        hm.put(";", "j");
        hm.put("^", "n");
        hm.put("0", "o");
        hm.put("7", "t");

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            int cnt = 0;

            for (int j = 0; j < input.length(); ) {
                // \\' → w
                if (j + 2 < input.length() && input.charAt(j) == '\\' && input.charAt(j + 1) == '\\' && input.charAt(j + 2) == '\'') {
                    result.append('w');
                    cnt++;
                    j += 3;
                }
                // \' → v
                else if (j + 1 < input.length() && input.charAt(j) == '\\' && input.charAt(j + 1) == '\'') {
                    result.append('v');
                    cnt++;
                    j += 2;
                }
                // 특수문자 → 알파벳
                else {
                    String ch = String.valueOf(input.charAt(j));
                    if (hm.containsKey(ch)) {
                        result.append(hm.get(ch));
                        cnt++;
                    } else {
                        result.append(ch);
                    }
                    j++;
                }
            }

            int len = result.length();

            if (cnt >= (len + 1) / 2) { // 절반 이상이면 이해 못함
                sb.append("I don't understand\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }
}
