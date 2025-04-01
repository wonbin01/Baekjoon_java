import java.io.*;
import java.util.*;
public class B2468 
{
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); //n*n
        int[][] building=new int[n][n]; //건물의 높이를 저장함
        int cnt=0; // 이어진 공간을 저장
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                int height=Integer.parseInt(input[j]);
                building[i][j]=height;
            }
        }
        for(int i=0;i<=100;i++)
        {
            int[][] copy=new int[n][n];
            boolean[][] visited=new boolean[n][n]; //방문했는지 여부를 저장장
            ArrayList<Integer> al=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(i>=building[j][k])
                    {
                        copy[j][k]=0; //i보다 작거나 같으면, 0으로 설정
                    }
                    else
                    {
                        copy[j][k]=building[j][k]; // i보다 크면, 살아남음
                    }
                }
            }
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(copy[j][k]!=0 && !visited[j][k]) //0이 아닌경우 + 방문되지 않은 경우
                    {
                        int num=find_building(copy, j, k, visited);
                        al.add(num);
                    }
                }
            }
            cnt=Math.max(cnt,al.size());
        }
        System.out.println(cnt);
    }
    static int find_building(int[][] copy,int x,int y,boolean[][] visited)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y]=true;
        int cnt=0;
        int size=queue.size();
        while(!queue.isEmpty())
        {
            for(int j=0;j<size;j++)
            {
                int[] node=queue.poll();
                int cx=node[0]; int cy=node[1];
                for(int i=0;i<4;i++)
                {
                    int nx=cx+direction[i][0];
                    int ny=cy+direction[i][1];
                    if(nx>=0 && nx<n && ny>=0 && ny<n)
                    {
                        if(!visited[nx][ny] && copy[nx][ny]>0) //방문되지 않았고, 물에 잠기지 않은 경우
                        {
                            visited[nx][ny]=true;
                            queue.add(new int[] {nx,ny});
                        }
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
