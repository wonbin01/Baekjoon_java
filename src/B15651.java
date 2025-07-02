import java.io.*;
public class B15651 
{
    static int n,m;
    static int[] selected;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        selected=new int[m];
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int depth)
    {
        if(depth==m)
        {
            for(int s : selected)
            {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++)
        {
            selected[depth]=i;
            dfs(depth+1);
        }
    }
}
