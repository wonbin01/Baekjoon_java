import java.io.*;
import java.util.*;
class B15654
{
    static int n,m;
    static int[] selected;
    static StringBuilder sb=new StringBuilder();
    static int[] number;
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(number);
        selected=new int[m];
        visited=new boolean[n];
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
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                selected[depth]=number[i];
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}