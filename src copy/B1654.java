import java.io.*;
import java.util.Arrays;
public class B1654 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();
        String[] len=input.split(" ");
        int k=Integer.parseInt(len[0]); //k를 입력받음
        int n=Integer.parseInt(len[1]); //n을 입력받음
        int[] number=new int[k]; //가지고 있는 랜선의 길이 입력받음
        for(int i=0;i<k;i++)
        {
            number[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(number); //크기 순으로 정렬시킴
        long st=1; long en=number[k-1]; long mid; int count=0;
        while(st<=en)
        {
            mid=(en+st)/2;
            count=check(mid,number);
            if(count>=n) st=mid+1;
            else en=mid-1;
        }
        sb.append(en);
        System.out.print(sb);
    }
    public static int check(long mid,int[] number)
    {
        int cnt=0;
        int n=number.length;
        for(int i=0;i<n;i++)
        {
            cnt+=number[i]/mid;
        }
        return cnt;
    }
}
