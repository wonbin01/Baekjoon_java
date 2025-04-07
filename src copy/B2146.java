import java.io.*;
import java.util.*;
public class B2146 
{
    static StringBuilder sb=new StringBuilder();
    static int[][] map; //지도, 0은 바다, 다른숫자는 육지에 해당
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    static int island_cnt=1;
    static boolean[][] visited;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        visited=new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                map[i][j]=Integer.parseInt(input[j]); //map을 만드는 과정
            }
        }
        for(int i=0;i<n;i++) //섬의 개수가 몇개인지 확인
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j] && map[i][j]==1) //아직 방문되지 않은 경우
                {
                    bfs_To_Island_cnt(i, j);
                    island_cnt++;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(map[i][j]!=0)
                {
                    int current_island=map[i][j];
                    for(int k=0;k<4;k++)
                    {
                        int cx=i+direction[k][0];
                        int cy=j+direction[k][1];
                        if(cx>=0 && cx<n && cy>=0 && cy<n)
                        {
                            if(map[cx][cy]==0)
                            {
                                min=Math.min(min,bfs(cx, cy,current_island));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
    static void bfs_To_Island_cnt(int x,int y)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y]=true; map[x][y]=island_cnt;
        while(!queue.isEmpty()) 
        {
            int[] node=queue.poll();
            int cx=node[0]; int cy=node[1];
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n)
                {
                    if(!visited[nx][ny] && map[nx][ny]==1) //방문되지 않은 상태
                    {
                        visited[nx][ny]=true;
                        map[nx][ny]=island_cnt;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }    
        }
    }
    static int bfs(int x,int y,int current_island)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        boolean[][] v=new boolean[n][n];
        v[x][y]=true;
        int cnt=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int j=0;j<size;j++)
            {
                int[] node=queue.poll();
                int cx=node[0]; int cy=node[1];
                for(int i=0;i<4;i++)
                {
                    int nx=cx+direction[i][0];
                    int ny=cy+direction[i][1];
                    if(nx>=0 && nx<n && ny>=0 && ny<n)
                    {
                        if(!v[nx][ny] && map[nx][ny]==0)
                        {
                            v[nx][ny]=true;
                            queue.add(new int[] {nx,ny});
                        }
                        if(map[nx][ny]!=0 && map[nx][ny]!=current_island) //다른 섬에 도착한 경우
                        {
                            return cnt;
                        }
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
