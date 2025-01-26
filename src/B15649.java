import java.util.Scanner;

public class B15649 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //1~n까지의 자연수 중에서
        int m=sc.nextInt(); //중복 없이 m개를 고름
        int[] result=new int[m]; //선택된 숫자를 저장
        boolean[] visited=new boolean[n+1]; //방문 여부를 체크
        print_result(n, m, 0, result, visited);

        sc.close();
    }
    public static void print_result(int n,int m,int depth,int[] result,boolean[] visited)
    {
        if(depth==m) //m개를 모두 선택한 경우
        {
            for(int num:result)
            {
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                visited[i]=true; //방문처리
                result[depth]=i; //result에 넣어줌
                print_result(n, m, depth+1, result, visited);
                visited[i]=false; //방문 초기화
            }
        }
    }
}
