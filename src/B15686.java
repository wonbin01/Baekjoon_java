import java.util.*;

public class B15686 
{
    public static int chicken_count=0; //치킨집 몇개인지 count
    public static int house_count=0; //집 몇개인지 count
    public static int minTotal=Integer.MAX_VALUE;
    public static void main(String args[])
    {
        //0은 빈칸, 1은 집, 2는 치킨집
        //|(r1-r2)| + |(c1-c2)| -> 거리 구하는 법
        //도시의 치킨 거리를 최소화 시켜야됨
        //n개의 줄, 최대 m개의 치킨집유지
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //n*n의 배열 생성
        int m=sc.nextInt(); //m개의 치킨집만 남겨둠
        int[][] city=new int[n][n]; //n*n개의 도시를 생성
        int[][] chicken=new int[20][2]; //치킨집 리스트, 위치 저장
        int[][] house=new int[100][2]; //집 리스트, 위치 저장
        int[][] list=new int[100][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                city[i][j]=sc.nextInt(); //도시를 생성함
                if(city[i][j]==2)
                {
                    chicken[chicken_count][0]=i;
                    chicken[chicken_count][1]=j;
                    chicken_count++; //치킨집 몇개인지 count로 확인 가능
                }
                else if(city[i][j]==1)
                {
                    house[house_count][0]=i;
                    house[house_count][1]=j;
                    house_count++; //집 개수가 몇개인지 house_count로 확인 가능
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
            for(int i=0;i<house_count;i++) //집들과 치킨집 사이의 거리를 구함
            {
                int temp=Integer.MAX_VALUE; //임시 저장하고, 최소이면 total에 합치도록함
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
        //chicken list를 돌면서 m개를 뽑아야함
        for(int i=start; i<chicken_count;i++)
        {
            list[cnt][0]=chicken[i][0];
            list[cnt][1]=chicken[i][1];
            find_minidistance(chicken, house, cnt+1, m, list, i+1);
        }
        return -1;
    }
}
