import java.io.*;
import java.util.*;
public class B11399 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] time=new int[n];
        for(int i=0;i<n;i++)
        {
            time[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(time);
        int total=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                total+=time[j];
            }
        }
        System.out.println(total);
    }    
}
