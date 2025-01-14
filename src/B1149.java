import java.util.*;
import java.io.IOException;
public class B1149 
{
    static int result=Integer.MAX_VALUE;
    static int temp=0;
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] house=new int[n][3]; //rgb칠함
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<3;j++)
            {
                house[i][j]=sc.nextInt(); //집의 페인트 가격을 입력받음
            }
        }
        for(int j=0;j<3;j++)
        {
            visiting(house, 0, j, 0);
        }
        System.out.println(result);
        sc.close();
    }
    public static void visiting(int[][] house,int n,int color,int cost)
    {
        int cnt=house.length;
        if(n==cnt)
        {
            result=Math.min(result,cost);
            return;
        }
        cost+=house[n][color];
        for(int nextcolor=0;nextcolor<3;nextcolor++)
        {
            if(nextcolor!=color)
            {
                visiting(house,n+1,nextcolor,cost);
            }
        }
    }
}
