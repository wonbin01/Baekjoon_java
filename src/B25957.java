import java.io.*;
import java.util.HashMap;
public class B25957 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<String,String> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String input=br.readLine();
            String s1=String.valueOf(input.charAt(0));
            String s2=String.valueOf(input.charAt(input.length()-1));
            StringBuilder sb1=new StringBuilder();
            sb1.append(s1).append(s2).append(input.length());
            String key=sb1.toString();
            hm.put(key,input);
        }
        int m=Integer.parseInt(br.readLine());
        String[] in=br.readLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++)
        {
            String s1=String.valueOf(in[i].charAt(0));
            String s2=String.valueOf(in[i].charAt(in[i].length()-1));
            StringBuilder sb2=new StringBuilder();
            sb2.append(s1).append(s2).append(in[i].length());
            String key=sb2.toString();
            String value=hm.get(key);
            if(i==m-1) sb.append(value);
            else sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}
