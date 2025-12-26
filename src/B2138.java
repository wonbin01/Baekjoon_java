import java.io.*;
public class B2138 
{
    static int[] direction=new int[] {-1,0,1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //n개의 스위치와 전구
        String input=br.readLine();
        char[] cur_state=input.toCharArray(); //현재 상태
        input=br.readLine();
        char[] target=input.toCharArray(); // 목표 상태
        //0은 꺼져있는 상태 , 1은 켜져있는 상태
        
    }
}