import java.io.*;
public class B23971 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int h=Integer.parseInt(input[0]); //행
        int w=Integer.parseInt(input[1]); //열
        int n=Integer.parseInt(input[2]); //세로로 N칸
        int m=Integer.parseInt(input[3]); //가로로 M칸 이상 비우고 앉아야됨
        int count=0; //1,1에서부터 시작
        for(int i=1;i<=h;)
        {
            for(int j=1;j<=w;)
            {
                j+=(m+1);
                count++;
            }
            i+=(n+1);
        }
        System.out.println(count);
    }
}
