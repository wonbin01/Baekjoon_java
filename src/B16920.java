import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class B16920 
{
    public static int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt(); //세로
        int w=sc.nextInt(); //가로
        int p=sc.nextInt(); //플레이어 숫자
        int[] S=new int[p]; //플레이어가 움직일 수 있는 칸의 수
        for(int i=0;i<p;i++)
        {
            S[i]=sc.nextInt(); //플레이어가 움직이는 칸의 수 저장
        }
        String[][] route=new String[h][w]; //격자판 입력받음
        for(int i=0;i<h;i++)
        {
            String line=sc.next();
            for(int j=0;j<w;j++)
            {
                route[i][j]=String.valueOf(line.charAt(j));
            }
        }
        int result=1;
        while(result!=0)
        {
            result=bfs(route,S,h,w,p);
        }
        int[] Final=new int[p];
        for(int i=0;i<p;i++)
        {
            Final[i]=-1;
        }
        for(int player=0;player<p;player++)
        {
            for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(route[i][j].equals(String.valueOf(player+1)))
                {
                    Final[player]++;
                }
            }
        }
        }
        for(int i=0;i<p;i++)
        {
            if(Final[i]!=-1)
            {
                System.out.print(Final[i]+1);
                System.out.print(" ");
            }
        }
        sc.close();
    }
    public static int bfs(String[][] route,int[] S,int h,int w,int p)
    {
        int change=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int player=0;player<p;player++)
        {
            for(int i=0;i<h;i++)
            {
                for(int j=0;j<w;j++)
                {
                    if(route[i][j].equals(String.valueOf(player+1)))
                    {
                        queue.offer(new int[]{i,j,player,S[player]});
                    }
                }
            }
        
        while(!queue.isEmpty())
        {
            int[] coordinate=queue.poll();
            int cx=coordinate[0];
            int cy=coordinate[1];
            int play=coordinate[2];
            int remain=coordinate[3];
            if(remain==0) continue;

                for(int i=0;i<4;i++)
                {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0&&nx<h&&ny>=0&&ny<w&&route[nx][ny].equals(".")&&remain>0)
                {
                    route[nx][ny]=String.valueOf(play+1);
                    queue.offer(new int[]{nx,ny,play,remain-1});
                    change++;
                }
                }
        }
    }
        return change;
    }
}
