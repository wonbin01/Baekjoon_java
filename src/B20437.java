import java.io.*;
import java.util.*;
public class B20437 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<t;i++)
        {
            String w=br.readLine();
            int k=Integer.parseInt(br.readLine());
            char[] info=w.toCharArray();
            HashMap<Character,ArrayList<Integer>> hm=new HashMap<>(); //문자,인덱스 저장
            int min_length=Integer.MAX_VALUE; //가장 짧은 문자열
            int max_length=Integer.MIN_VALUE; //가장 긴 문자열
            for(int j=0;j<info.length;j++)
            {
                hm.putIfAbsent(info[j],new ArrayList<Integer>());
                hm.get(info[j]).add(j);
            }
            for(int j=0;j<info.length;j++)
            {
                char target=info[j];
                if(hm.get(target).size()<k) continue;
                int n=hm.get(target).size(); //리스트의 길이
                ArrayList<Integer> list=hm.get(target);
                for(int p=0;p<=n-k;p++)
                {
                    int start=list.get(p);
                    int end=list.get(p+k-1);
                    int length=end-start+1;
                    min_length=Math.min(min_length,length);
                    max_length=Math.max(max_length,length);
                }
            }
            if(min_length==Integer.MAX_VALUE)
            {
                sb.append(-1).append("\n");
            }
            else sb.append(min_length).append(" ").append(max_length).append("\n");
        }
        System.out.println(sb);
    }
}
