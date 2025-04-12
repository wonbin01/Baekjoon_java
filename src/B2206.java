import java.io.*;
import java.util.*;
public class B2206 
{
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; //상하좌우
    static int[][] maze;
    static boolean[][][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]); //행
        m=Integer.parseInt(input[1]); //열
        maze=new int[n][m]; //미로의 구조
        visited=new boolean[n][m][2]; //방문 했는지 여부를 저장 
        for(int i=0;i<n;i++)
        {
            String in=br.readLine();
            for(int j=0;j<m;j++)
            {
                int c=in.charAt(j)-'0';
                maze[i][j]=c;
            }
        }
        int steps=bfs();
        System.out.println(steps);
    }
    static int bfs()
    {
        int cnt=1; //몇번 움직이는지 저장
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {0,0,0}); //0이면 벽을 부수지 않음, 1이면 벽을 부숨
        visited[0][0][0]=true;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] node=queue.poll();
                int cx=node[0]; int cy=node[1];
                int wallBroken=node[2];
                if(cx==n-1 && cy==m-1)
                {
                    return cnt;
                }
                for(int j=0;j<4;j++)
                {
                    int nx=cx+direction[j][0]; int ny=cy+direction[j][1];
                    if(nx>=0 && nx<n && ny>=0 && ny<m)
                    {
                        if(!visited[nx][ny][wallBroken] && maze[nx][ny]==0)// 벽을 부수지 않고 이동함
                        {
                            visited[nx][ny][wallBroken]=true;
                            queue.add(new int[] {nx,ny,wallBroken});
                        }

                        if(maze[nx][ny]==1 && wallBroken==0 && !visited[nx][ny][1]) //벽을 부수고 이동함
                        {
                            visited[nx][ny][1]=true;
                            queue.add(new int[] {nx,ny,1});
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
