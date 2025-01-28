import java.io.*;
import java.util.Arrays;
public class B1920 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //배열의 크기가 주어짐
        String[] input=br.readLine().split(" "); //빈칸을 기준으로 나눔
        long[] A=new long[n];
        for(int i=0;i<n;i++)
        {
            A[i]=Integer.parseInt(input[i]); //배열이 주어짐
        }
        long[] sorted_A=Arrays.stream(A).sorted().distinct().toArray(); // A를 정렬하는데 중복되는 요소 없이 정렬
        int m=Integer.parseInt(br.readLine());
        input=br.readLine().split(" ");
        long[] B=new long[m];
        for(int i=0;i<m;i++)
        {
            B[i]=Integer.parseInt(input[i]);
            is_exist(sorted_A, B[i]);
        }
        System.out.print(sb);
    }
    public static void is_exist(long[] sorted_A,long p) //p는 B에서 날아옴
    {
        int n=sorted_A.length; //sorted_A의 길이
        int st=0; int en=n-1;
        int mid=(st+en)/2;
        while(st<=en)
        {
            if(sorted_A[mid]>p)
            {
                mid-=1;
                en=mid;
                mid=(st+en)/2;
            }
            else if(sorted_A[mid]<p)
            {
                mid+=1;
                st=mid;
                mid=(st+en)/2;
            }
            else
            {
                sb.append(1).append("\n");
                return;
            }
        }
        sb.append(0).append("\n");
    }
}
