import java.io.*;
public class B15652 
{
    static int n;
    static int m;
    static int[] selected;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        selected=new int[m];
        dfs(1, 0);
        System.out.println(sb);
    }
    static void dfs(int start,int depth)
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
        for(int i=start;i<=n;i++)
        {
            if(depth>=1 && selected[depth-1]<=i)
            {
                selected[depth]=i;
                dfs(i, depth+1);
            }
            else if(depth==0)
            {
                selected[depth]=i;
                dfs(i,depth+1);
            }
        }
    }
}
