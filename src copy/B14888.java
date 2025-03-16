import java.io.*;
public class B14888 
{
    static int n;
    static int[] num;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int[] calculater;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); //숫자의 개수
        String[] input=br.readLine().split(" ");
        num=new int[n]; //정수들 저장
        for(int i=0;i<n;i++)
        {
            num[i]=Integer.parseInt(input[i]);
        }
        calculater=new int[4]; // +,-,*,/의 개수 저장
        input=br.readLine().split(" ");
        for(int i=0;i<4;i++)
        {
            calculater[i]=Integer.parseInt(input[i]);
        }
        dfs(1,num[0]);
        System.out.println(maxValue);
        System.out.println(minValue);
        
    }

    static void dfs(int index,int result)
    {
        if(index==n)
        {
            maxValue=Math.max(maxValue,result);
            minValue=Math.min(minValue,result);
            return ;
        }
        for(int i=0;i<4;i++)
        {
            if(calculater[i]>0)
            {
                calculater[i]--; //사용한 연산자 개수 줄이기
                int nextresult=calculate(result,num[index],i);
                dfs(index+1,nextresult);
                calculater[i]++;
            }
        }
    }

    static int calculate(int a, int b, int op) 
    {
        if (op == 0) return a + b;
        if (op == 1) return a - b;
        if (op == 2) return a * b;
        if (op == 3) return a / b; // C++14 방식의 정수 나눗셈 적용
        return 0;
    }
}
