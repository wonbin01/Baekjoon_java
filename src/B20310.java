import java.io.*;
import java.util.ArrayList;
public class B20310 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int zero_cnt=0; int one_cnt=0;
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='0') zero_cnt++;
            else if(input.charAt(i)=='1') one_cnt++;
        }
        zero_cnt/=2; one_cnt/=2; //각각 지워버릴 0과 1의 개수
        int remove=0;
        ArrayList<Character> al=new ArrayList<>();
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='1' && one_cnt>remove)
            {
                remove++;
                continue;
            }
            al.add(input.charAt(i));
        }
        remove=0;
        for(int i=al.size()-1;i>=0;i--)
        {
            if(al.get(i)=='0' && zero_cnt>remove)
            {
                remove++;
                al.remove(i);
                continue;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : al) 
        {
            sb.append(character);
        }
        System.out.println(sb);
    }    
}
