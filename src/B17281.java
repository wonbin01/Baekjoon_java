import java.io.*;
public class B17281 
{
    static int[][] inning;
    static int[] line_up;
    static boolean[] batter;
    static int n;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        inning=new int[n][9];
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<9;j++)
            {
                inning[i][j]=Integer.parseInt(input[j]);
            }
        }
        line_up=new int[9];
        line_up[3]=0;
        batter=new boolean[9];
        batter[0]=true;
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int count)
    {
        if(count==9)
        {
            simulate(); //점수 계산
            return;
        }
        if(count==3) //4번 타자는 0번 선수로 고정
        {
            line_up[3]=0;
            dfs(count+1);
            return;
        }
        for(int i=1;i<9;i++)
        {
            if(!batter[i])
            {
                batter[i]=true;
                line_up[count]=i;
                dfs(count+1);
                batter[i]=false;
            }
        }
    }
    public static void simulate() {
    int score = 0;
    int batterIndex = 0;

    for (int i = 0; i < n; i++) 
    {
        int out = 0;
        boolean[] base = new boolean[4]; // 1루 ~ 3루

        while (out < 3) {
            int result = inning[i][line_up[batterIndex]];

            if (result == 0) {
                out++;
            } else if (result == 1) {
                if (base[3]) score++;
                base[3] = base[2];
                base[2] = base[1];
                base[1] = true;
            } else if (result == 2) {
                if (base[3]) score++;
                if (base[2]) score++;
                base[3] = base[1];
                base[2] = true;
                base[1] = false;
            } else if (result == 3) {
                if (base[3]) score++;
                if (base[2]) score++;
                if (base[1]) score++;
                base[3] = true;
                base[2] = false;
                base[1] = false;
            } else if (result == 4) {
                if (base[3]) score++;
                if (base[2]) score++;
                if (base[1]) score++;
                score++; // 타자 점수
                base[1] = base[2] = base[3] = false;
            }

            batterIndex = (batterIndex + 1) % 9;
        }
    }

    max = Math.max(max, score);
}

}
