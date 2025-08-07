import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class B2164 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
            queue.add(i);
        }
        int length=n;
        while(length!=1)
        {
            queue.poll();
            int front=queue.poll();
            queue.add(front);
            length--;
        }
        System.out.println(queue.peek());
    }
}
