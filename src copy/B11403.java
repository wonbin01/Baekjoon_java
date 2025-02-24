import java.io.*;
public class B11403 
{
    static int[][] graph;
    static int[][] reachable;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        graph=new int[n][n];
        reachable=new int[n][n];
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                graph[i][j]=Integer.parseInt(input[j]);
            }
        }
        for(int i=0;i<n;i++)
        {
            dfs(i,i,n);
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.print(reachable[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int start,int current,int n)
    {
        for(int next=0;next<n;next++)
        {
            if(graph[current][next]==1 && reachable[start][next]==0)
            {
                reachable[start][next]=1; //방문 표시
                dfs(start,next,n);
            }
        }
    }
}
