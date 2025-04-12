import java.io.*;
import java.util.Arrays;
public class B18870 
{
    public static StringBuilder sb=new StringBuilder();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int n=Integer.parseInt(input); //n을 입력받음
        String[] input2=br.readLine().split(" ");
        long[] coordinate=new long[n];
        for(int i=0;i<n;i++)
        {
            coordinate[i]=Integer.parseInt(input2[i]); //좌표가 주어짐
        }
        long[] result=Arrays.stream(coordinate).sorted().distinct().toArray(); //중복된 요소 제거
        for(int i=0;i<n;i++)
        {
            find_index(result,coordinate[i]);
        }
        System.out.print(sb);
    }    
    public static void find_index(long[] result,long p)
    {
        int en=result.length-1; int st=0;
        int mid=(en+st)/2;
        while(st<=en)
        {
            if(result[mid]<p)
            {
                mid+=1;
                st=mid;
                mid=(en+st)/2;
            }
            else if(result[mid]>p)
            {
                mid-=1;
                en=mid;
                mid=(en+st)/2;
            }
            else if(result[mid]==p)
            {
                sb.append(mid).append(" ");
                break;
            }
        }
    }
}
