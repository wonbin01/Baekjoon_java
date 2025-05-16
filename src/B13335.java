import java.io.*;
import java.util.*;
import java.util.LinkedList;
public class B13335 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //다리를 건너는 트럭의 수
        int w=Integer.parseInt(input[1]); //다리의 길이
        int l=Integer.parseInt(input[2]); //다리의 최대하중
        int[] weight=new int[n]; //트럭의 무게를 저장
        input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            weight[i]=Integer.parseInt(input[i]);
        }
        int current_weight=0; //현재 다리에 가중되는 무게
        int current_time=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {weight[0],w+1});
        int current=1;
        current_weight=weight[0]; //현재 다리에 가중
        while(!queue.isEmpty())
        {
            current_time++;
            if(queue.peek()[1]<=current_time) //맨 앞에 있는 트럭이 다리를 건너간 이후면
            {
                current_weight-=queue.peek()[0]; //가중된 무게에서 빼야됨
                queue.poll();
            }
            if(current<weight.length &&current_weight+weight[current]<=l) //다리에 다음차가 올라올 수 있음
            {
                current_weight+=weight[current];
                queue.add(new int[] {weight[current],current_time+w});
                current++;
            }
        }
        System.out.println(current_time);
    }
}
