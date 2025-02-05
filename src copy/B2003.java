import java.io.*;
public class B2003 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //숫자의 개수가 주어짐
        int target=Integer.parseInt(input[1]); //target이 주어짐
        input=br.readLine().split(" ");
        int[] number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //숫자를 입력받음
        }
        int start=0; int end=0; int result=number[0]; int cnt=0;
        while(end<n)
        {
            if(start==n || end==n)
            {
                break;
            }
            if(result<target) //target보다 작은 경우
            {
                   end++;
                   if(end==n) break;
                   result+=number[end];
            }
            else if(result==target) //target과 같은 경우
            {
                cnt++;
                if(start==end) //start와 end가 같은 경우
                {
                    if(start==n-1)
                    {
                        break;
                    }
                    else
                    {
                        result-=number[start];
                        start++; end++;
                        result+=number[start];
                    }
                }
                else
                {
                    result-=number[start];
                    start++;
                }
            }
            else if(result>target) //target보다 큰 경우
            {
                if(start==end)
                {
                    if(start==n-1)
                    {
                        break;
                    }
                    else
                    {
                        result-=number[start];
                        start++; end++;
                        result+=number[start];
                    }
                }
                else
                {
                    result-=number[start];
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}
