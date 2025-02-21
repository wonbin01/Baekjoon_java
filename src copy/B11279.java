import java.io.*;
import java.util.*;
public class B11279 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            int k=Integer.parseInt(br.readLine()); //숫자가 주어짐
            if(k==0) //가장 큰 값을 출력하고 제거
            {
                if(tm.isEmpty()) sb.append(0).append("\n");
                else //비어있지 않은 경우
                {
                    sb.append(tm.lastKey()).append("\n"); //출력
                    if(tm.get(tm.lastKey())==1) //배열에 해당 숫자가 하나밖에 없는 경우
                    {
                        tm.remove(tm.lastKey());
                    }
                    else
                    {
                        tm.put(tm.lastKey(),tm.get(tm.lastKey())-1);
                    }
                }
            }
            else //숫자를 추가하는 연산
            {
                if(!tm.containsKey(k)) //k를 포함하고 있지 않은 경우
                {
                    tm.put(k,1);
                }
                else //포함하고 있는 경우
                {
                    tm.put(k,tm.get(k)+1);
                }
            }
        }
        System.out.print(sb);
    }
}
