import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lockedString = br.readLine(); //암호화된 문자
        int n = Integer.parseInt(br.readLine());
        String[] candidateStrings = new String[n];
        for(int i=0;i<n;i++) {
            candidateStrings[i] = br.readLine();
        }
        for(int i=0;i<=25;i++) {
            String candidate = decodeString(lockedString, i);
            for(String s : candidateStrings) {
                if(candidate.contains(s)) {
                    System.out.println(candidate);
                    return;
                }
            }
        }
    }

    static String decodeString(String lockedString, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lockedString.length();i++) {
            char c = lockedString.charAt(i);
            char moving = (char )((c-'a' + index) % 26 + 'a');
            sb.append(moving);
        }
        return sb.toString();
    }
}
