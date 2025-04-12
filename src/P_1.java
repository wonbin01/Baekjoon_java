import java.io.*;
public class P_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //상자의 개수
        int w=Integer.parseInt(input[1]); //상자의 가로 개수
        int num=Integer.parseInt(input[2]); //꺼내려는 상자의 개수

        int[][] box=new int[101][w+1];
        for(int i=1;i<=n;i++)
        {
            int floor=(i-1)/w+1;
            int block;
            if(floor%2==0) //짝수 층인경우
            {
                int right_start=(floor-1)*w+1;
                block=w-(i-right_start);
                box[floor][block]=1;
            }
            else //홀수 층인경우
            {
                int left_start=(floor-1)*w+1;
                block=i-left_start+1;
                box[floor][block]=1;
            }
        }
        int target_floor=(num-1)/w+1; // 꺼내려는 상자의 층
        int target_block;
        if(target_floor%2==0) //짝수 층인경우
        {
            int right_start=(target_floor-1)*w+1;
            target_block=w-(num-right_start);
        }
        else //홀수 층인 경우
        {
            int left_start=(target_floor-1)*w+1;
            target_block=num-left_start+1;
        }
        int count=0;
        int box_floor=(n-1)/w+1;
        for(int i=target_floor;i<=box_floor;i++)
        {
            if(box[i][target_block]==1)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}