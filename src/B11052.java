import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B11052 {
    static Map<Integer,Integer> hm = new HashMap<>(); //각 카드팩의 가격
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 구매하려는 카드의 개수
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            hm.put(i+1,Integer.parseInt(input[i]));
        }
        int[] dp = new int[n+1]; // 카드 n장을 사는데 드는 최대 비용
        dp[0]=0;
        dp[1] = hm.get(1);
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + hm.get(j));
            }
        }
        System.out.println(dp[n]);
    }
}