import java.util.Scanner;

public class B15683
{
    public static int cctv_cnt=0; //cctv의 개수
    public static int minBlindSpot = Integer.MAX_VALUE; // 최소 사각지대 크기
    public static int[][] cctvs;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //세로
        int m=sc.nextInt(); //가로
        int[][] work_place=new int[n][m]; //사무실
        cctvs=new int[8][3]; //위치와 타입 저장
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                work_place[i][j]=sc.nextInt();
                if(work_place[i][j]>=1&&work_place[i][j]<=5)
                {
                    cctvs[cctv_cnt][0]=i; //cctv의 행
                    cctvs[cctv_cnt][1]=j; //cctv의 열
                    cctvs[cctv_cnt][2]=work_place[i][j]; //cctv의 타입
                    cctv_cnt++; //cctv 개수 증가
                }
            }
        }
        Findmin(work_place, 0);
        System.out.println(minBlindSpot);
        sc.close();
    }
    public static void Findmin(int[][] work_place,int cnt)
    {
        int n=work_place.length; //가로
        int m=work_place[0].length; //세로
        if(cnt==cctv_cnt)
        {
            int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(work_place[i][j]==0)
                    {
                        count++;
                    }
                }
            }
            minBlindSpot=Math.min(minBlindSpot,count);
            return;
        }
        //현재 처리해야할 cctv
        int x=cctvs[cnt][0];
        int y=cctvs[cnt][1];
        int type=cctvs[cnt][2];
        int[][] newboard;
        if (type == 1) {
            for (int k = 0; k < 4; k++) { // 4 방향
                newboard = copyboard(work_place);
                if (k == 0) up_dir(newboard, x, y);
                else if (k == 1) down_dir(newboard, x, y, n);
                else if (k == 2) left_dir(newboard, x, y);
                else if (k == 3) right_dir(newboard, x, y, m);
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 2) {
            for (int k = 0; k < 2; k++) {
                newboard = copyboard(work_place);
                if (k == 0) { // 좌우
                    left_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                } else { // 상하
                    up_dir(newboard, x, y);
                    down_dir(newboard, x, y, n);
                }
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 3) {
            for (int k = 0; k < 4; k++) {
                newboard = copyboard(work_place);
                if (k == 0) { // 상우
                    up_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                } else if (k == 1) { // 우하
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                } else if (k == 2) { // 하좌
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                } else if (k == 3) { // 좌상
                    left_dir(newboard, x, y);
                    up_dir(newboard, x, y);
                }
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 4) {
            for (int k = 0; k < 4; k++) {
                newboard = copyboard(work_place);
                if (k == 0) { // 상우하
                    up_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                } else if (k == 1) { // 우하좌
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                } else if (k == 2) { // 하좌상
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                    up_dir(newboard, x, y);
                } else if (k == 3) { // 좌상우
                    left_dir(newboard, x, y);
                    up_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                }
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 5) {
            newboard = copyboard(work_place);
            up_dir(newboard, x, y);
            right_dir(newboard, x, y, m);
            down_dir(newboard, x, y, n);
            left_dir(newboard, x, y);
            Findmin(newboard, cnt + 1);
        }
    }
    public static int[][] copyboard(int[][] board) 
    {
        int n = board.length;
        int m=board[0].length;
        int[][] newboard = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                newboard[i][j]=board[i][j];
            }
        }
        return newboard;
    }
    public static void up_dir(int[][] work_place,int row,int col) //i,j를 받을때
    {
        for(int i=row-1;i>=0;i--)
        {
            if(work_place[i][col]==6) break; //벽을 만난경우 break
            else if(work_place[i][col]!=6&&work_place[i][col]==0) //벽이 아니고, 빈칸일 경우
            {
                work_place[i][col]=-1;
            }
        }
    }
    public static void down_dir(int[][] work_place,int row,int col,int n)
    {
        for(int i=row+1;i<n;i++)
        {
            if(work_place[i][col]==6) break; //벽을 만난 경우 break
            else if(work_place[i][col]!=6&&work_place[i][col]==0) //벽이 아니고, 빈칸일 경우
            {
                work_place[i][col]=-1;
            }
        }
    }
    public static void right_dir(int[][] work_place,int row,int col,int m)
    {
        for(int i=col+1;i<m;i++)
        {
            if(work_place[row][i]==6) break; //벽을 만난 경우
            else if(work_place[row][i]!=6&&work_place[row][i]==0) //벽이 아니고, 빈칸인 경우
            {
                work_place[row][i]=-1;
            }
        }
    }
    public static void left_dir(int[][] work_place,int row,int col)
    {
        for(int i=col-1;i>=0;i--)
        {
            if(work_place[row][i]==6) break;
            else if(work_place[row][i]!=6&&work_place[row][i]==0)
            {
                work_place[row][i]=-1;
            }
        }
    }
}
