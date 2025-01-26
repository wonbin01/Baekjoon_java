import java.util.*;
public class B11728 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //�迭 a�� ũ��
        int m=sc.nextInt(); //�迭 b�� ũ��
        int[] array_a=new int[n];
        int[] array_b=new int[m];
        for(int i=0;i<n;i++)
        {
            array_a[i]=sc.nextInt();
        }
        for(int j=0;j<m;j++)
        {
            array_b[j]=sc.nextInt();
        }
        add_array(array_a, array_b);

        sc.close();
    }   
    public static void add_array(int[] array_a,int[] array_b) //�� �迭�� ��ġ�� �޼���
    {
        int n=array_a.length;
        int m=array_b.length;
        int[] merge=new int[n+m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            merge[cnt]=array_a[i];
            cnt++;
        }
        for(int i=0;i<m;i++)
        {
            merge[cnt]=array_b[i];
            cnt++;
        }
        //merge�迭�� �����ϴ� �κ� ����
        Arrays.sort(merge);
        StringBuilder sb=new StringBuilder();
        for(int element : merge)
        {
            sb.append(element+" ");
        }
        System.out.println(sb);
    } 
}
