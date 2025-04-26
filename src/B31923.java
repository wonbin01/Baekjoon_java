import java.io.*;
public class B31923 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); int p=Integer.parseInt(input[1]);
        int q=Integer.parseInt(input[2]); //꼬치, 딸기, 샤인머스캣
        int[] cnt=new int[n]; //몇번 꽂은지 저장
        input=br.readLine().split(" ");
        int[] berry=new int[n]; int[] shine=new int[n];
        for(int i=0;i<n;i++) berry[i]=Integer.parseInt(input[i]);
        input=br.readLine().split(" ");
        for(int i=0;i<n;i++) shine[i]=Integer.parseInt(input[i]);

        for(int i=0;i<n;i++)
        {
            int temp_b=berry[i];
            int temp_s=shine[i]; //현재 꽂혀있는 개수를 저장
            if(temp_b==temp_s)
            {
                cnt[i]=0; continue;
            }
            int count=0;
            boolean check=false; //yes or no확인하는 변수수
            while(count<10000)
            {
                temp_b+=p; temp_s+=q;
                count++;
                if(temp_b==temp_s)
                {
                    cnt[i]=count;
                    check=true;
                    break;
                }
            }
            if(!check)
            {
                System.out.println("NO");
                return;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int k : cnt)
        {
            sb.append(k).append(" ");
        }
        System.out.println("YES");
        System.out.print(sb);
    }    
}
//각 꼬치에 딸기 p개, 머스캣 q개씩 꽂음