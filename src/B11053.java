import java.io.*;
public class B11053 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] num=new int[n];
        int[] dp=new int[n]; //
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(input[i]);
        }
        dp[0]=1;
        if(n==1){
            System.out.println(dp[0]); return;
        }
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            for(int j=0;j<i;j++)
            {
                if(num[i]>num[j])
                {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
