import java.io.*;
import java.util.*;
public class B1781 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //숙제의 개수
        List<int[]> assignment=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            int deadline=Integer.parseInt(input[0]);
            int ramen=Integer.parseInt(input[1]);
            assignment.add(new int[]{deadline,ramen});
        }

        assignment.sort(Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int[] assignments : assignment)
        {
            pq.add(assignments[1]); //라면의 개수 추가
            if(pq.size()>assignments[0]) //현재 데드라인보다 많은 숙제를 선택했다면
            {
                pq.poll(); //가장 작은 컵라면 수를 버림
            }
        }
        int total=0;
        while(!pq.isEmpty())
        {
            total+=pq.poll();
        }
        System.out.println(total);
    }    
}
