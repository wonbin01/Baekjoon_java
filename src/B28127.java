import java.io.*;
public class B28127 
{
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++)
        {
            String[] input=br.readLine().split(" ");
            int a=Integer.parseInt(input[0]);
            int d=Integer.parseInt(input[1]);
            int x=Integer.parseInt(input[2]);
            int floor=1;
            while(true)
            {
                int total = floor * a + d * (floor * (floor - 1) / 2);
                int block_first = (floor - 1) * a + d * ((floor - 1) * (floor - 2) / 2) + 1;
                if(x >= block_first && x <= total)
                {
                    sb.append(floor).append(" ").append(x - block_first + 1).append("\n");
                    break;
                }
                floor++;
            }
        }
        System.out.print(sb);
    }
}