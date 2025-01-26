import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class B1600
{
    public static final int max=200;
    public static int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public static int[][] horse={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt(); //몇번 움직일 수 있는지
        int w=sc.nextInt(); //가로길이
        int h=sc.nextInt(); //세로길이
        int[][] route=new int[h][w];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                route[i][j]=sc.nextInt(); //0은 평지, 1은 장애물
            }
        }
        int result=bfs(route,k,w,h);
        System.out.println(result);
        sc.close();
    }
    public static int bfs(int[][] route, int k,int w,int h) //bfs적용해서 최소 길이 출력하는 함수
    {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited=new int[h][w][k+1]; //방문한 건지 확인하는 배열
        // 초기화: 방문하지 않은 상태는 -1로 설정
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int l = 0; l <= k; l++) {
                    visited[i][j][l] = -1;
                }
            }
        }
        queue.offer(new int[]{0,0,k,0}); //x,y,remain_k,distance
        visited[0][0][k]=0;
        while(!queue.isEmpty()) //queue가 비어있으면 종료
        {
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];
            int remaink=current[2], distance=current[3];
            if(cx==h-1&&cy==w-1)
            {
                return distance;
            }
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0&&nx<h&&ny>=0&&ny<w&&route[nx][ny]==0&&visited[nx][ny][remaink]==-1)
                {
                    queue.offer(new int[]{nx,ny,remaink,distance+1});
                    visited[nx][ny][remaink]=distance+1;
                }
            }
            if(remaink>0)
            {
                for(int[] move : horse)
                {
                    int nx= cx+move[0];
                    int ny= cy+move[1];
                    if(nx>=0&&nx<h&&ny>=0&&ny<w&&route[nx][ny]==0&&visited[nx][ny][remaink-1]==-1)
                    {
                        queue.offer(new int[]{nx,ny,remaink-1,distance+1});
                        visited[nx][ny][remaink-1]=distance+1;
                    }
                }
            }
        }
        return -1;
    }
}
