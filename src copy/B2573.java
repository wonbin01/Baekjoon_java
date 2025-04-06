import java.io.*;
import java.util.*;

class B2573 
{
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] ice;
    static boolean[][] visited;
    static int r, c;

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        ice = new int[r][c];

        for (int i = 0; i < r; i++) 
        {
            input = br.readLine().split(" ");
            for (int j = 0; j < c; j++) 
            {
                ice[i][j] = Integer.parseInt(input[j]);
            }
        }

        int year = 0;
        while (true) 
        {
            // 빙산 녹이기
            meltIce();
            year++;
            // 빙산이 모두 녹았는지 확인
            if (isAllMelted()) 
            {
                System.out.println(0);
                return;
            }

            // 빙산이 분리되었는지 확인
            if (isSeparated()) 
            {
                System.out.println(year);
                return;
            }
        }
    }

    static void meltIce() 
    {
        int[][] tempIce = new int[r][c];
        for (int i = 1; i < r - 1; i++) 
        {
            for (int j = 1; j < c - 1; j++) 
            {
                if (ice[i][j] > 0) 
                {
                    int seaCount = 0;
                    for (int[] dir : direction) 
                    {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && ice[nx][ny] == 0) 
                        {
                            seaCount++;
                        }
                    }
                    tempIce[i][j] = Math.max(0, ice[i][j] - seaCount);
                }
            }
        }
        ice = tempIce;
    }

    static boolean isAllMelted() 
    {
        for (int i = 1; i < r - 1; i++) 
        {
            for (int j = 1; j < c - 1; j++) 
            {
                if (ice[i][j] > 0) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSeparated() 
    {
        boolean[][] visited = new boolean[r][c];
        int componentCount = 0;

        for (int i = 1; i < r - 1; i++) 
        {
            for (int j = 1; j < c - 1; j++) 
            {
                if (ice[i][j] > 0 && !visited[i][j]) 
                {
                    bfs(i, j, visited);
                    componentCount++;
                    if (componentCount > 1) 
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    static void bfs(int x, int y, boolean[][] visited) 
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) 
        {
            int[] node = queue.poll();
            int cx = node[0], cy = node[1];

            for (int[] dir : direction) 
            {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && ice[nx][ny] > 0) 
                {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}