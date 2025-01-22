import java.util.Scanner;

public class B1182 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int[] sequence=new int[n];
        for(int i=0;i<n;i++)
        {
            sequence[i]=sc.nextInt();
        }
        Number number=new Number(n, s, sequence);
        number.result(0, 0);
        int result=number.getcnt();
        if(s==0)
        {
            result-=1;
        }
        System.out.println(result);
        sc.close();
    }
    public static class Number
    {
        private int n;
        private int s;
        private int[] sequence;
        private int cnt=0;
        public Number(int n,int s,int[] sequence)
        {
            this.n=n;
            this.s=s;
            this.sequence=sequence;
        }
        public void result(int current,int total)
        {
            if(current==n) //배열의 끝에 도달한 경우
            {
                if(total==s)
                {
                    cnt++;
                }
                return ;
            }
            result(current+1,total);
            result(current+1,total+sequence[current]);
        }
        public int getcnt()
        {
            return cnt;
        }
    }
}
