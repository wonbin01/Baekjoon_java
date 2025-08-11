import java.io.*;
import java.util.Arrays;
public class B2512 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] request=new int[n]; //예산 요청
        for(int i=0;i<n;i++)
        {
            request[i]=Integer.parseInt(input[i]);
        }
        int maximum=Integer.parseInt(br.readLine()); //총액
        Arrays.sort(request);
        int total=0;
        for(int quantity : request)
        {
            total+=quantity;
        }
        if(total<=maximum) //예산 요청의 합이 총액보다 작은 경우
        {
            System.out.println(request[n-1]);
            return;
        }
        int low=0; int high=request[n-1]; int result=0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            long currentBudget=0;
            for(int s : request)
            {
                currentBudget+=Math.min(s, mid);
            }
            if(currentBudget<=maximum)
            {
                result=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        System.out.println(result);
    }
}
// 총액을 남은 개수로 나눈 몫이 현재 값보다 크면, 그대로// 몫이 현재 값보다 작으면 끝