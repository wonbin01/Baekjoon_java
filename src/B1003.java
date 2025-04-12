import java.io.*;
public class B1003 
{
    static int[][] dp=new int[41][2]; //1과 0이 몇번 출력되는지 저장장
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); //테스트 케이스
        int[] saved_arg=new int[t];
        int max=0;
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            saved_arg[i]=n;
            max=Math.max(max,n);
        }
        dp[0][0]=1; dp[0][1]=0; dp[1][0]=0; dp[1][1]=1;
        if(max>=2)
        {
            for(int i=2;i<=max;i++)
            {
                dp[i][0]=dp[i-1][0] + dp[i-2][0];
                dp[i][1]=dp[i-1][1] + dp[i-2][1];
            }
        }
        for(int key : saved_arg)
        {
            sb.append(dp[key][0]).append(" ").append(dp[key][1]).append("\n");
        }
        System.out.print(sb);
    }
}
