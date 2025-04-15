import java.io.*;
public class B2193 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //자릿수가 주어짐짐
        long[] dp=new long[n+1];
        if(n==1)
        {
            System.out.println(1); return ;
        } 
        else if(n==2)
        {
            System.out.println(1); return ;
        }
        dp[1]=1; dp[2]=1;
        for(int i=3;i<n+1;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
//1이 연속으로 나타나지않음
//0으로 시작하지않음음
// (1) (10) (101 100) (1010 1000 1001)
//(10100 10101 10000 10001 10010)
//(101000 101001 101010 100001 100000 100010 100101 100100)