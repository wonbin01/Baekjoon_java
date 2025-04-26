import java.io.*;
import java.util.*;
public class B32978 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        String[] miss=br.readLine().split(" ");
        ArrayList<String> al=new ArrayList<>();
        for(String key : input)
        {
            al.add(key);
        }
        for(String k : miss)
        {
            al.remove(k);
        }
        System.out.println(al.get(0));
    }
}
