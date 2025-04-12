import java.io.*;
import java.util.*;
public class B1644 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //자연수 n이 주어짐
        List<Integer> prime=new ArrayList<>();
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false; isPrime[1]=false;
        for(int i=2;i<=n;i++)
        {
            if(isPrime[i])
            {
                prime.add(i);
                for(int j=2*i;j<=n;j+=i) //소수를 저장하는 과정
                {
                    isPrime[j]=false;
                }
            }
        }
        int length=prime.size();
        int[] Prime=new int[length];
        for(int i=0;i<length;i++)
        {
            Prime[i]=prime.get(i); //소수를 저장하는 배열
        }
        if(n==1)
        {
            System.out.println(0);
            return ;
        }
        int result=Prime[0];
        int cnt=0;
        int st=0; int en=0;
        while(en<length)
        {
            if(st==length || en==length)
            {
                break;
            }
            if(result<n) //합이 n보다 작은 경우
            {
                en++;
                if(en==length)
                {
                    break;
                }
                result+=Prime[en];
            }
            else if (result == n) 
            { // 합이 n인 경우
                cnt++;
                result -= Prime[st];
                if (en > st) 
                {
                    st++;
                } 
                else if (en == st) 
                {
                    break;
                }
            }
            else if(result>n) //합이 n보다 큰 경우
            {
                result-=Prime[st++];
            }
        }
        System.out.println(cnt);
    }
}
