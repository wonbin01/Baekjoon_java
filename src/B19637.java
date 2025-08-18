import java.io.*;
import java.util.HashMap;
public class B19637 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        HashMap<Integer,String> hm=new HashMap<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //칭호의 개수
        int m=Integer.parseInt(input[1]); //캐릭터의 개수
        int[] limit_info=new int[n];
        String[] strength_info=new String[n];
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            String strength=input[0]; //캐릭터의 전투력
            int limit=Integer.parseInt(input[1]); //기준점
            limit_info[i]=limit;
            strength_info[i]=strength;
        }
        for(int i=n-1;i>=0;i--)
        {
            hm.put(limit_info[i],strength_info[i]);
        }
        for(int i=0;i<m;i++)
        {
            int candidate=Integer.parseInt(br.readLine());
            int left=0; int right=n-1;
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(limit_info[mid]>=candidate)
                {
                    right=mid-1;
                }
                else if(limit_info[mid]<candidate)
                {
                    left=mid+1;
                }
            }
            sb.append(hm.get(limit_info[left])).append("\n");
        }
        System.out.println(sb);
    }
}
