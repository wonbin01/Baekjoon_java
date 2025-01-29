import java.io.*;
public class B1806 
{
    static int mincnt=Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); int s=Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        int[] number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //정수를 입력받음
        }
        int sum=0, start=0;
        for(int end=0;end<n;end++)
        {
            sum+=number[end];
            while(sum>=s) //조건을 만족시키면 start로 이동시킴
            {
                mincnt=Math.min(mincnt,end-start+1);
                sum-=number[start++];
            }
        }
        System.out.println(mincnt==Integer.MAX_VALUE ? 0 : mincnt);
    }
    
}
