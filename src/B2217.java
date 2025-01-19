import java.io.*;
import java.util.*;
public class B2217 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int n=Integer.parseInt(input);
        int[] loop=new int[n];
        for(int i=0;i<n;i++)
        {
            loop[i]=Integer.parseInt(br.readLine()); //로프를 입력받음
        }
        Arrays.sort(loop); //크기 순으로 정렬함
        int w=0;
        int weight=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            w=loop[i];
            weight=w*(n-i);
            if(max<weight)
            {
                max=weight;
            }
        }
        System.out.println(max);
    }
}
