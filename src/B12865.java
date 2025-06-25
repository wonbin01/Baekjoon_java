import java.io.*;
import java.util.*;
public class B12865 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //물건의 개수
        int k=Integer.parseInt(input[1]); //버틸 수 있는 무게
        int[][] info=new int[n][2];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            info[i][0]=Integer.parseInt(input[0]);
            info[i][1]=Integer.parseInt(input[1]);
        }
        Arrays.sort(info,(a,b)->{
            if(a[0]==b[0])
            {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++)
        {
            int weight=info[i-1][0];
            int value=info[i-1][1];
            for(int j=0;j<=k;j++)
            {
                if(j<weight)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight]+value); //현재꺼 선택 안했을때 vs 선택했을 때
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
