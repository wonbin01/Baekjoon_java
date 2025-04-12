import java.io.*;

public class B17266 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int m = Integer.parseInt(br.readLine()); // 가로등의 개수
        int[] light = new int[m]; // 가로등의 위치를 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) 
        {
            light[i] = Integer.parseInt(input[i]); // 가로등의 위치
        }

        int max = 0;

        if (m == 1) 
        {
            // 가로등이 하나일 경우, 시작점(0)과 끝점(n) 중 더 먼 거리를 선택
            max = Math.max(light[0] - 0, n - light[0]);
        } else 
        {
            // 첫 번째 가로등과 시작점(0) 사이의 거리
            max = Math.max(max, light[0] - 0);

            // 가로등 간의 간격의 절반 계산
            for (int i = 1; i < m; i++) 
            {
                max = Math.max(max, (light[i] - light[i - 1] + 1) / 2);
            }

            // 마지막 가로등과 끝점(n) 사이의 거리
            max = Math.max(max, n - light[m - 1]);
        }

        System.out.println(max);
    }
}