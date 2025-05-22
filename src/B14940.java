import java.io.*;
import java.util.*;
public class B14940 
{
    static Queue<Node> queue=new LinkedList<>();
    static int[][] dir=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //세로
        int m=Integer.parseInt(input[1]); //가로
        int target_row=0; int target_col=0;
        int[][] map=new int[n][m];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==2)
                {
                    target_row=i; target_col=j;
                }
            }
        }
        int[][] result=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) result[i][j]=-1;
        }
        queue.add(new Node(target_row, target_col, 0));
        result[target_row][target_col]=0;
        while(!queue.isEmpty())
        {
            Node temp=queue.poll();
            int cx=temp.row; int cy=temp.col;
            for(int i=0;i<4;i++)
            {
                int nx=cx+dir[i][0]; int ny=cy+dir[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1 &&result[nx][ny]==-1)
                {
                    result[nx][ny]=temp.move+1;
                    queue.add(new Node(nx, ny, temp.move+1));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(map[i][j]==0)
                {
                    sb.append(0).append(" ");
                }
                else sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static class Node 
    {
        int row=0; int col=0; int move=0;
        Node(int row,int col,int move)
        {
            this.row=row;
            this.col=col;
            this.move=move;
        }
    }
}
