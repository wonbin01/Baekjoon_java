import java.io.*;
import java.util.*;
import java.util.LinkedList;
public class B7562 
{
    static StringBuilder sb=new StringBuilder();
    static int[][] direction=new int[][] {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); //테스트 케이스
        for(int i=0;i<t;i++)
        {
            int l=Integer.parseInt(br.readLine()); //체스판의 한 변 길이
            visited=new boolean[l][l];
            String[] input=br.readLine().split(" ");
            int current_row=Integer.parseInt(input[0]); //현재 있는 칸
            int current_col=Integer.parseInt(input[1]); //현재 있는 칸
            input=br.readLine().split(" ");
            int target_row=Integer.parseInt(input[0]); //목표 칸
            int target_col=Integer.parseInt(input[1]); //목표 칸
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[] {current_row, current_col,0}); //현재 있는 칸 + 이동 횟수 저장
            visited[current_row][current_col]=true;
            if(current_row==target_row && current_col==target_col)
            {
                sb.append(0).append("\n");
                continue;
            }
            int min=Integer.MAX_VALUE;
            while(!queue.isEmpty())
            {
                int[] node=queue.poll();
                int cx=node[0]; int cy=node[1]; int count=node[2];
                if(cx==target_row && cy==target_col)
                {
                    min=Math.min(min,count);
                    continue;
                }
                for(int j=0;j<8;j++)
                {
                    int nx=cx+direction[j][0];
                    int ny=cy+direction[j][1];
                    if(nx>=0 && nx<l && ny>=0 && ny<l && !visited[nx][ny])
                    {
                        queue.add(new int[] {nx,ny,count+1});
                        visited[nx][ny]=true;
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }
}
