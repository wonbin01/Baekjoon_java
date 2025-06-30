import java.io.*;
public class B1439 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        char before=input.charAt(0);
        int count_zero=(before=='0') ? 1:0;
        int count_one=(before=='1') ? 1:0;
        if(input.length()==1)
        {
            System.out.println(0);
            return;
        }
        for(int i=1;i<input.length();i++)
        {
            char current=input.charAt(i);
            if(before==current) //연속적인 경우
            {
                continue;
            }
            else if(before!=current && before=='1')
            {
                count_zero++;
                before=current;
            }
            else if(before!=current && before=='0')
            {
                count_one++;
                before=current;
            }
        }
        System.out.println(Math.min(count_one, count_zero));
    }
}
