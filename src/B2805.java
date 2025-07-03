import java.io.*;
import java.util.*;
public class B2805 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //나무의 수
        int m=Integer.parseInt(input[1]); //집에 가져가려하는 나무의 길이
        input=br.readLine().split(" ");
        int[] tree=new int[n];
        for(int i=0;i<n;i++)
        {
            tree[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(tree);
        int left=0; int right=tree[n-1];
        int max_length=Integer.MIN_VALUE;
        while(left<=right)
        {
            int mid=(left+right)/2;
            long length=0;
            for(int t : tree)
            {
                if(mid<t)
                {
                    length+=t-mid;
                }
            }
            if(length>=m)
            {
                left=mid+1;
                max_length=Math.max(max_length,mid);
            }
            else
            {
                right=mid-1;
            }
        }
        System.out.println(max_length);
    }
}
