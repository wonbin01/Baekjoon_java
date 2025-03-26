import java.io.*;
import java.util.*;
public class B25757 
{
    static HashSet<String> set=new HashSet<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //플레이하기를 신청한 횟수
        int required=0; //게임하는 데 필요한 사람의 수
        int total=0; //최대 게임 횟수
        if(input[1].equals("Y"))
        {
            required=1;
        }
        else if(input[1].equals("F"))
        {
            required=2;
        }
        else if(input[1].equals("O"))
        {
            required=3;
        }
        for(int i=0;i<n;i++)
        {
            String name=br.readLine();
            set.add(name);
        }
        int length=set.size(); //set의 크기를 구함
        total=length/required;
        System.out.println(total);
    }
}
//Y-2,F-3,O-4
//한번 플레이한 사람과는 다시 플레이 하지 않음