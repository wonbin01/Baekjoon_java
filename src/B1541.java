import java.io.*;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minusParts = input.split("-");
        int result = sum(minusParts[0]); // 첫 번째 파트는 그냥 더함
        
        for (int i = 1; i < minusParts.length; i++) {
            result -= sum(minusParts[i]); // 이후는 모두 더한 다음 빼줌
        }

        System.out.println(result);
    }

    private static int sum(String s) {
        String[] tokens = s.split("\\+");
        int total = 0;
        for (String token : tokens) {
            total += Integer.parseInt(token);
        }
        return total;
    }
}
