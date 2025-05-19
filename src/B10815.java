import java.io.*;
import java.util.*;
class B10815
{
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //숫자카드의 개수
        int[] numberCards=new int[n];
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            numberCards[i]=Integer.parseInt(input[i]);
        }
        int m=Integer.parseInt(br.readLine());
        int[] targetCards=new int[m]; //가지고 있는 숫자 카드인지 확인
        input=br.readLine().split(" ");
        for(int i=0;i<m;i++)
        {
            targetCards[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(numberCards);
        for(int i=0;i<m;i++)
        {
            int target=targetCards[i];
            int get=GetOrNot(target, numberCards);
            sb.append(get).append(" ");
        }
        System.out.println(sb);
    }
    public static int GetOrNot(int target,int[] numberCards)
    {
        int front=0; int end=numberCards.length-1;
        while(front<=end)
        {
            int mid=(front+end)/2;
            if(target>numberCards[mid])
            {
                front=mid+1;
            }
            else if(target<numberCards[mid])
            {
                end=mid-1;
            }
            else
            {
                return 1;
            }
        }
        return 0;
    }
}