import java.io.*;
public class B9095 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        int temp=0;
        int[] add_result=new int[12]; //t를 1,2,3의 합으로 나타내는 경우의 수
        add_result[1]=1;
        add_result[2]=2;
        add_result[3]=4;
        for(int i=4;i<12;i++)
        {
            add_result[i]=add_result[i-1]+add_result[i-2]+add_result[i-3];
        }
        for(int i=0;i<t;i++)
        {
            temp=Integer.parseInt(br.readLine());
            sb.append(add_result[temp]).append("\n");
        }
        System.out.print(sb);
    }
}
