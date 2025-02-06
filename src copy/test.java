import java.io.*;
import java.util.Arrays;

public class test {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]); // 구간 개수
        int target = Integer.parseInt(input[1]); // 목표 길이 합
        int max = 0;
        int[][] number = new int[n][2];

        // 입력 받기 & 최대값 찾기
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            number[i][0] = Integer.parseInt(input[0]);
            number[i][1] = Integer.parseInt(input[1]);
            max = Math.max(max, number[i][1]);
        }

        int start = 0, end = 0;
        int[] find_gap = new int[max + 1]; 
        Arrays.fill(find_gap, Integer.MAX_VALUE); // 배열 초기화

        while (start < max) {
            int result = 0;

            // 현재 start~end 범위에 대해 길이 합 계산
            for (int i = 0; i < n; i++) {
                int temp1 = Math.max(start, number[i][0]);
                int temp2 = Math.min(end, number[i][1]);

                if (temp1 <= temp2) {
                    result += (temp2 - temp1);
                }
            }

            int gap = end - start;

            // 목표 길이와 일치하면 최소 start 값 갱신
            if (result == target) {
                find_gap[gap] = Math.min(find_gap[gap], start);
            }

            // 범위를 조정하는 로직 수정
            if (result < target) { 
                // 부족하면 end 증가
                end++;
            } else { 
                // 길이가 target 이상이면 start 증가
                start++;
            }
        }

        // 최적의 결과 찾기
        for (int i = 0; i <= max; i++) {
            if (find_gap[i] != Integer.MAX_VALUE) {
                sb.append(find_gap[i]).append(" ").append(find_gap[i] + i);
                break;
            }
        }

        System.out.println(sb);
    }
}
