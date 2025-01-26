import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15688 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] number=new int[n];
        for(int i=0;i<n;i++) //숫자를 입력받음
        {
            number[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(number); //숫자를 정렬시킴
        StringBuilder sb=new StringBuilder(); //print할때 사용
        for(int num : number)
        {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
        br.close();
    }    
}
