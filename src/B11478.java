import java.io.*;
import java.util.HashSet;
public class B11478
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int length=input.length();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<length;i++)
        {
            for(int j=i;j<length;j++)
            {
                set.add(input.substring(i,j+1));
            }
        }
        System.out.println(set.size());
    }
}