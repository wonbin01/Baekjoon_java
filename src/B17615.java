import java.io.*;
public class B17615 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); // 불의 개수가 주어짐
        String input=br.readLine();
        int totalR=0; int totalB=0;
        for(int i=0;i<n;i++)
        {
            if(input.charAt(i)=='R') totalR++;
            else totalB++;
        }
        int leftR = 0;
        for (int i = 0; i < n && input.charAt(i) == 'R'; i++) leftR++;

        int rightR = 0;
        for (int i = n - 1; i >= 0 && input.charAt(i) == 'R'; i--) rightR++;

        int leftB = 0;
        for (int i = 0; i < n && input.charAt(i) == 'B'; i++) leftB++;

        int rightB = 0;
        for (int i = n - 1; i >= 0 && input.charAt(i) == 'B'; i--) rightB++;

        int answer=Integer.MAX_VALUE;
        answer=Math.min(answer,totalR-leftR);
        answer=Math.min(answer,totalR-rightR);
        answer=Math.min(answer,totalB-leftB);
        answer=Math.min(answer,totalB-rightB);
        System.out.println(answer);
    }
}
