import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15829 {
    static int r=31;
    static int M=1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine()); //문자열의 길이
        String input = br.readLine(); // 문자
        long total = 0;
        long pow = 1;
        for(int i=0; i<length; i++){
            int num = input.charAt(i) - 'a' + 1;
            total = (total + num * pow) % M;
            pow = (pow * r) % M;
        }
        System.out.println(total);
    }
}