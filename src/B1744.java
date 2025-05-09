import java.io.*;
import java.util.*;
public class B1744 
{
    static ArrayList<Integer> al=new ArrayList<>(); //여기다가 값을 저장
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> positive=new ArrayList<>(); //양수를 저장
        ArrayList<Integer> negative=new ArrayList<>(); //음수를 저장
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            num[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(num); //숫자를 정렬
        for(int number : num)
        {
            if(number<0) negative.add(number);
            else if(number>0) positive.add(number);
            else cnt++;
        }
        Collections.sort(positive); Collections.sort(negative,Collections.reverseOrder());
        int pos_len=positive.size(); int ne_len=negative.size();
        find_total(pos_len,positive,0);
        find_total(ne_len,negative,cnt);
        long total=0;
        for(int number : al)
        {
            total+=number;
        }
        System.out.println(total);
    }
    public static void find_total(int len,ArrayList<Integer> positive,int cnt)
    {
        for(int i=len-1;i>=0;)
        {
            if(i>=1)
            {
                int t1=positive.get(i); int t2=positive.get(i-1);
                int add=t1+t2; int mul=t1*t2;
                if(mul>add)
                {
                    al.add(mul); i-=2;
                }
                else
                {
                    al.add(t1); i--;
                }
            }
            else
            {
                if(cnt!=0)
                {
                    al.add(0);
                }
                else
                {
                    al.add(positive.get(0));
                }
                i--;
            }
        }
    }
}
