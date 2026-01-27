import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        solution(input);
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int index = hm.getOrDefault(c, -1);
            hm.put(c, i);
            if(index==-1) {
                answer[i]=-1;
                continue;
            }
            int currentIndex = i-index;
            answer[i]=currentIndex;
        }
        return answer;
    }
}
// "banana"	[-1, -1, -1, 2, 2, 2]
// "foobar"	[-1, -1, 1, -1, -1, -1]