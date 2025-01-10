import java.util.Scanner;

public class B15683 
{
    public static int cctv_cnt=0; //cctv의 개수
    public static int minBlindSpot = Integer.MAX_VALUE; // 최소 사각지대 크기
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //세로
        int m=sc.nextInt(); //가로
        int[][] work_place=new int[n][m]; //사무실
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                work_place[i][j]=sc.nextInt();
                if(work_place[i][j]!=0&&work_place[i][j]!=6)
                {
                    cctv_cnt++;
                }
            }
        }
        Findmin(work_place, 0);
        System.out.println(minBlindSpot);

        sc.close();
    }
    public static int Findmin(int[][] work_place,int cnt)
    {
        int n=work_place.length;
        int m=work_place[0].length;
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
            return count;
        }
        int[][] newboard=copyboard(work_place);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(work_place[i][j]==1) //cctv 1번(한쪽 방향)
                {
                    for(int k=0;k<4;k++)
                    {
                        if(k==0)
                        {
                            up_dir(newboard, i, j);
                        }
                        else if(k==1)
                        {
                            down_dir(newboard, i, j, n);
                        }
                        else if(k==2)
                        {
                            left_dir(newboard, i, j);
                        }
                        else if(k==3)
                        {
                            left_dir(newboard, i, j);
                        }
                        Findmin(newboard, cnt+1);
                    }
                }
                else if(work_place[i][j]==2) //cctv 2번(반대방향)
                {
                    for(int k=0;k<2;k++)
                    {
                        if(k==0)
                        {
                            left_dir(newboard, i, j);
                            right_dir(newboard, i, j, m);
                        }
                        else
                        {
                            up_dir(newboard, i, j);
                            down_dir(newboard, i, j, n);
                        }
                    }
                    Findmin(newboard, cnt+1);
                }
                else if(work_place[i][j]==4) //cctv 4번(3방향)
                {
                    for(int k=0;k<4;k++)
                    {
                        if(k==0)
                        {
                            up_dir(newboard, i, j);
                            right_dir(newboard, i, j, m);
                            down_dir(newboard, i, j, n);
                        }
                        else if(k==1)
                        {
                            right_dir(newboard, i, j, m);
                            down_dir(newboard, i, j, n);
                            left_dir(newboard, i, j);
                        }
                        else if(k==2)
                        {
                            down_dir(newboard, i, j, n);
                            left_dir(newboard, i, j);
                            up_dir(newboard, i, j);
                        }
                        else if(k==3)
                        {
                            left_dir(newboard, i, j);
                            up_dir(newboard, i, j);
                            right_dir(newboard, i, j, m);
                        }
                    }
                    Findmin(newboard, cnt+1);
                }
                else if(work_place[i][j]==3) //cctv 3번(수직방향)
                {
                    for(int k=0;k<4;k++)
                    {
                        if(k==0)
                        {
                            up_dir(newboard, i, j);
                            right_dir(newboard, i, j, m);
                        }
                        else if(k==1)
                        {
                            right_dir(newboard, i, j, m);
                            down_dir(newboard, i, j, n);
                        }
                        else if(k==2)
                        {
                            down_dir(newboard, i, j, n);
                            left_dir(newboard, i, j);
                        }
                        else if(k==3)
                        {
                            left_dir(newboard, i, j);
                            up_dir(newboard, i, j);
                        }
                    }
                    Findmin(newboard, cnt+1);
                }
                else if(work_place[i][j]==5) //cctv 5번(4방향)
                {
                    up_dir(newboard, i, j);
                    right_dir(newboard, i, j, m);
                    down_dir(newboard, i, j, n);
                    left_dir(newboard, i, j);
                    Findmin(newboard, cnt+1);
                }
            }
        }
        return -1;
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
        for(int i=0;i<row;i++)
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
        for(int i=0;i<col;i++)
        {
            if(work_place[row][i]==6) break;
            else if(work_place[row][i]!=6&&work_place[row][i]==0)
            {
                work_place[row][i]=-1;
            }
        }
    }
}
