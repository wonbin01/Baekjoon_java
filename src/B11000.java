import java.io.*;
import java.util.*;
class B11000
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in=br.readLine();
        int n=Integer.parseInt(in);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0])
            {
                return Integer.compare(a[1], b[1]);
            }
            else
            {
                return Integer.compare(a[0], b[0]);
            }
        });
        int last_time=Integer.MIN_VALUE; //마지막 끝나는 시간을 저장
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            int start_time=Integer.parseInt(input[0]);
            int end_time=Integer.parseInt(input[1]);
            pq.add(new int[] {start_time,end_time});
            last_time=Math.max(last_time,end_time);
        }
        PriorityQueue<Integer> roomQueue=new PriorityQueue<>(); //끝나는 시간 기준으로 관리
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int start=curr[0]; int end=curr[1];
            if(!roomQueue.isEmpty() && roomQueue.peek()<=start)
            {
                roomQueue.poll(); //끝난 강의실 제거
            }
            roomQueue.add(end); //새로 강의실 추가 또는 기존에 사용하던 걸 갱신
        }
        System.out.println(roomQueue.size());
    }
}