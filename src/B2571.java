import java.util.*;

public class B2571 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] number=new int[n];
        for(int i=0;i<n;i++)
        {
            number[i]=sc.nextInt();
        }
        Arrays.sort(number);
        StringBuilder sb=new StringBuilder();
        for(int num : number)
        {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }    
}
