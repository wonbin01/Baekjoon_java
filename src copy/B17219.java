import java.io.*;
import java.util.*;
public class B17219 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //사이트 주소의 수
        int m=Integer.parseInt(input[1]); //찾으려는 사이트의 주소
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            map.put(input[0],input[1]);
        }
        for(int i=0;i<m;i++)
        {
            String key=br.readLine();
            sb.append(map.get(key)).append("\n");
        }
        System.out.print(sb);
    }
}
