import java.io.*;
import java.util.*;
public class B1822 
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> al=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //A의 원소개수
        int m=Integer.parseInt(input[1]); //B의 원소개수
        int[] A=new int[n];
        int[] B=new int[m];
        input=br.readLine().split(" ");
        for(int i=0;i<n;i++) A[i]=Integer.parseInt(input[i]);
        input=br.readLine().split(" ");
        for(int i=0;i<m;i++) B[i]=Integer.parseInt(input[i]);

        Arrays.sort(A); Arrays.sort(B);
        for(int i=0;i<n;i++)
        {
            int target=A[i];
            boolean correct=find_in_B(B, target);
            if(correct) al.add(target);
        }
        StringBuilder sb=new StringBuilder();
        if(al.size()==0)
        {
            System.out.println(0);
            return;
        }
        sb.append(al.size()).append("\n");
        for(int key : al)
        {
            sb.append(key).append(" ");
        }
        System.out.print(sb);
    }
    static boolean find_in_B(int[] B,int target) //B에 속하지 않으면 true, 속하면 false
    {
        int front=0; int end=B.length-1;
        while(front<=end)
        {
            int mid=(front+end)/2;
            if(B[mid]<target)
            {
                front=mid+1;
            }
            else if(B[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
