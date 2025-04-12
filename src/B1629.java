import java.util.Scanner;

public class B1629 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextInt(); //a��
        long b=sc.nextInt(); //b�� ���Ѽ���
        long c=sc.nextInt(); //c�� ���� ������ ���
        long remain=Remain(a, b, c);
        System.out.println(remain);
        sc.close();
    }
    public static long Remain(long a,long b,long c)
    {
        if(b==0)
        {
            return 1;
        }
        long half=Remain(a, b/2, c);
        long result=(half*half)%c;
        if(b%2!=0)
        {
            result=(result*a)%c;
        }
        return result;
    }
    
}
