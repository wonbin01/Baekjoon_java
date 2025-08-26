import java.io.*;
import java.util.Arrays;
public class B1446 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); // 지름길의 개수
        int d=Integer.parseInt(input[1]);  // 고속도로의 길이
        int[][] shortCut_info=new int[n][3];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]); //지름길 시작 위치
            int end=Integer.parseInt(input[1]); //지름길 종료 위치
            int length=Integer.parseInt(input[2]); //지름길의 길이
            if(length>end-start) continue;
            shortCut_info[i][0]=start;
            shortCut_info[i][1]=end;
            shortCut_info[i][2]=length;
        }
        //고속도로의 시작 위치를 기준으로 정렬 + 시작위치가 같은 경우 종료 위치를 기준으로 정렬
        Arrays.sort(shortCut_info,(a,b) ->
        {
            if(a[0]==b[0])
            {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] dp=new int[10000]; //해당 위치까지의 최솟값을 저장
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<d;i++)
        {
            dp[i+1]=Math.min(dp[i+1], dp[i]+1); //먼저 그냥 도로를 이동하는 경우
            for(int j=0;j<n;j++)
            {
                int start=shortCut_info[j][0];
                int end=shortCut_info[j][1];
                int length=shortCut_info[j][2];

                if(i==start && end<=d) //시작점이 현재 위치와 같고, 도착지가 d 이하인경우
                {
                    dp[end]=Math.min(dp[end],dp[i]+length);
                }
            }
        }
        System.out.println(dp[d]);
    }
}
