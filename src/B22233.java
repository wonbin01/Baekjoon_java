import java.io.*;
import java.util.HashSet;
public class B22233 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        StringBuilder sb=new StringBuilder();
        HashSet<String> hs=new HashSet<>();
        int n=Integer.parseInt(input[0]); //키워드의 개수
        int m=Integer.parseInt(input[1]); //글의 개수
        for(int i=0;i<n;i++)
        {
            hs.add(br.readLine());
        }
        for(int i=0;i<m;i++)
        {
            String[] blog=br.readLine().split(",");
            for(String s : blog)
            {
                if(hs.contains(s)) hs.remove(s);
            }
            sb.append(hs.size()).append("\n");
        }
        System.out.println(sb);
    }
}
