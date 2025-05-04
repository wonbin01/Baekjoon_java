import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B28125 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException 
    {
        HashMap<String, String> hm = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n]; // 단어들이 주어짐

        // 특수 문자와 치환 문자 매핑
        hm.put("@", "a");
        hm.put("[", "c"); // '['는 정규 표현식에서 이스케이프 필요
        hm.put("!", "i");
        hm.put(";", "j");
        hm.put("^", "n"); // '^'는 정규 표현식에서 이스케이프 필요
        hm.put("0", "o");
        hm.put("7", "t");
        hm.put("\\\'", "v"); // \'
        hm.put("\\\\\'", "w"); // \\'

        for (int i = 0; i < n; i++) 
        {
            int cnt = 0;
            s[i] = br.readLine();
            for (int j = 0; j < s[i].length(); ) 
            {
                if (j + 2 < s[i].length() && s[i].charAt(j) == '\\' && s[i].charAt(j + 1) == '\\' && s[i].charAt(j + 2) == '\'') 
                {
                    cnt++;
                    j += 3;
                } 
                else if 
                (j + 1 < s[i].length() && s[i].charAt(j) == '\\' && s[i].charAt(j + 1) == '\'') 
                {
                    cnt++;
                    j += 2;
                } 
                else 
                {
                    String k = String.valueOf(s[i].charAt(j));
                    if (hm.containsKey(k)) cnt++;
                    j++;
                }
            }
            s[i] = s[i].replace("\\\\\'", "w");
            s[i] = s[i].replace("\\'", "v");
            for (String k : hm.keySet()) 
            {
                s[i] = s[i].replace(k, hm.get(k));
            }
            int len=s[i].length();
            // 조건에 따라 결과 저장
            if (cnt >= len / 2) {
                sb.append("I don't understand\n");
            } else {
                sb.append(s[i]).append("\n");
            }
           //sb.append(len).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}