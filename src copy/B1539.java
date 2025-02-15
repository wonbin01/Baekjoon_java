import java.io.*;
import java.util.*;

public class B1539 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] p=new int[n];
        for(int i=0;i<n;i++)
        {
            p[i]=Integer.parseInt(br.readLine());
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(p[0], 1); // root를 집어넣음

        for(int i=1; i<n; i++)
        {
            Integer max = map.ceilingKey(p[i]); // p[i]보다 큰 값 중에서 최솟값
            Integer min = map.floorKey(p[i]); // p[i]보다 작은 값 중에서 최댓값

            if(max !=null && min!=null) 
                map.put(p[i], Math.max(map.get(max), map.get(min)) + 1);
            else if(max!=null && min==null) 
                map.put(p[i], map.get(max) + 1);
            else if(max==null && min!=null) 
                map.put(p[i], map.get(min) + 1);
        }

        int total = 0;
        for(Integer height : map.values())
        {
            total += height;
        }
        System.out.println(total);
    }
}