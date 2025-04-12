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
            if(control[i]==1)
            {
                move_E();
            }
            else if(control[i]==2)
            {
                move_W();
            }
            else if(control[i]==3)
            {
                move_N();
            }
            else if(control[i]==4)
            {
                move_S();
            }
        }
        System.out.print(sb);
    }
    static void move_E()
    {
        if(y<=m-2) //움직일 수 있음
        {
            y=y+1; //이동
            roll(1);
            sb.append(dice[1]).append("\n");
        }
    }
    static void move_W()
    {
        if(y>=1)
        {
            y=y-1;
            roll(2);
            sb.append(dice[1]).append("\n");
        }
    }
    static void move_N()
    {
        if(x>=1)
        {
            x=x-1;
            roll(3);
            sb.append(dice[1]).append("\n");
        }
    }
    static void move_S()
    {
        if(x<=n-2)
        {
            x=x+1;
            roll(4); //주사위를 회전시킴
            sb.append(dice[1]).append("\n");
        }
    }
    static void paint()
    {
        if(map[x][y]==0)
        {
            map[x][y]=dice[6];
        }
        else
        {
            dice[6]=map[x][y];
            map[x][y]=0;
        }
    }
    static void roll(int dir) 
    {
        int[] temp = dice.clone(); // 기존 주사위 상태 저장
        if (dir == 1) { // 동쪽
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (dir == 2) { // 서쪽
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        } else if (dir == 3) { // 북쪽
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else if (dir == 4) { // 남쪽
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
        paint();
    }
    
}

// 이동한 칸에 쓰여있는 수가 0이면, 주사위의 바닥면에 쓰여진 값이 바닥면에 복사
// 0이아닌경우, 칸에 쓰여진 수가 주사위의 바닥면을 복사 + 칸에 쓰여진 수는 0
//동=1, 서=2, 북=3, 남=4