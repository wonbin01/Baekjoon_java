import java.io.*;

public class B9466 
{
    static int[] students;
    static boolean[] visited;
    static boolean[] done;
    static int count;

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) 
        {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) 
            {
                students[i] = Integer.parseInt(input[i - 1]);
            }

            for (int i = 1; i <= n; i++) 
            {
                if (!done[i]) 
                {
                    dfs(i);
                }
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int node) 
    {
        visited[node] = true;
        int next = students[node];

        if (!visited[next]) 
        {
            dfs(next);
        } 
        else if (!done[next]) 
        {
            // 사이클 발생
            int cur = next;
            while (cur != node) 
            {
                count++;
                cur = students[cur];
            }
            count++; // 자기 자신도 포함
        }

        done[node] = true; // 이 노드에 대한 처리가 끝났음
    }
}
