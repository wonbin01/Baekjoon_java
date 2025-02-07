import java.io.*;
public class B22862 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //수열의 길이
        int k=Integer.parseInt(input[1]); //수열에서 k번 삭제
        input=br.readLine().split(" ");
        int[] number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //수열 입력받음
        }
        int count=0; //삭제한 횟수 저장
        int start=0; int end=0; int length=0; int temp=0;
        while(end<n)
        {
            if(number[end]%2!=0) //홀수인 경우
            {
                count++;
            }
            else //짝수인 경우
            {
                temp++;
            }
            while(count>k)
            {
                if(number[start]%2!=0)
                {
                    count--;
                }
                else
                {
                    temp--;
                }
                start++;
            }
            length=Math.max(length,temp);
            end++;
        }
        System.out.println(length);
    }
}
