import java.io.*;
import java.util.*;

public class B2457 {
    static int sm = 3, sd = 1, em = 12, ed = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][2]; // [시작날짜, 종료날짜]

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) * 100 + Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]) * 100 + Integer.parseInt(input[3]);
            flowers[i][0] = start;
            flowers[i][1] = end;
        }

        Arrays.sort(flowers, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int cnt = 0;
        int idx = 0;
        int current = 301;
        int max = 0;

        while (current < 1201) 
        {
            boolean found = false;
            while (idx < n && flowers[idx][0] <= current) {
                if (flowers[idx][1] > max) {
                    max = flowers[idx][1];
                    found = true;
                }
                idx++;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            current = max;
            cnt++;
        }

        System.out.println(cnt);
    }
}
