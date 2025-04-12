import java.io.*;
import java.util.Arrays;
public class B2230 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //n입력받음
        int m=Integer.parseInt(input[1]); //m(차이) 입력받음
        int[] A=new int[n];
        for(int i=0;i<n;i++)
        {
            A[i]=Integer.parseInt(br.readLine()); //배열 입력받음
        }
        Arrays.sort(A); //크기 순으로 정렬시킴
        int mingap=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int en=i+1; 
            while(en<n) //en이 n보다 작은 경우에만 while
            {
                int min=A[en]-A[i];
                if(min<m) //차이가 m보다 작은경우
                {
                    en+=1;
                }
                else //차이가 m이상인 경우
                {
                    mingap=Math.min(mingap,min);
                    break;
                }
            }
        }
        System.out.println(mingap);
    }
}
