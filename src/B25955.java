import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
public class B25955 {
    static HashMap<String,Integer> hm=new HashMap<>();
    public static void main(String[] args) throws IOException
    {
        hm.put("B",1); hm.put("S",2); hm.put("G",3);
        hm.put("P",4); hm.put("D",5);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // int n=Integer.parseInt(br.readLine());
        String[] problem=br.readLine().split(" ");
        String[] copy=problem.clone();
        Arrays.sort(copy,new mycomparator());
        boolean sort=false;
        String[] sorting_entity=new String[2];
        int cnt=0;
        for(int i=0;i<problem.length;i++)
        {
            if(!problem[i].equals(copy[i])) //수정되었다면
            {
                sort=true;
                sorting_entity[cnt]=problem[i];
                cnt++;
            }
        }
        if(sort)
        {
            Arrays.sort(sorting_entity,new mycomparator());
            StringBuilder sb=new StringBuilder();
            sb.append("KO").append("\n");
            sb.append(sorting_entity[0]).append(" ").append(sorting_entity[1]);
            System.out.print(sb);
        }
        else
        {
            System.out.println("OK");
        }
    }
    static class mycomparator implements Comparator<String>
    {
        public int compare(String a,String b)
        {
            if(hm.get(String.valueOf(a.charAt(0))) != hm.get(String.valueOf(b.charAt(0))))
            {
                return hm.get(String.valueOf(a.charAt(0))) - hm.get(String.valueOf(b.charAt(0))); //티어를 기준으로 정렬
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                for(int i=1;i<a.length();i++)
                {
                    sb.append(String.valueOf(a.charAt(i)));
                }
                int valueA=Integer.parseInt(sb.toString());
                sb.setLength(0);
                for(int i=1;i<b.length();i++)
                {
                    sb.append(String.valueOf(b.charAt(i)));
                }
                int valueB=Integer.parseInt(sb.toString());

                return Integer.compare(valueB,valueA);
            }
        }
    }
}
