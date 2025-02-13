import java.io.*;
import java.util.*;
public class B19583 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] time=br.readLine().split(" ");
        String entry=time[0]; String end=time[1]; String streamming=time[2];

        Set<String> entered=new HashSet<>();
        Set<String> attended=new HashSet<>();
        String input;
        while(true)
        {
            input=br.readLine();
            if(input==null || input.isEmpty()) break;
            String[] input2=input.split(" ");
            String chatTime=input2[0]; String nickname=input2[1];

            if(chatTime.compareTo(entry)<=0)
            {
                entered.add(nickname);
            }
            if(chatTime.compareTo(end)>=0 && chatTime.compareTo(streamming)<=0)
            {
                if(entered.contains(nickname))
                {
                    attended.add(nickname);
                }
            }
        }
        System.out.println(attended.size());
    }
}
//개강총회 시작시간 이전에 입장 여부를 확인
//개강총회 끝나고 나서 스트리밍이 끝나기 전까지 채팅으로 퇴장 확인