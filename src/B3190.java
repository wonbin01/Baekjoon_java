import java.io.*;
import java.util.*;
public class B3190 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //보드의 크기
        int k=Integer.parseInt(br.readLine()); //사과의 개수
        int head_row=0; int head_col=0; //머리의 행,열
        int tail_row=0; int tail_col=0; //꼬리의 행,열
        int time=0; //경과 시간
        char direction='R'; //처음 이동방향은 R
        char tail_direction='R'; //꼬리의 이동방향
        int[][] board=new int[n][n]; //초기값은 다 0
        Queue<int[]> tail_direction_Info=new LinkedList<>();
        for(int i=0;i<k;i++)
        {
            String[] input=br.readLine().split(" ");
            int row=Integer.parseInt(input[0]); //사과의 행
            int col=Integer.parseInt(input[1]); //사과의 열
            board[row-1][col-1]=-1; //-1이면 사과 있는 곳
        }
        int l=Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        Queue<String[]> direction_info=new LinkedList<>(); //뱀의 방향 전환 정보, [0]이 끝난 이후에 방향 전환
        for(int i=0;i<l;i++)
        {
            String[] input=br.readLine().split(" ");
            direction_info.add(input);
        }
        board[0][0]=1;
        while(true)
        {
            time++; //시간 먼저 증가시킴
            int rotateTime=0;
            if(!direction_info.isEmpty()) rotateTime=Integer.parseInt(direction_info.peek()[0]);
            //먼저 이동방향으로 이동 -> R, L, U, D
            int[] candidate_head=direction_calculate(direction, head_row, head_col);
            head_row=candidate_head[0]; head_col=candidate_head[1];
            //벽이나 자기자신에게 부딪히면 게임 끝
            if(head_row<0 || head_row >=n || head_col<0 || head_col >=n) break; //벽을 벗어나는 경우 게임 끝
            if(board[head_row][head_col]==1) break; //이동한 부분이 자기 자신인 경우 게임 끝
            //사과가 있으면, 사과 사라지고, 꼬리는 그대로
            if(board[head_row][head_col]==-1) //사과를 먹은 경우
            {
                board[head_row][head_col]=1;
            }
            //사과 없으면, 몸길이 줄이고, 꼬리는 이동방향으로 이동
            if(board[head_row][head_col]==0)
            {
                board[head_row][head_col]=1;
                if(!tail_direction_Info.isEmpty() && tail_row==tail_direction_Info.peek()[0] && tail_col==tail_direction_Info.peek()[1])
                {
                    int[] newTail=tail_direction_Info.poll();
                    char newTailDirection=(char) newTail[2];
                    tail_direction=head_direction(tail_direction, newTailDirection);
                }
                board[tail_row][tail_col]=0; 
                int[] Tailnew=direction_calculate(tail_direction, tail_row, tail_col);
                tail_row=Tailnew[0]; tail_col=Tailnew[1];
            }
            if(rotateTime==time) //회전하는 시간이 현재 시간과 같은 경우
            {
                String[] newInfo=direction_info.poll();
                char direc=newInfo[1].toCharArray()[0];
                char newDirection=head_direction(direction, direc);
                direction=newDirection;
                tail_direction_Info.add(new int[] {head_row,head_col,direc});
            }
        }
        System.out.println(time);
    }
    static int[] direction_calculate(char direction, int head_row, int head_col)
    {
        if(direction=='R') head_col++;
        if(direction=='L') head_col--;
        if(direction=='U') head_row--;
        if(direction=='D') head_row++;
        return new int[] {head_row,head_col};
    }
    static char head_direction(char currentDirection, char nextDirection)
    {
        if(currentDirection=='R')
        {
            if(nextDirection=='D') return 'D';
            if(nextDirection=='L') return 'U';
        }
        if(currentDirection=='L')
        {
            if(nextDirection=='D') return 'U';
            if(nextDirection=='L') return 'D';
        }
        if(currentDirection=='U')
        {
            if(nextDirection=='D') return 'R';
            if(nextDirection=='L') return 'L';
        }
        if(currentDirection=='D')
        {
            if(nextDirection=='D') return 'L';
            if(nextDirection=='L') return 'R';
        }
        return 'X';
    }
}