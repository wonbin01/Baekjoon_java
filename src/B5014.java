import java.io.*;
import java.util.*;
public class B5014 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int f=Integer.parseInt(input[0]); //회사의 총 층수
        int current=Integer.parseInt(input[1]); //현재 있는 층층
        int target=Integer.parseInt(input[2]); //목표 층수
        int up=Integer.parseInt(input[3]); //위로 몇칸 이동하는 지
        int down=Integer.parseInt(input[4]); //아래로 몇칸 이동하는 지
        int[] direction=new int[2];
        boolean[] visited=new boolean[f+1]; //방문 여부를 저장
        direction[0]=up; direction[1]=-down; //위아래의 방향 저장
        Queue<Integer> queue=new LinkedList<>();
        queue.add(current); visited[current]=true;
        int cnt=0; //몇번 누르는지
        if(current==target)
        {
            System.out.println(0);
            return;
        }
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int j=0;j<size;j++)
            {
                int cx=queue.poll();
                if(cx==target)
                {
                    System.out.println(cnt);
                    return;
                }
                for(int i=0;i<2;i++)
                {
                    int nx=cx+direction[i];
                    if(nx>=1 && nx<=f && !visited[nx]) //방문되지 않은 경우
                    {
                        visited[nx]=true;
                        queue.add(nx);
                    }
                }
            }
            cnt++;
        }
        
        System.out.println("use the stairs");
    }
}
// u층 위 , d층 아래 해당하는 층이 없으면 엘리베이터는 움직이지 않음
// target에 도착하기위해서 버튼을 최소 몇번 눌러야하는지
// target에 갈 수 없으면 use the stairs 출력