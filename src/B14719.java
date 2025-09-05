import java.io.*;
public class B14719 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int h=Integer.parseInt(input[0]); //세로   
        int w=Integer.parseInt(input[1]); //가로
        input=br.readLine().split(" ");
        boolean[][] visited=new boolean[h][w]; //벽인지 비어있는지 확인
        int[] wall=new int[w];
        int total=0;
        for(int i=0;i<w;i++)
        {
            wall[i]=Integer.parseInt(input[i]);
        }
        for(int i=0;i<w;i++)
        {
            int height=wall[i];
            for(int j=h-1;j>=0;j--)
            {
                if(height>0)
                {
                    visited[j][i]=true;
                    height--;
                }
            }
        }
        for(int i=h-1;i>=0;i--)
        {
            int start=0; int end=0;
            for(int j=0;j<w;j++)
            {
                if(visited[i][j])
                {
                    start=j;
                    for(int k=j+1;k<w;k++)
                    {
                        if(k>=w) break; //범위를 벗어나면 break
                        if(visited[i][k])
                        {
                            end=k;
                            break;
                        }
                    }
                    if(end<=start) continue;
                    total+=end-start-1;
                    start=end;
                }
            }
        }
        System.out.println(total);
    }    
}
