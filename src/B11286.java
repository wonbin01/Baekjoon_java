import java.io.*;
import java.util.*;
public class B11286 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        TreeMap<Integer,TreeMap<Integer,Integer>> tm=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            int value=Integer.parseInt(br.readLine());
            int key=Math.abs(value); //절댓값이 key가 됨
            if(value==0) //절댓값이 가장 큰 값을 출력하고 제거
            {
                if(tm.isEmpty()) sb.append(0).append("\n"); //비어있는 경우 0 출력
                else //비어있지 않은 경우
                {
                    int min=tm.firstKey(); //절대값이 가장 작은 값
                    int min_value=tm.get(min).firstKey();
                    sb.append(min_value).append("\n"); //가장 작은 값을 출력

                    if(tm.get(min).get(min_value)==1)
                    {
                        tm.get(min).remove(min_value);
                        if(tm.get(min).isEmpty()) tm.remove(min);
                    }
                    else
                    {
                        tm.get(min).put(min_value,tm.get(min).get(min_value)-1);
                    }
                }
            }
            else //값을 추가
            {
                tm.putIfAbsent(key, new TreeMap<>()); //비어있는 경우에는 새로운 treemap 생성
                tm.get(key).put(value,tm.get(key).getOrDefault(value, 0)+1);
            }
        }
        System.out.print(sb);
    }
}
