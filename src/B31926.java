import java.io.*;

public class B31926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long count = 0;
        long cur = n;

        while (cur > 1) {
            if (cur % 2 == 0) cur /= 2;
            else cur -= 1;
            count++;
        }

        System.out.println(8 + count + 2);
    }
}
