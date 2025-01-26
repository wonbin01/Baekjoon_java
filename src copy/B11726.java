import java.io.*;

public class B11726 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();
        int n=Integer.parseInt(input);
        if(n==1)
        {
            System.out.println(1);
            return;
        }
        else if(n==2)
        {
            System.out.println(2);
            return;
        }
        int[] array=new int[n+1];
        array[1]=1;
        array[2]=2;
        for(int i=3;i<=n;i++)
        {
            array[i]=(array[i-1]+array[i-2])%10007;
        }
        sb.append(array[n]).append("\n");
        System.out.print(sb);
    }
}
