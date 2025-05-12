import java.io.*;
public class B2847 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //몇번 입력받는지
        int[] point=new int[n];
        for(int i=0;i<n;i++)
        {
            point[i]=Integer.parseInt(br.readLine());
        }
        int count=0; //몇번 줄이면 되는지
        for(int i=n-1;i>=0;i--)
        {
            if(i+1>=n) continue;
            int prev=point[i+1]; //더 높은 단계
            int cur=point[i]; // 점수를 낮춰야하는 단계
            while(cur>=prev) //현재값이 더 큰 경우
            {
                cur-=1; count++;
            }
            point[i]=cur;
        }
        System.out.println(count);
    }
}
