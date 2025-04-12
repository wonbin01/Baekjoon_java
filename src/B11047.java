import java.io.*;
public class B11047 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();
        String[] tokens=input.split(" ");
        int n=Integer.parseInt(tokens[0]);
        int k=Integer.parseInt(tokens[1]);
        int[] coins=new int[n]; //동전의 종류를 저장
        for(int i=0;i<n;i++)
        {
            input=br.readLine();
            coins[i]=Integer.parseInt(input);
        }
        int cnt=0;
        for(int i=n-1;i>=0;i--)
        {
            if(coins[i]<=k)
            {
                cnt+=k/coins[i];
                k%=coins[i];
            }
        }
        sb.append(cnt);
        System.out.print(sb);
    }
}
