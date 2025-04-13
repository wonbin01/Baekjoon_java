import java.io.*;
public class B1932 
{
    static int[][] direction=new int[][] {{1,0},{1,1}};
    static int[][] triangle;
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); //삼각형의 크기
        triangle=new int[n][n]; //삼각형을 저장함
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<=i;j++)
            {
                triangle[i][j]=Integer.parseInt(input[j]);
            }
            for(int j=i+1;j<n;j++)
            {
                triangle[i][j]=-1; //비어있는 곳은 -1로 입력받음
            }
        }
        dp[0][0]=triangle[0][0];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j && i!=0 && j!=0) //양끝에 있는 경우 + 처음이 아닌 경우
                {
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                }
                else if(j==0 && i!=0) //첫 열이고, 첫번째 줄이 아닌 경우
                {
                    dp[i][j]=dp[i-1][j]+triangle[i][j];
                }
                else if(i!=0 && j!=0 && i!=j)
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
                }
            }
        }
        // 최댓값 계산
        int max = 0;
        for (int i = 0; i < n; i++) 
        {
            max = Math.max(max, dp[n-1][i]);
        }

        System.out.println(max);
    }
    
}
//삼각형에서 이동할 수 있는 경로는 아래 방향 또는 아래+오른쪽
