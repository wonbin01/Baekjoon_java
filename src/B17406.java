import java.io.*;
public class B17406 
{
    static int[][] map; //최초의 배열의 형태
    static int[][] rotation;
    static int k;
    static int n;
    static int m;
    static int min=Integer.MAX_VALUE;
    static int[] selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]); //행의 길이
        m=Integer.parseInt(input[1]); //열의 길이
        k=Integer.parseInt(input[2]); //회전의 횟수
        map=new int[n][m];
        rotation=new int[k][3];
        for(int i=0;i<n;i++) //최초의 배열의 상태 입력받음
        {
            input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }
        for(int i=0;i<k;i++) //회전 입력받음
        {
            input=br.readLine().split(" ");
            for(int j=0;j<3;j++)
            {
                rotation[i][j]=Integer.parseInt(input[j]);
            }
        }
        selected=new int[k];
        visited=new boolean[k];
        dfs(0);
        System.out.println(min);
    }
    static void dfs(int count) //모든 경우의 수를 찾는 메서드
    {
        if(count==k)
        {
            rotation();
            return;
        }
        for(int i=0;i<k;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                selected[count]=i;
                dfs(count+1);
                visited[i]=false;
            }
        }
    }
    static void rotation() 
    {
    // map 배열 깊은 복사
    int[][] rotated = new int[n][m];
    for (int i = 0; i < n; i++) {
        rotated[i] = map[i].clone();
    }
    // 선택된 연산 순서대로 회전 적용
    for (int s : selected) 
    {
        int[] rotate = rotation[s];  // 회전 연산: [r, c, z]
        int r = rotate[0] - 1; // 0-indexed
        int c = rotate[1] - 1;
        int z = rotate[2];

        for (int layer = 0; layer < z; layer++) {
            int top = r - z + layer;
            int left = c - z + layer;
            int bottom = r + z - layer;
            int right = c + z - layer;

            int temp = rotated[top][left];

            // 왼쪽 → 위
            for (int i = top; i < bottom; i++)
                rotated[i][left] = rotated[i + 1][left];

            // 아래 → 왼쪽
            for (int i = left; i < right; i++)
                rotated[bottom][i] = rotated[bottom][i + 1];

            // 오른쪽 → 아래
            for (int i = bottom; i > top; i--)
                rotated[i][right] = rotated[i - 1][right];

            // 위 → 오른쪽
            for (int i = right; i > left + 1; i--)
                rotated[top][i] = rotated[top][i - 1];

            rotated[top][left + 1] = temp;
        }
    }

    // 최소 행 합 계산
    int total_min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        int rowSum = 0;
        for (int j = 0; j < m; j++) {
            rowSum += rotated[i][j];
        }
        total_min = Math.min(total_min, rowSum);
    }

    // 전체 최소값 업데이트
    min = Math.min(min, total_min);
}

}
