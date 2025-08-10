import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class B20920 
{
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //단어의 개수
        int m=Integer.parseInt(input[1]); //길이가 m 이상인 단어만 외움
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String in=br.readLine();
            if(in.length()>=m) //길이가 m이상인 단어만 취급
            {
                int cnt=hm.getOrDefault(in,0);
                hm.put(in, cnt+1);
            }
        }
        for(String s : hm.keySet())
        {
            al.add(s);
        }
        Collections.sort(al,(a,b)->{
            if(hm.get(a)==hm.get(b)) //나오는 횟수가 동일한 경우
            {
                if(a.length()==b.length()) //단어의 길이가 동일한 경우
                {
                    // for(int i=0;i<a.length();i++)
                    // {
                    //     if(a.charAt(i)!=b.charAt(i))
                    //     {
                    //         return Character.compare(a.charAt(i), b.charAt(i));
                    //     }
                    // }
                    return a.compareTo(b);
                }
                //나오는 횟수는동일하지만 단어의 길이는 동일하지 않은 경우
                return Integer.compare(b.length(), a.length());
            }
            //나오는 횟수가 동일하지 않은 경우
            return Integer.compare(hm.get(b), hm.get(a));
        });
        for(String s : al)
        {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
