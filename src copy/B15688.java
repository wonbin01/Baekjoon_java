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
        for(int i=0;i<n;i++) //���ڸ� �Է¹���
        {
            number[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(number); //���ڸ� ���Ľ�Ŵ
        StringBuilder sb=new StringBuilder(); //print�Ҷ� ���
        for(int num : number)
        {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
        br.close();
    }    
}
