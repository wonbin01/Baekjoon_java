import java.io.*;
public class B14499 
{
    static StringBuilder sb=new StringBuilder();
    static int[] dice=new int[7]; //주사위의 위치에 쓰여진 숫자
    static int current=6; //바닥에 위치한 주사위의 위치
    static int x;
    static int y;
    static int[][] map;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]); //지도의 세로 크기
        m=Integer.parseInt(input[1]); //지도의 가로 크기
        x=Integer.parseInt(input[2]); //주사위 놓은 곳의 좌표 x
        y=Integer.parseInt(input[3]); //주사위 놓은 곳의 좌표 y
        int k=Integer.parseInt(input[4]); //명령의 개수
        map=new int[n][m]; //지도도
        int[] control=new int[k]; //명령이 주어짐 
        // 1-6 , 3-4 , 2-5 
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }
        input=br.readLine().split(" ");
        for(int i=0;i<k;i++)
        {
            control[i]=Integer.parseInt(input[i]); //명령이 순서대로 주어짐
        }
        for(int i=0;i<k;i++)
        {
            int simul=control[i];
           rolling(simul);
        }
        System.out.println(sb);
    }
    static void rolling(int simul)
    {
        if(simul==1) //동쪽으로 옮기는 경우
        {
            if(x<m-1) //움직일 수 있음음
            {
                x=x+1;
                if(current==1 || current==2 || current==5 || current==6)
            {
                
                    int floor=3;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[4]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[4]).append("\n");
                    }
                    current=floor;
            }
            else if(current==3) //바닥이 3
            {             
                    int floor=6;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[1]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[1]).append("\n");
                    }
                    current=floor;
            }
            else if(current==4) //바닥이 1인 경우
            {
                    int floor=1;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[6]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[6]).append("\n");
                    }
                    current=floor;
            }
            }
            
        }
        else if(simul==2) //서쪽으로 옮기는 경우
        {
            if(x>0) //움직여도 됨
            {
                x=x-1;
                if(current==1 || current==2 || current==5 || current==6)
            {
                    int floor=4;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[3]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[3]).append("\n");
                    }
                    current=floor;
            }
            else if(current==4)
            {
                    int floor=6;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[1]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[1]).append("\n");
                    }
                    current=floor;
            }
            else if(current==3)
            {
                    int floor=1;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[6]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[6]).append("\n");
                    }
                    current=floor;
            }
            }
        }
        else if(simul==3)
        {
            if(y>0)
            {
                y=y-1;
                if(current==1 || current==3 || current==4)
            {
                    int floor=2;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[5]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[5]).append("\n");
                    }
                    current=floor;
            }
            else if(current==2)
            {

                    int floor=6;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[1]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[1]).append("\n");
                    }
                    current=floor;
            }
            else if(current==5)
            {
                    int floor=1;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[6]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[6]).append("\n");
                    }
                    current=floor;
            }
            else if(current==6)
            {
                    int floor=5;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[2]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[2]).append("\n");
                    }
                    current=floor;
            }
            }
        }
        else if(simul==4) //남쪽으로 굴림
        {
            if(y<n-1)
            {
                y=y+1;
                if(current==1 || current==3 || current==4)
            {
                    int floor=5;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[2]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[2]).append("\n");
                    }
                    current=floor;
            }
            else if(current==2)
            {
                    int floor=1;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[6]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[6]).append("\n");
                    }
                    current=floor;
            }
            else if(current==5)
            {
                    int floor=6;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[1]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[1]).append("\n");
                    }
                    current=floor;
            }
            else if(current==6)
            {
                    int floor=2;
                    if(map[y][x]==0)
                    {
                        map[y][x]=dice[floor];
                        sb.append(dice[5]).append("\n");
                    }
                    else
                    {
                        dice[floor]=map[y][x];
                        map[y][x]=0;
                        sb.append(dice[5]).append("\n");
                    }
                    current=floor;
            }
            }
        }
    }
}

// 이동한 칸에 쓰여있는 수가 0이면, 주사위의 바닥면에 쓰여진 값이 바닥면에 복사
// 0이아닌경우, 칸에 쓰여진 수가 주사위의 바닥면을 복사 + 칸에 쓰여진 수는 0
//동=1, 서=2, 북=3, 남=4