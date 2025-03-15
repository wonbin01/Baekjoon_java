import java.io.*;
public class B14888 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //숫자의 개수
        String[] input=br.readLine().split(" ");
        int[] num=new int[n]; //정수들 저장
        for(int i=0;i<n;i++)
        {
            num[1]=Integer.parseInt(input[i]);
        }
        int[] calculater=new int[4]; // +,-,*,/의 개수 저장
        input=br.readLine().split(" ");
        for(int i=0;i<4;i++)
        {
            calculater[i]=Integer.parseInt(input[i]);
        }
    }
}
