import java.io.*;
import java.util.ArrayList;
public class B32979 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int t=Integer.parseInt(br.readLine());
        ArrayList<Integer> al=new ArrayList<>();
        String[] input=br.readLine().split(" ");
        for(int i=0;i<2*n;i++) al.add(Integer.parseInt(input[i]));
        input=br.readLine().split(" ");
        int[] game=new int[t];
        for(int i=0;i<t;i++) game[i]=Integer.parseInt(input[i]);
        for(int i=0;i<t;i++)
        {
            int cnt=game[i]; //몇번째 손인지
            int count=1;
            while(cnt!=count)
            {
                int temp=al.get(0);
                al.remove(0);
                al.add(temp);
                count++;
            }
            sb.append(al.get(0)).append(" ");
        }
        System.out.print(sb);
    }
}
