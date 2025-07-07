import java.io.*;
import java.util.*;
public class B1431 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String candidate=br.readLine();
            al.add(candidate);
        }
        Collections.sort(al,(a,b)->
        {
            if(a.length()!=b.length()) //길이가 짧은 순서대로 정렬
            {
                return Integer.compare(a.length(), b.length());
            }
            else
            {
                //각 자리의 합으로 정렬
                int a_num=calculate_number(a);
                int b_num=calculate_number(b);
                if(a_num!=b_num) //작은 합을 가지는 것이 먼저 옴
                {
                    return Integer.compare(a_num, b_num);
                }
                //각 자리의 합으로 정렬되지 않으면, 사전순으로 정렬
                else
                {
                    return a.compareTo(b);
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for(String s : al)
        {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
    static int calculate_number(String s)
    {
        int n=s.length();
        int total=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            int num=c-'0';
            if(num>=0 && num<=9)
            {
                total+=num;
            }
        }
        return total;
    }
}
