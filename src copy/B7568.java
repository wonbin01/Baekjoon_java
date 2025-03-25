import java.io.*;
import java.util.*;
public class B7568 
{
    static HashMap<Integer,Integer> height=new HashMap<>();
    static HashMap<Integer,Integer> weight=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //전체 사람의 수 입력
        for(int i=1;i<n+1;i++)
        {
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]); //키
            int y=Integer.parseInt(input[1]); //몸무게
            height.put(i,x);
            weight.put(i,y);
        }
        for(int i=1;i<n+1;i++)
        {
            int count=1;
            for(int j=1;j<n+1;j++)
            {
                if(height.get(i)<height.get(j))
                {
                    if(weight.get(i)<weight.get(j))
                    {
                        count++;
                    }
                }
            }
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}
