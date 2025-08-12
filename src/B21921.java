import java.io.*;
public class B21921 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); int x=Integer.parseInt(input[1]); //날짜 + x일 동안 들어온 방문자 수
        input=br.readLine().split(" ");
        int[] days=new int[n]; //블로그 시작 1일차 부터 N일차
        for(int i=0;i<n;i++)
        {
            days[i]=Integer.parseInt(input[i]);
        }
        int max=Integer.MIN_VALUE; //최대 방문자 수 저장
        int count=0;
        int cur=0;
        for(int i=0;i<x;i++)
        {
            cur+=days[i];
        }
        for(int i=x-1;i<n-1;i++)
        {
            if(cur>max)
            {
                max=cur;
                count=1;
            }
            else if(cur==max)
            {
                count++;
            }
            cur-=days[i-x+1]; cur+=days[i+1];
        }
        int last_add=0;
        for(int i=n-1;i>n-1-x;i--)
        {
            last_add+=days[i];
            if(last_add>max)
            {
                max=last_add;
                count=1;
            }
            else if(last_add==max)
            {
                count++;
            }
        }
        if(max==0)
        {
            System.out.println("SAD");
        }
        else
        {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
