import java.io.*;
public class B11501 
{
    public static void main(String args[]) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine()); //날의 수
            int[] mon=new int[n];
            String[] input=br.readLine().split(" ");
            long total=0; //총 금액액 
            for(int j=0;j<n;j++)
            {
                mon[j]=Integer.parseInt(input[j]); //각 날마다의 주식 가격격
            }
            int maxValue=0;
            for(int j=mon.length-1;j>=0;j--)
            {
                if(mon[j]>maxValue)
                {
                    maxValue=mon[j];
                }
                else{
                    total+=(maxValue-mon[j]);
                }
            }
            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}
