import java.io.*;
import java.util.Arrays;
public class B1929 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();
        String[] parts=input.split(" "); // ºóÄ­À» ±âÁØÀ¸·Î ³ª´®
        int m=Integer.parseInt(parts[0]);
        int n=Integer.parseInt(parts[1]);
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false; isPrime[1]=false;
        for(int i=2;i<=n;i++)
        {
            if(isPrime[i])
            {
                for(int j=2;i*j<=n;j++)
                {
                    isPrime[i*j]=false;
                }
            }
        }
        for(int i=m;i<=n;i++)
        {
            if(isPrime[i])
            {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
