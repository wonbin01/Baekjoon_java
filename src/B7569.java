import java.io.*;
import java.util.*;
public class B7569 
{
    static int[][][] box;
    static int[][] direction = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}}; //같은 층에서 영향을 미침
    static int[] floor=new int[] {1,-1}; //다른 층에 영향을 미침
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int m=Integer.parseInt(input[0]); //상자의 가로
        int n=Integer.parseInt(input[1]); //상자의 세로
        int h=Integer.parseInt(input[2]); //높이
        box=new int[h][n][m]; //높이,세로,가로 순서
        for(int i=0;i<h;i++) //가장 밑에 있는 상자부터 시작
        {
            for(int j=0;j<n;j++) //세로로
            {
                input=br.readLine().split(" ");
                for(int k=0;k<m;k++) //가로로
                {
                    box[i][j][k]=Integer.parseInt(input[k]);
                }
            }
        }
        Queue<int[]> queue=new LinkedList<>(); //익은 토마토 집어 넣음
        int non=0;
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<m;k++)
                {
                    if(box[i][j][k]==1) //해당 위치에 익은 토마토가 있는 경우
                    {
                        queue.add(new int[] {i,j,k}); //층,세로,가로 순으로 입력
                    }
                    else if(box[i][j][k]==0)
                    {
                        non++;
                    }
                }
            }
        }
        if(non==0) //이미 다 익어있는 경우
        {
            System.out.println(0);
            return;
        }
        int rippenDay=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int r=0;r<size;r++)
            {
                int[] node=queue.poll();
                int height=node[0]; int row=node[1]; int col=node[2];
                for(int i=0;i<4;i++)
                {
                    int nx=row+direction[i][0]; int ny=col+direction[i][1];
                    if(nx>=0 && nx<n && ny>=0 && ny<m)
                    {
                        if(box[height][nx][ny]==0) //익지 않은 토마토라면
                        {
                            box[height][nx][ny]=1; //익음 처리
                            int[] rippen=new int[] {height,nx,ny};
                            non--;
                            queue.add(rippen);
                        }
                    }
                }
                for(int i=0;i<2;i++)
                {
                    int nz=height+floor[i];
                    if(nz>=0 && nz<h)
                    {
                        if(box[nz][row][col]==0) //익지 않은 토마토라면
                        {
                            box[nz][row][col]=1; //익음 처리
                            int[] rippen=new int[] {nz,row,col};
                            non--;
                            queue.add(rippen);
                        }
                    }
                }
            }
            rippenDay++;
        }
        if(non>0)
        {
            System.out.println(-1);
        }
        else System.out.println(rippenDay-1);
    }
}
// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 빈자리리
//이미 토마토가 다 익어있는 상태 : 0 출력
// 토마토가 다 익지 못하는 상태 : -1 출력력