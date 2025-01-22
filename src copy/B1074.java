import java.util.Scanner;

public class B1074 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //2^n * 2^n¥�� �迭����, 2^(n-1) * 2^(n-1) ¥���� 4���
        int r=sc.nextInt(); //r��
        int c=sc.nextInt(); //c��
        sc.close();
        int result=findzorder(n,r,c);
        System.out.println(result);
    }
    public static int findzorder(int n, int r, int c)
    {
        if(n==0)
        {
            return 0;
        }
        int half=1<<(n-1); //�迭�� �������� ���� ũ��
        int blocksize=half*half;
        if(r<half&&c<half) //1�� ���� ���
        {
            return findzorder(n-1,r,c);
        }
        else if(r<half&&c>=half) //2�� ���� ���
        {
            return blocksize+findzorder(n-1,r,c-half);
        }
        else if(r>=half&&c<half) //3�� ���� ���
        {
            return 2*blocksize+findzorder(n-1,r-half,c);
        }
        else
        {
            return 3*blocksize+findzorder(n-1,r-half,c-half);
        }
    }
}
