import java.io.*;
public class B2283 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); // 구간의 개수
        int target=Integer.parseInt(input[1]); //길이의 총합
        int max=0;
        int[][] number=new int[n][2];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            number[i][0]=Integer.parseInt(input[0]);
            number[i][1]=Integer.parseInt(input[1]);
            max=Math.max(max,number[i][1]);
        }
        int[] find_gap=new int[max+2]; //몇개의 구간이 겹치는지 확인 가능
        for(int i=0;i<n;i++)
        {
            find_gap[number[i][0]]++; //시작지점에서 +1
            find_gap[number[i][1]]--; //끝지점에서 -1
        }
        for(int i=1;i<=max;i++)
        {
            find_gap[i]+=find_gap[i-1]; //몇개의 구간이 겹치는지 저장
        }
        int start=0; int end=0; int sum=0; boolean found=false;
        while(end<=max)
        {
            if(sum<target) //target보다 작은 경우
            {
                sum+=find_gap[end];
                end++;
            }
            else if(sum>target)
            {
                sum-=find_gap[start];
                start++;
            }
            else
            {
                sb.append(start).append(" ").append(end).append("\n");
                found=true;
                break;
            }
        }
        if(!found) System.out.println("0 0");
        else System.out.print(sb);
    }
}
