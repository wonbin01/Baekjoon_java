import java.io.*;
public class B11050 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        String[] parts=input.split(" ");
        int n=Integer.parseInt(parts[0]);
        int k=Integer.parseInt(parts[1]);
        int mul=1; int div=1;
        for(int i=0;i<k;i++)
        {
            mul*=(n-i);
            div*=(k-i);
        }
        int temp=mul/div;
        System.out.println(temp);
    }
}
