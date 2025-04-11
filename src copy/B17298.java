import java.io.*;
import java.util.*;
public class B17298 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //수열의 크기
        int[] number=new int[n];
        String[] input=br.readLine().split(" ");
        int[] height=new int[n]; //자신보다 높은 빌딩의 높이를 저장장
        Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty())
            {
                if(stack.peek() <= number[i])
                {
                    stack.pop();
                }
                else if(stack.peek() > number[i])
                {
                    height[i]=stack.peek();
                    break;
                }
            }
            if(stack.isEmpty()) height[i]=-1;
            stack.push(number[i]);
        }
        for(int key : height)
        {
            sb.append(key).append(" ");
        }
        System.out.print(sb);
    }
}
