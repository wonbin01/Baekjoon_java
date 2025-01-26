import java.util.*;

public class B15686 
{
    public static int chicken_count=0; //ġŲ�� ����� count
    public static int house_count=0; //�� ����� count
    public static int minTotal=Integer.MAX_VALUE;
    public static void main(String args[])
    {
        //0�� ��ĭ, 1�� ��, 2�� ġŲ��
        //|(r1-r2)| + |(c1-c2)| -> �Ÿ� ���ϴ� ��
        //������ ġŲ �Ÿ��� �ּ�ȭ ���Ѿߵ�
        //n���� ��, �ִ� m���� ġŲ������
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //n*n�� �迭 ����
        int m=sc.nextInt(); //m���� ġŲ���� ���ܵ�
        int[][] city=new int[n][n]; //n*n���� ���ø� ����
        int[][] chicken=new int[20][2]; //ġŲ�� ����Ʈ, ��ġ ����
        int[][] house=new int[100][2]; //�� ����Ʈ, ��ġ ����
        int[][] list=new int[100][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                city[i][j]=sc.nextInt(); //���ø� ������
                if(city[i][j]==2)
                {
                    chicken[chicken_count][0]=i;
                    chicken[chicken_count][1]=j;
                    chicken_count++; //ġŲ�� ����� count�� Ȯ�� ����
                }
                else if(city[i][j]==1)
                {
                    house[house_count][0]=i;
                    house[house_count][1]=j;
                    house_count++; //�� ������ ����� house_count�� Ȯ�� ����
                }
            }
        }
        find_minidistance(chicken, house, 0, m,list,0);
        System.out.println(minTotal);
        sc.close();
    }    
    public static int find_minidistance(int[][] chicken,int[][] house,int cnt,int m,int[][] list, int start)
    {
        if(cnt==m)
        {
            int total=0;
            for(int i=0;i<house_count;i++) //����� ġŲ�� ������ �Ÿ��� ����
            {
                int temp=Integer.MAX_VALUE; //�ӽ� �����ϰ�, �ּ��̸� total�� ��ġ������
                for(int j=0;j<m;j++)
                {
                    int distance=Math.abs(list[j][0]-house[i][0])+Math.abs(list[j][1]-house[i][1]);
                    temp=Math.min(temp,distance);
                }
                total+=temp;
            }
            minTotal=Math.min(minTotal,total);
            return total;
        }
        //chicken list�� ���鼭 m���� �̾ƾ���
        for(int i=start; i<chicken_count;i++)
        {
            list[cnt][0]=chicken[i][0];
            list[cnt][1]=chicken[i][1];
            find_minidistance(chicken, house, cnt+1, m, list, i+1);
        }
        return -1;
    }
}
