import java.io.*;
public class B14889
{
    static boolean[] selected;
    static int n;
    static int[][] map;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n+1][n+1];
        selected=new boolean[n+1];
        for(int i=1;i<=n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                map[i][j+1]=Integer.parseInt(input[j]);
            }
        }
        divide(1,0);
        System.out.println(min);
    }
    static void divide(int idx,int cnt)
    {
        if(cnt==n/2)
        {
            calcscore();
            return;
        }
        for(int i=idx;i<=n;i++)
        {
            selected[i]=true;
            divide(i+1,cnt+1);
            selected[i]=false;
        }
    }
    static void calcscore()
    {
        int score_start=0; int score_link=0;
        for(int i=1;i<=n;i++)
        {
            if(selected[i])
            {
                for(int j=1;j<=n;j++)
                {
                    if(selected[j] && i!=j)
                    {
                        score_start+=map[i][j];
                    }
                }
            }
            else
            {
                for(int j=1;j<=n;j++)
                {
                    if(!selected[j] && i!=j)
                    {
                        score_link+=map[i][j];
                    }
                }
            }
        }
        min=Math.min(min,Math.abs(score_start-score_link));
    }
}