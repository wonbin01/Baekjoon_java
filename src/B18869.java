import java.io.*;
public class B18869 
{
    static int[][] universe;
    static int[] A_selected;
    static int[] B_selected;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException
    {
        int answer=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        m=Integer.parseInt(input[0]); //우주의 개수
        n=Integer.parseInt(input[1]); //우주에 있는 행성의 개수
        universe=new int[m][n];
        A_selected=new int[n];
        B_selected=new int[n];
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                universe[i][j]=Integer.parseInt(input[j]);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                //0이면 쌍둥이 우주, -1이면 x
                int result=dfs(0,0,i,j);
                if(result==0)
                {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static int dfs(int start,int depth,int A_universe,int B_universe)
    {
        boolean check=true;
        if(depth==2)
        {
            int a_1=A_selected[0]; int a_2=A_selected[1];
            int b_1=B_selected[0]; int b_2=B_selected[1];
            if(a_1-a_2>0) //양수
            {
                if(b_1-b_2<=0)
                {
                    return -1;
                }
                return 0;
            }
            else if(a_1-a_2==0) //0
            {
                if(b_1-b_2!=0)
                {
                    return -1;
                }
                return 0;
            }
            else //음수
            {
                if(b_1-b_2>=0)
                {
                    return -1;
                }
            }
            return 0;
        }
        for(int i=start;i<n;i++)
        {
            A_selected[depth]=universe[A_universe][i];
            B_selected[depth]=universe[B_universe][i];
            int result=dfs(i,depth+1,A_universe,B_universe);
            if(result==-1)
            {
                check=false;
                break;
            }
        }
        if(check)
        {
            return 0;
        }
        else return -1;
    }
}
