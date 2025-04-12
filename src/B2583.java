import java.io.*;
import java.util.*;
public class B2583 
{
    static StringBuilder sb=new StringBuilder();
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int m=Integer.parseInt(input[0]); // 세로
        int n=Integer.parseInt(input[1]); // 가로
        int k=Integer.parseInt(input[2]); //사각형 개수
        visited=new boolean[m][n];
        for(int i=0;i<k;i++)
        {
            input=br.readLine().split(" ");
            int lbx=Integer.parseInt(input[0]); //왼쪽 아래 x
            int lby=Integer.parseInt(input[1]); //왼쪽 아래 y
            int rtx=Integer.parseInt(input[2]); //오른쪽 위 x
            int rty=Integer.parseInt(input[3]); //오른쪽 위 y

            visited[m-1-lby][lbx]=true;
            visited[m-1-(rty-1)][rtx-1]=true;

            for(int r=m-rty;r<=m-1-lby;r++)
            {
                for(int c=lbx;c<=rtx-1;c++)
                {
                    visited[r][c]=true;
                }
            }
        }
        LinkedList<Integer> areas=new LinkedList<>();
        int cnt=0; //공간의 개수를 세는 변수
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j])
                {
                    int area=dfs(i,j,m,n);
                    areas.add(area);
                }
            }
        }
        cnt=areas.size(); sb.append(cnt).append("\n");
        Collections.sort(areas);
        for(int size:areas)
        {
            sb.append(size).append(" ");
        }
        System.out.print(sb);
    }
    public static int dfs(int x,int y,int m,int n)
    {
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[] {x,y});
        visited[x][y]=true;
        int area=0;
        while(!stack.isEmpty())
        {
            int[] node=stack.pop();
            int cx=node[0]; int cy=node[1];
            area++;
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<m && ny>=0 && ny<n)
                {
                    if(!visited[nx][ny]) //아직 방문되지 않았다면
                    {
                        visited[nx][ny]=true;
                        stack.push(new int[] {nx,ny});
                    }
                }
            }
        }
        return area;
    }
}
 //lb시리즈는 ((y,x))
 //rt시리즈는 (y-1,x-1)