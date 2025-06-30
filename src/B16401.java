import java.util.*;
import java.io.*;
public class B16401 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int m=Integer.parseInt(input[0]); //조카의 수
        int n=Integer.parseInt(input[1]); //과자의 수
        input=br.readLine().split(" "); //과자 입력받음
        int[] snack=new int[n];
        for(int i=0;i<n;i++)
        {
            snack[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(snack);
        int left=1; int right=snack[n-1];
        int answer=0;
        while(left<=right)
        {
            int mid=(left+right)/2;
            int count=0;
            for(int len : snack)
            {
                count+=len/mid;
            }
            if(count>=m)
            {
                answer=mid;
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
}