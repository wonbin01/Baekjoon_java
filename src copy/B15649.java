import java.util.Scanner;

public class B15649 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //1~n������ �ڿ��� �߿���
        int m=sc.nextInt(); //�ߺ� ���� m���� ��
        int[] result=new int[m]; //���õ� ���ڸ� ����
        boolean[] visited=new boolean[n+1]; //�湮 ���θ� üũ
        print_result(n, m, 0, result, visited);

        sc.close();
    }
    public static void print_result(int n,int m,int depth,int[] result,boolean[] visited)
    {
        if(depth==m) //m���� ��� ������ ���
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
                visited[i]=true; //�湮ó��
                result[depth]=i; //result�� �־���
                print_result(n, m, depth+1, result, visited);
                visited[i]=false; //�湮 �ʱ�ȭ
            }
        }
    }
}
