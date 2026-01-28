import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        String[] candidate = new String[n];
        for(int i=0;i<n;i++) {
            candidate[i] = br.readLine();
            if(groupToken(candidate[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean groupToken(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char candidate = s.charAt(i);
            if(hm.get(candidate)==null) {
                hm.putIfAbsent(candidate, i);
                continue;
            }
            int index = hm.get(candidate);
            if(Math.abs(index-i)>1) {
                return false;
            }
            hm.put(candidate, i);
        }
        return true;
    }
}
// aba, abab