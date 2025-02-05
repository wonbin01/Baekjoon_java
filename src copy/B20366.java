import java.io.*;
import java.util.Arrays;
public class B20366 
{
    public static int ans = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(number); // 정렬시킴
        for(int i1=0;i1<n-3;i1++)
        {
            for(int i2=i1+3;i2<n;i2++)
            {
                int j1=i1+1; int j2=i2-1;
                int target=number[i1]+number[i2];
                while(j1<j2)
                {
                    int sum=number[j1]+number[j2];
                    ans=Math.min(ans,Math.abs(target-sum));
                    if(target>sum)
                    {
                        j1++;
                    }
                    else j2--;
                }
            }
        }
        System.out.println(ans);
    }
}
