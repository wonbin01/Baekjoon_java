import java.util.Scanner;

public class B15683
{
    public static int cctv_cnt=0; //cctv�� ����
    public static int minBlindSpot = Integer.MAX_VALUE; // �ּ� �簢���� ũ��
    public static int[][] cctvs;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //����
        int m=sc.nextInt(); //����
        int[][] work_place=new int[n][m]; //�繫��
        cctvs=new int[8][3]; //��ġ�� Ÿ�� ����
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                work_place[i][j]=sc.nextInt();
                if(work_place[i][j]>=1&&work_place[i][j]<=5)
                {
                    cctvs[cctv_cnt][0]=i; //cctv�� ��
                    cctvs[cctv_cnt][1]=j; //cctv�� ��
                    cctvs[cctv_cnt][2]=work_place[i][j]; //cctv�� Ÿ��
                    cctv_cnt++; //cctv ���� ����
                }
            }
        }
        Findmin(work_place, 0);
        System.out.println(minBlindSpot);
        sc.close();
    }
    public static void Findmin(int[][] work_place,int cnt)
    {
        int n=work_place.length; //����
        int m=work_place[0].length; //����
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
        //���� ó���ؾ��� cctv
        int x=cctvs[cnt][0];
        int y=cctvs[cnt][1];
        int type=cctvs[cnt][2];
        int[][] newboard;
        if (type == 1) {
            for (int k = 0; k < 4; k++) { // 4 ����
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
                if (k == 0) { // �¿�
                    left_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                } else { // ����
                    up_dir(newboard, x, y);
                    down_dir(newboard, x, y, n);
                }
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 3) {
            for (int k = 0; k < 4; k++) {
                newboard = copyboard(work_place);
                if (k == 0) { // ���
                    up_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                } else if (k == 1) { // ����
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                } else if (k == 2) { // ����
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                } else if (k == 3) { // �»�
                    left_dir(newboard, x, y);
                    up_dir(newboard, x, y);
                }
                Findmin(newboard, cnt + 1);
            }
        } else if (type == 4) {
            for (int k = 0; k < 4; k++) {
                newboard = copyboard(work_place);
                if (k == 0) { // �����
                    up_dir(newboard, x, y);
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                } else if (k == 1) { // ������
                    right_dir(newboard, x, y, m);
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                } else if (k == 2) { // ���»�
                    down_dir(newboard, x, y, n);
                    left_dir(newboard, x, y);
                    up_dir(newboard, x, y);
                } else if (k == 3) { // �»��
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
    public static void up_dir(int[][] work_place,int row,int col) //i,j�� ������
    {
        for(int i=row-1;i>=0;i--)
        {
            if(work_place[i][col]==6) break; //���� ������� break
            else if(work_place[i][col]!=6&&work_place[i][col]==0) //���� �ƴϰ�, ��ĭ�� ���
            {
                work_place[i][col]=-1;
            }
        }
    }
    public static void down_dir(int[][] work_place,int row,int col,int n)
    {
        for(int i=row+1;i<n;i++)
        {
            if(work_place[i][col]==6) break; //���� ���� ��� break
            else if(work_place[i][col]!=6&&work_place[i][col]==0) //���� �ƴϰ�, ��ĭ�� ���
            {
                work_place[i][col]=-1;
            }
        }
    }
    public static void right_dir(int[][] work_place,int row,int col,int m)
    {
        for(int i=col+1;i<m;i++)
        {
            if(work_place[row][i]==6) break; //���� ���� ���
            else if(work_place[row][i]!=6&&work_place[row][i]==0) //���� �ƴϰ�, ��ĭ�� ���
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
