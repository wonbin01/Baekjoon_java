import java.io.*;
import java.util.*;

public class B20166 
{
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static Map<String, Integer> map = new HashMap<>();
    static List<String> words = new ArrayList<>(); // 입력된 문자열 순서 저장
    static int n, m, maxLength = 0;
    
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]); // n행
        m = Integer.parseInt(input1[1]); // m열
        int k = Integer.parseInt(input1[2]); // 문자열의 개수
        
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) 
        {
            String input2 = br.readLine();
            for (int j = 0; j < m; j++) 
            {
                board[i][j] = input2.charAt(j);
            }
        }

        for (int i = 0; i < k; i++) 
        {
            String word = br.readLine();
            map.put(word, 0);
            words.add(word);
            maxLength = Math.max(maxLength, word.length()); // 가장 긴 문자열 길이 저장
        }

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                dfs(board, i, j, Character.toString(board[i][j]));
            }
        }

        // 입력 순서대로 결과 출력
        for (String word : words) 
        {
            System.out.println(map.get(word));
        }
    }

    public static void dfs(char[][] board, int x, int y, String current) 
    {
        // 현재 문자열이 map에 있는 경우 개수 추가
        if (map.containsKey(current)) 
        {
            map.put(current, map.get(current) + 1);
        }

        // 현재 문자열의 길이가 최대 길이를 넘으면 중단
        if (current.length() > maxLength) 
        {
            return;
        }

        // 8방향 탐색
        for (int i = 0; i < 8; i++) 
        {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];

            // 경계 체크 및 반대편 이동
            if (nx < 0) nx = n - 1;
            if (nx >= n) nx = 0;
            if (ny < 0) ny = m - 1;
            if (ny >= m) ny = 0;

            // 다음 문자 추가 후 재귀 호출
            dfs(board, nx, ny, current + board[nx][ny]);
        }
    }
}
