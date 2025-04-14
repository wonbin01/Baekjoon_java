import java.io.*;
public class B11727 
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1]; //각 거리까지 채울 수 있는 방법의 수(dp[1] -> 1까지 채울 수 있는 방법)
        if(n==1)
        {
            System.out.println(1);
            return;
        }
        else if(n==2)
        {
            System.out.println(3);
            return ;
        }
        dp[1]=1; dp[0]=0; dp[2]=3;
            for(int i=3;i<=n;i++)
            {
                    dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
            }
        System.out.println(dp[n]);
    }
}
//1*2를 사용하면 밑에도 1*2 사용해야됨
//2*1 사용하면 2*2를 사용해도 되고, 2*1을 사용해도 됨
//2*2를 사용하면 아무거나 사용가능