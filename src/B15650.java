import java.io.*;
public class B15650 
{
    static int n,m;
    static int[] selected;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        selected=new int[m];
        dfs(1, 0);
    }
    static void dfs(int start,int depth)
    {
        if(depth==m)
        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<m;i++)
            {
                sb.append(selected[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=start;i<=n;i++)
        {
            selected[depth]=i;
            dfs(i+1, depth+1);
        }
    }
}
