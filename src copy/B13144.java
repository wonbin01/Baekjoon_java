import java.io.*;
public class B13144 
{
    static int cnt=0;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //수열의 길이 n
        String[] input=br.readLine().split(" ");
        int[] number=new int[n];
        cnt=n; //일단 하나씩 뽑는 경우 n가지 경우의 수
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //수열 입력받음
        }
        int en=1;
        
    }
    static boolean is_same(int a, int b) //두 수를 비교하는 메서드
    {
        return a == b;
    }
}
