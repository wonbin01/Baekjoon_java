import java.io.*;
public class B1138 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        int[] tall_info=new int[n]; //키가 1인 사람부터 왼쪽에 몇명있는지 저장
        for(int i=0;i<n;i++)
        {
            tall_info[i]=Integer.parseInt(input[i]);
        }
        int[] link=new int[n];
        for(int i=0;i<n;i++)
        {
            int height=i+1;
            int limitCount=tall_info[i];

            for(int j=0;j<n;j++)
            {
                if(link[j]!=0) continue; //비어있지 않은 경우
                if(limitCount==0)
                {
                    link[j]=height;
                    break;
                }
                limitCount--;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int l : link)
        {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}
