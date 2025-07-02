import java.io.*;
import java.util.*;
public class B11559 
{
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int answer=0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        map=new char[12][6];
        for(int i=0;i<12;i++)
        {
            String input=br.readLine();
            for(int j=0;j<6;j++)
            {
                map[i][j]=input.charAt(j);
            }
        }
        boolean keep=true;
        while(keep)
        {
            int update=0;
            boolean[][] visited=new boolean[12][6];
            for(int i=0;i<12;i++)
            {
                for(int j=0;j<6;j++)
                {
                    if(!visited[i][j] && map[i][j]!='.') //아직 방문되지 않았고, 빈 공간이 아닌 경우
                    update+=dfs(i,j,map[i][j],visited);
                }
            }
            if(update==0) //업데이트된 블럭이 없는 경우
            {
                keep=false;
                break;
            }
            //map을 업데이트해야됨
            update_map();
            answer++;
        }
        System.out.println(answer);
    }
    static int dfs(int row,int col,char target,boolean[][] visited) //x,y는 시작 좌표, visited는 방문 이력, target은 색깔의 정보를 저장
    {
        Stack<int[]> stack=new Stack<>();
        ArrayList<int[]> al=new ArrayList<>(); //연결된 블럭의 위치를 저장하는 리스트
        stack.add(new int[] {row,col});
        visited[row][col]=true; //방문 여부 확인
        int count=1; //블럭의 개수를 세는 변수
        al.add(new int[] {row,col});
        int update=0;
        while(!stack.isEmpty())
        {
            int[] temp=stack.pop();
            int cx=temp[0]; int cy=temp[1];
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<12 && ny>=0 && ny<6 && !visited[nx][ny] && map[nx][ny]==target)
                {
                    visited[nx][ny]=true; //방문 처리
                    count++;
                    stack.add(new int[] {nx,ny});
                    al.add(new int[] {nx,ny});
                }
            }
        }
        if(count>=4) //모인 블럭의 수가 4이상인 경우
        {
            for(int[] num : al)
            {
                int r=num[0]; int c=num[1];
                map[r][c]='.';
            }
            update++;
        }
        return update; //업데이트된 무리들을 return해줌
    }
    static void update_map()
    {
        for(int col=0;col<6;col++)
        {
            Queue<Character> queue=new LinkedList<>();
            for(int row=11;row>=0;row--)
            {
                if(map[row][col]!='.')
                {
                    queue.add(map[row][col]);
                }
            }
            for(int row=11;row>=0;row--)
            {
                if(!queue.isEmpty())
                {
                    map[row][col]=queue.poll();
                }
                else
                {
                    map[row][col]='.';
                }
            }
        }
    }
}
