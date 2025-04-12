import java.io.*;
public class B10816 
{
    public static int[] plus=new int[10000001];
    public static int[] minus=new int[10000001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine()); //숫자카드 개수 입력받음
        String[] sang=br.readLine().split(" "); //숫자카드 입력받음
        for(int i=0;i<n;i++)
        {
            int num=Integer.parseInt(sang[i]);
            if(num>=0) plus[num]++;
            else minus[-num]++;
        }
        int m=Integer.parseInt(br.readLine()); //숫자 카드 개수 입력받음
        String[] output=br.readLine().split(" ");
        for(int i=0;i<m;i++)
        {
            int num=Integer.parseInt(output[i]);
            if(num>=0) sb.append(plus[num]).append(" ");
            else sb.append(minus[-num]).append(" ");
        }
        System.out.print(sb);
    }
}
