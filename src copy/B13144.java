import java.io.*;
import java.util.*;
public class B13144 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //수열의 길이 n
        String[] input=br.readLine().split(" ");
        int[] number=new int[n];
        long cnt=0; //경우의 수
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //수열 입력받음
        }
        int end=0;
        Set<Integer> set=new HashSet<>();
        for(int start=0;start<n;start++)
        {
            while(end<n&&!set.contains(number[end]))
            {
                set.add(number[end]);
                end++;
            }
            cnt+=(end-start);
            set.remove(number[start]);
        }
        System.out.println(cnt);
    }
}
