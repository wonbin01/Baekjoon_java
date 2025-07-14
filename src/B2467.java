import java.io.*;
public class B2467 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] liquid=new int[n];
        for(int i=0;i<n;i++)
        {
            liquid[i]=Integer.parseInt(input[i]);
        }
        int left=0; int right=n-1; //left와 right를 저장
        int s1=0; int s2=n-1; //각각 인덱스를 저장
        int mixed=Integer.MAX_VALUE; //0에 가장 가까운 값을 저장
        while(left<right)
        {
            int sum=liquid[left]+liquid[right];
            if(Math.abs(sum)<mixed)
            {
                mixed=Math.abs(sum);
                s1=left; s2=right;
            }
            if(sum<0) left++;
            else right--;
        }
        System.out.println(liquid[s1]+" "+liquid[s2]);
    }
}
