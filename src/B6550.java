import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");
            String candidate = input[0];
            String s = input[1];

            List<Character> list = new ArrayList<>();
            for (int i = 0; i < candidate.length(); i++) {
                list.add(candidate.charAt(i));
            }

            int index = -1;
            int cnt = 0;

            for (char c : list) {
                for (int i = index + 1; i < s.length(); i++) {
                    if (s.charAt(i) == c) {
                        index = i;
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt == list.size()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
