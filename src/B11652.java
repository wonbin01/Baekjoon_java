import java.util.*;

public class B11652 
{
    public static int index=0;
    public static int max=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] number=new long[100001];
        for(int i=0;i<n;i++)
        {
            number[i]=sc.nextLong();
        }
        Arrays.sort(number); //오름차순으로 정렬함
        int cnt=1;
        for(int i=1;i<n;i++) //숫자 개수 카운트
        {
            if(number[i]==number[i+1])
            {
                cnt++;
            }
            else
            {
                if(cnt>max)
                {
                    max=cnt;
                    index=i-1;
                }
                cnt=1;
            }
        }
        if(cnt>max)
        {
            max=cnt;
            index=n-1;
        }
        System.out.println(number[index]);
        sc.close();
    }
        
}
