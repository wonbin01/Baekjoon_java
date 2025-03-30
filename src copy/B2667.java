import java.io.*;
import java.util.*;
public class B2667 
{
    static StringBuilder sb=new StringBuilder();
    static int[][] house;
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //지도의 크기
        house=new int[n][n];
        visited=new boolean[n][n];
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String input=br.readLine();
            for(int j=0;j<n;j++)
            {
                house[i][j]=input.charAt(j)-'0';
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(house[i][j]==1 && !visited[i][j]) //아직 방문되지 않은 경우
                {
                    int cnt=bfs(i,j,n);
                    al.add(cnt);
                }
            }
        }
        sb.append(al.size()).append("\n");
        Collections.sort(al);
        for(int c : al)
        {
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
    static int bfs(int x,int y,int n)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        int cnt=0;
        visited[x][y]=true;
        while(!queue.isEmpty())
        {
            int[] node=queue.poll();
            int cx=node[0]; int cy=node[1];
            cnt++;
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n)
                {
                    if(!visited[nx][ny] && house[nx][ny]==1)
                    {
                        visited[nx][ny]=true;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
        return cnt;
    }
}
