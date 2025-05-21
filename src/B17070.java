import java.io.*;
import java.util.Stack;
public class B17070 
{
    static int total=0; //전체 도달 횟수를 저장
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] map=new int[n+1][n+1];
        for(int i=1;i<n+1;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                map[i][j+1]=Integer.parseInt(input[j]);
            }
        }
        dfs(map, n);
        System.out.println(total);
    }

    public static void dfs(int[][] map,int n)
    {
        Stack<Hole> stack=new Stack<>();
        Hole init=new Hole(1,1,1,2,"row");
        stack.push(init);
        while(!stack.isEmpty())
        {
            Hole temp=stack.pop();
            int fr=temp.fr; int fc=temp.fc;
            int br=temp.br; int bc=temp.bc;
            String dir=temp.dir;
            if(br==n && bc==n)
            {
                total++;
                continue;
            }
            if(dir.equals("row")) //현재 있는 방향이 가로 방향인경우
            {
                // 가로 이동
                int nfr=fr; int nfc=fc+1;
                int nbr=br; int nbc=bc+1;
                if(nfc<=n && nbc<=n && map[nbr][nbc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "row"));
                }
                // 대각선 이동
                nfr=fr+1; nfc=fc+1;
                nbr=br+1; nbc=bc+1;
                if(nfr<=n && nfc<=n && nbr<=n && nbc<=n
                    && map[nbr][nbc]==0 && map[br][bc+1]==0 && map[br+1][bc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "dig"));
                }
            }
            else if(dir.equals("col")) //세로 방향인 경우
            {
                // 세로 이동
                int nfr=fr+1; int nfc=fc;
                int nbr=br+1; int nbc=bc;
                if(nfr<=n && nbr<=n && map[nbr][nbc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "col"));
                }
                // 대각선 이동
                nfr=fr+1; nfc=fc+1;
                nbr=br+1; nbc=bc+1;
                if(nfr<=n && nfc<=n && nbr<=n && nbc<=n
                    && map[nbr][nbc]==0 && map[br][bc+1]==0 && map[br+1][bc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "dig"));
                }
            }
            else // 대각선 방향
            {
                // 가로 이동
                int nfr=fr; int nfc=fc+1;
                int nbr=br; int nbc=bc+1;
                if(nfc<=n && nbc<=n && map[nbr][nbc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "row"));
                }
                // 세로 이동
                nfr=fr+1; nfc=fc;
                nbr=br+1; nbc=bc;
                if(nfr<=n && nbr<=n && map[nbr][nbc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "col"));
                }
                // 대각선 이동
                nfr=fr+1; nfc=fc+1;
                nbr=br+1; nbc=bc+1;
                if(nfr<=n && nfc<=n && nbr<=n && nbc<=n
                    && map[nbr][nbc]==0 && map[br][bc+1]==0 && map[br+1][bc]==0)
                {
                    stack.push(new Hole(nfr, nfc, nbr, nbc, "dig"));
                }
            }
        }
    }

    static class Hole
    {
        int fr,fc,br,bc=0;
        String dir="row"; //현재 방향 저장
        Hole(int fr,int fc,int br,int bc,String dir)
        {
            this.fr=fr;
            this.fc=fc;
            this.br=br;
            this.bc=bc;
            this.dir=dir;
        }
    }
}