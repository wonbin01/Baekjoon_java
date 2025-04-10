import java.io.*;
import java.util.*;
public class B6198 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //건물의 수가 주어짐
        int[] building=new int[n];
        Stack<Integer> stack=new Stack<>();
        long total=0; //관리자가 보는 전체 개수수
        for(int i=0;i<n;i++)
        {
            int height=Integer.parseInt(br.readLine()); //건물의 높이가 주어짐
            building[i]=height; //건물의 높이 저장
        }
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && stack.peek() <=building[i]) stack.pop(); //나를 볼 수 없는 경우

            total+=stack.size(); //나를 볼 수 있는 건물의 개수
            stack.push(building[i]);
        }
        System.out.println(total);
    }
}
