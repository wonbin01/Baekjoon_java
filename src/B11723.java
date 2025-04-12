import java.io.*;
import java.util.*;
public class B11723 
{
    static HashSet<Integer> hs=new HashSet<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(br.readLine()); //연산의 수
        for(int i=0;i<m;i++)
        {
            String[] input=br.readLine().split(" ");
            int length=input.length;
            if(length==1)
            {
                String command=input[0];
                if(command.equals("all"))
                {
                    hs.clear();
                    for(int j=1;j<=20;j++)
                    {
                        hs.add(j);
                    }
                }
                else if(command.equals("empty"))
                {
                    hs.clear();
                }
            }
            else
            {
                String command=input[0];
                int x=Integer.parseInt(input[1]);
                if(command.equals("add"))
                {
                    hs.add(x);
                }
                else if(command.equals("remove"))
                {
                    if(hs.contains(x)) hs.remove(x);
                }
                else if(command.equals("check"))
                {
                    if(hs.contains(x)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
                else if(command.equals("toggle"))
                {
                    if(hs.contains(x)) hs.remove(x);
                    else hs.add(x);
                }
            }
        }
        System.out.print(sb);
    }
}
