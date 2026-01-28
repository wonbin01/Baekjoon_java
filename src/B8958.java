import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int n = Integer.parseInt(input); //테스트 케이스의 개수
        for(int i=0;i<n;i++) {
            input = br.readLine();
            int length = input.length();
            int relay=0;
            int total=0;
            for(int j=0;j<length;j++) {
                if(input.charAt(j)=='O') {
                    relay++;
                    total+=relay;
                }
                else {
                    relay=0;
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
