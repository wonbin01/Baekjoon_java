import java.io.*;
public class B1463
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();
        int n=Integer.parseInt(input); //n이 주어짐
        int[] number=new int[1000002]; //최소 연산값을 저장하는 배열
        number[1]=0;
        number[2]=1;
        for(int i=3;i<n+1;i++) //n까지 반복함
        {
            //2으로만 나눠떨어지는 경우
            if(i%2==0 && i%3!=0)
            {
                number[i]=Math.min(number[i/2],number[i-1])+1;
            }
            else if(i%2!=0&&i%3==0) //3으로만 나눠떨어지는 경우
            {
                number[i]=Math.min(number[i/3],number[i-1])+1;
            }
            //2,3으로만 나눠떨어지는 경우
            else if(i%2==0&&i%3==0)
            {
                int temp=Math.min(number[i/2],number[i/3]);
                number[i]=Math.min(temp,number[i-1])+1;
            }
            else //2,3으로 다 안나눠떨어지는 경우
            {
                number[i]=number[i-1]+1;
            }
        }
        sb.append(number[n]+"\n");
        System.out.print(sb);
    }
}