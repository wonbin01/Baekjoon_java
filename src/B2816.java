import java.io.*;
import java.util.ArrayList;
public class B2816 
{
    static ArrayList<String> al;
    static StringBuilder sb;
    static int cur=0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String input=br.readLine();
            al.add(input);
        }
        changeList("KBS1", 0);
        changeList("KBS2", 1);
        System.out.println(sb);
    }
    public static void changeList(String channel,int target)
    {
        for(String candidate : al)
        {
            if(candidate.equals(channel))
            {
                break;
            }
            sb.append("1");
            cur++;
        }
        while(cur!=target)
        {
            sb.append("4");
            String candidate=al.get(cur);
            String selected=al.get(cur-1);
            al.set(cur-1,candidate);
            al.set(cur,selected);
            cur--;
        }
    }
}