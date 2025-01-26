import java.util.Scanner;

public class B1074 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //2^n * 2^n짜리 배열생성, 2^(n-1) * 2^(n-1) 짜리로 4등분
        int r=sc.nextInt(); //r행
        int c=sc.nextInt(); //c열
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
        int half=1<<(n-1); //배열을 절반으로 나눈 크기
        int blocksize=half*half;
        if(r<half&&c<half) //1번 블럭인 경우
        {
            return findzorder(n-1,r,c);
        }
        else if(r<half&&c>=half) //2번 블럭인 경우
        {
            return blocksize+findzorder(n-1,r,c-half);
        }
        else if(r>=half&&c<half) //3번 블럭인 경우
        {
            return 2*blocksize+findzorder(n-1,r-half,c);
        }
        else
        {
            return 3*blocksize+findzorder(n-1,r-half,c-half);
        }
    }
}
