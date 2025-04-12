import java.io.*;
import java.util.*;
public class B2493 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] receive=new int[n+1];
        Stack<int[]> stack=new Stack<>();
        String[] input=br.readLine().split(" ");
        for(int i=1;i<n+1;i++)
        {
            int height=Integer.parseInt(input[i-1]);

            while(!stack.isEmpty() && stack.peek()[1] < height) stack.pop();

            if(!stack.isEmpty()) //비어있지 않은 경우
            {
                receive[i]=stack.peek()[0];
            }
            else
            {
                receive[i]=0;
            }
            stack.push(new int[] {i,height});
        }
        // 결과 출력
        for (int i = 1; i <= n; i++) {
            sb.append(receive[i]).append(" ");
        }
        System.out.println(sb);
    }
}
