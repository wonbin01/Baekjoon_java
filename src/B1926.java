import java.io.*;
import java.util.*;
public class B1926 
{
    static int[][] map;
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        map=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }
        int drawing=0; int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(map[i][j]==1 && !visited[i][j])
                {
                    max=Math.max(max,dfs(i,j,n,m));
                    drawing++;
                }
            }
        }
        System.out.println(drawing);
        System.out.println(max);
    }
    static int dfs(int x,int y,int n,int m)
    {
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[] {x,y});
        visited[x][y]=true;
        int size=1;
        while(!stack.isEmpty())
        {
            int[] temp=stack.pop();
            int cx=temp[0]; int cy=temp[1];
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1 && !visited[nx][ny])
                {
                    visited[nx][ny]=true;
                    stack.push(new int[] {nx,ny});
                    size++;
                }
            }
        }
        return size;
    }
}
