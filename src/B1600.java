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
        int k=sc.nextInt(); //��� ������ �� �ִ���
        int w=sc.nextInt(); //���α���
        int h=sc.nextInt(); //���α���
        int[][] route=new int[h][w];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                route[i][j]=sc.nextInt(); //0�� ����, 1�� ��ֹ�
            }
        }
        int result=bfs(route,k,w,h);
        System.out.println(result);
        sc.close();
    }
    public static int bfs(int[][] route, int k,int w,int h) //bfs�����ؼ� �ּ� ���� ����ϴ� �Լ�
    {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited=new int[h][w][k+1]; //�湮�� ���� Ȯ���ϴ� �迭
        // �ʱ�ȭ: �湮���� ���� ���´� -1�� ����
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int l = 0; l <= k; l++) {
                    visited[i][j][l] = -1;
                }
            }
        }
        queue.offer(new int[]{0,0,k,0}); //x,y,remain_k,distance
        visited[0][0][k]=0;
        while(!queue.isEmpty()) //queue�� ��������� ����
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
