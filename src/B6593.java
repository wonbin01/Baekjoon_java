import java.io.*;
import java.util.*;
public class B6593 
{
    static int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; //동서남북
    static int[] direction_2=new int[] {1,-1}; //상하
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input=br.readLine().split(" ");
            int layer=Integer.parseInt(input[0]); //층
            int r=Integer.parseInt(input[1]); //행
            int c=Integer.parseInt(input[2]); //열
            int cnt=0; //총 몇분 걸리는지
            boolean escape=false; //탈출 했는지 여부를 저장

            char[][][] building=new char[layer][r][c]; //건물의 형태
            boolean[][][] visited=new boolean[layer][r][c]; //방문 여부를 저장
            int start_layer=0; int start_r=0; int start_c=0;
            if(layer==0 && r==0 && c==0) break; //모두 다 0인 경우 입력 종료

            for(int i=0;i<layer;i++)
            {
                for(int j=0;j<r;j++)
                {
                    String in=br.readLine();
                    for(int k=0;k<c;k++)
                    {
                        char character=in.charAt(k);
                        building[i][j][k]=character;
                        if(character=='S')
                        {
                            start_layer=i; start_r=j; start_c=k;
                            visited[i][j][k]=true;
                        }
                    }
                }
                br.readLine();
            }
            
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[] {start_layer,start_r,start_c});

            while(!queue.isEmpty())
            {
                int size=queue.size();
                for(int i=0;i<size;i++)
                {
                    int[] node=queue.poll();
                    int cl=node[0]; int cx=node[1]; int cy=node[2];
                    if(building[cl][cx][cy]=='E') //출구에 도달한 경우
                    {
                        sb.append("Escaped in ").append(cnt).append(" minute(s).\n");
                        escape=true;
                        queue.clear(); break;
                    }
                    for(int j=0;j<4;j++)
                    {
                        int nx=cx+direction[j][0]; int ny=cy+direction[j][1];
                        if(nx>=0 && nx<r && ny>=0 && ny<c)
                        {
                            if(!visited[cl][nx][ny] && (building[cl][nx][ny]=='.' || building[cl][nx][ny]=='E')) //아직 방문되지 않았고, 이동할 수있으면
                            {
                                visited[cl][nx][ny]=true;
                                queue.add(new int[] {cl,nx,ny});
                            }
                        }
                    }
                    for(int j=0;j<2;j++)
                    {
                        int nl=cl+direction_2[j];
                        if(nl>=0 && nl<layer)
                        {
                            if(!visited[nl][cx][cy] && (building[nl][cx][cy]=='.' || building[nl][cx][cy]=='E')) //아직 방문되지 않았고, 이동할 수 있으면
                            {
                                visited[nl][cx][cy]=true;
                                queue.add(new int[] {nl,cx,cy});
                            }
                        }
                    }
                }
                cnt++;
            }
            if(escape==false) //탈출하지 못한 경우
            {
                sb.append("Trapped!\n");
            }
        }
        System.out.print(sb);
    }
}
