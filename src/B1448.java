import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1448 {
    static int[] straw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1; //가장 긴 삼각형의 길이
        int n = Integer.parseInt(br.readLine()); //빨대의 개수
        straw = new int[n];
        for(int i=0;i<n;i++) {
            straw[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straw);
        for(int i=n-1;i>=2;i--) {
            if(straw[i] < straw[i-1] + straw[i-2]) {
                max = Math.max(max, straw[i] + straw[i-1] + straw[i-2]);
            }
        }
        System.out.println(max);
    }
}
