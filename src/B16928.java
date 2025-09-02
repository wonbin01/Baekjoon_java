import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class B16928 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited=new boolean[101]; //이미 방문한 곳인지 저장
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //사다리의 수
        int m=Integer.parseInt(input[1]); // 뱀의 수
        int[][] move=new int[n+m][2];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]); //시작 위치
            int end=Integer.parseInt(input[1]); //이동 위치
            move[i][0]=start; move[i][1]=end;
        }
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            move[n+i][0]=start; move[n+i][1]=end;
        }
        //사다리를 오름차순으로 정렬
        Arrays.sort(move,(a,b)->
        {
            return Integer.compare(a[0],b[0]);
        });
        
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {1,0}); //각각 시작위치와 이동한 횟수 저장
        visited[1]=true;
        int min_move=Integer.MAX_VALUE;
        while(!queue.isEmpty())
        {
            int[] cur=queue.poll();
            int position=cur[0]; //현재 위치
            int cnt=cur[1]; //이동한 횟수
            if(position==100)
            {
                min_move=cnt;
                break;
            }
            for(int i=1; i<=6; i++) 
            {
                int next = position + i;
                if(next > 100) break;
                if(visited[next]) continue;

                boolean moved = false;
            for(int j=0; j<n+m; j++) 
            {
                if(move[j][0] == next) 
                {
                    int dest = move[j][1];
                    if(!visited[dest]) 
                    {
                        visited[dest] = true;
                        queue.add(new int[]{dest, cnt+1});
                    }
                    moved = true;
                    break;
                }
            }
    if(!moved) 
    {
        visited[next] = true;
        queue.add(new int[]{next, cnt+1});
    }
}
        }
        System.out.println(min_move);
    }
}