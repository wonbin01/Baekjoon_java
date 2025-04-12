import java.util.Scanner;
import java.util.Stack;

public class B1012 
{
    static final int MAX=51;
    static int[][] direction={{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt(); //테스트 케이스
        for(int i=0;i<t;i++)
        {
            int m=scanner.nextInt(); //배추밭의 가로
            int n=scanner.nextInt(); //배추밭의 세로
            int k=scanner.nextInt(); //배추 위치의 개수
            carrage(m,n,k,scanner);
        }
        scanner.close();
    }
    public static void carrage(int m, int n, int k, Scanner scanner)
    {
        int [][] visited =new int[MAX][MAX];
        int [][] bound=new int[MAX][MAX];
        int number=0;

        for(int i=0;i<k;i++) //배추의 위치를 입력받음
        {
            int c=scanner.nextInt();
            int r=scanner.nextInt();
            bound[r][c]=1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(bound[i][j]==1 && visited[i][j]==0)
                {
                    dfs(n,m,visited,bound,i,j);
                    number++;
                }
            }
        }
        System.out.println(number);
    }
    public static void dfs(int n, int m, int[][] visited, int[][] bound, int startx, int starty)
    {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startx,starty}); //시작 부분을 집어넣음
        visited[startx][starty]=1;
        while(!stack.isEmpty())
        {
            int[] current=stack.pop();
            int cx=current[0];
            int cy=current[1];
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&visited[nx][ny]==0&&bound[nx][ny]==1)
                {
                    stack.push(new int[]{nx,ny});
                    visited[nx][ny]=1;
                }
            }
        }
    }
}
