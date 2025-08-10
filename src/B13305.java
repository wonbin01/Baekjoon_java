import java.io.*;
public class B13305 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dist=new long[n-1];
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n-1;i++)
        {
            dist[i]=Long.parseLong(input[i]); //각 도시 사이의 거리
        }
        long[] cost=new long[n];
        input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            cost[i]=Long.parseLong(input[i]); //각 도시에서의 기름 가격
        }
        long totalPrice=0;
        long minPrice=cost[0]; //현재까지 가장 저렴한 기름 가격
        for(int i=0;i<n-1;i++)
        {
            if(cost[i]<minPrice)
            {
                minPrice=cost[i];
            }
            totalPrice+=minPrice*dist[i];
        }
        System.out.println(totalPrice);
    }
}
//지금 도시보다 적은 기름값이 나타나면 멈춤
//지금 도시보다 높은 기름값이면 거리 합침
//지금 도시랑 기름값이 같으면 거리 합침