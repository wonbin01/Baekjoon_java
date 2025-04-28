import java.io.*;
public class B31924 
{
    static int[][] direction=new int[][] {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int total=0;
        int n=Integer.parseInt(br.readLine());
        char[][] map=new char[n][n];
        for(int i=0;i<n;i++)
        {
            String input=br.readLine();
            for(int j=0;j<n;j++)
            {
                map[i][j]=input.charAt(j);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(map[i][j]=='M')
                {
                    for(int k=0;k<8;k++)
                    {
                        int mx=direction[k][0]; int my=direction[k][1];
                        int nx=i; int ny=j;
                        StringBuilder sb=new StringBuilder();
                        sb.append(map[i][j]);
                        for(int p=1;p<5;p++)
                        {
                            nx+=mx; ny+=my;
                            if(nx>=0 && nx<n && ny>=0 && ny<n)
                            {
                                sb.append(map[nx][ny]);
                            }
                            else break;
                        }
                        if(sb.toString().equals("MOBIS")) total++;
                    }
                } 
            }
        }
        System.out.println(total);
    }
}
