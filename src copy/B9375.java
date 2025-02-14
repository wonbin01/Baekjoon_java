import java.io.*;
import java.util.*;
public class B9375 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine()); //테스트 케이스
        for(int i=0;i<test_case;i++)
        {
            int n=Integer.parseInt(br.readLine()); //의상의 수
            List<String> list=new LinkedList<>(); //의상의 순서를 저장
            Map<String,String> clothes=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                String[] input2=br.readLine().split(" ");
                clothes.put(input2[0],input2[1]);
                list.add(input2[0]);
            }
            clothes_number(list,clothes);
        }
    }
    public static void clothes_number(List<String> list,Map<String,String> clothes)
    {
        Map<String,Integer> count=new HashMap<>();
        for(int i=0;i<list.size();i++)
        {
            String key=clothes.get(list.get(i));
            if(!count.containsKey(key)) //포함하고 있지 않은 경우
            {
                count.put(key,1);
            }
            else
            {
                count.put(key,count.get(key)+1); //포함하고 있는 경우
            }
        }
        int total=1;
        for (Map.Entry<String, Integer> entry : count.entrySet()) 
        {
            total*=(entry.getValue()+1);   
        }
        total-=1;
        System.out.println(total);
    }
}
