import java.io.*;
import java.util.*;
public class B16234 
{
    static int[][] direction=new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException
    {
        int day_cnt=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //n*n의 크기
        int low=Integer.parseInt(input[1]); // 최소한의 인구수 차이
        int high=Integer.parseInt(input[2]); // 최대한의 인구수 차이
        int[][] population=new int[n][n];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                population[i][j]=Integer.parseInt(input[j]);
            }
        }
        while (true) 
        {
            HashMap<Integer,ArrayList<int[]>> hm=new HashMap<>();
            int team=1;
            int[][] union=new int[n][n]; //연합팀의 팀 번호를 적음
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(union[i][j]!=0) continue;
                    union[i][j]=team;
                    hm.putIfAbsent(team,new ArrayList<>());
                    hm.get(team).add(new int[] {i,j});
                    Stack<int[]> stack=new Stack<>();
                    stack.add(new int[] {i,j,population[i][j],team}); //좌표와 인구수 + 연합팀의 번호
                    while(!stack.isEmpty())
                    {
                        int[] cur=stack.pop();
                        int cx=cur[0]; int cy=cur[1]; 
                        int cur_population=cur[2]; int cur_team=cur[3];
                        for(int k=0;k<4;k++)
                        {
                            int nx=cx+direction[k][0]; int ny=cy+direction[k][1];
                            if(nx>=0 && nx<n && ny>=0 && ny<n && union[nx][ny]==0&&
                            Math.abs(cur_population-population[nx][ny])>=low &&
                            Math.abs(cur_population-population[nx][ny])<=high)
                            {
                                union[nx][ny]=cur_team;
                                stack.add(new int[] {nx,ny,population[nx][ny],cur_team});
                                hm.get(cur_team).add(new int[] {nx,ny});
                            }
                        }
                    }
                    team++;
                }
            }
            boolean breaking=true; //인구가 움직였는지 아닌지 확인
            for(int key : hm.keySet())
            {
                ArrayList<int[]> al=hm.get(key);
                if(al.size()==1) continue;
                breaking=false;
                int team_size=al.size();
                int population_total=0;
                for(int[] cur : al)
                {
                    int row=cur[0]; int col=cur[1];
                    population_total+=population[row][col];
                }
                int avg=population_total/team_size;
                for(int[] cur : al)
                {
                    int row=cur[0]; int col=cur[1];
                    population[row][col]=avg;
                }
            }
            if(breaking) break;
            day_cnt++;
        }
        System.out.println(day_cnt);
    }
}
