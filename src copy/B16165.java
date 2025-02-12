import java.io.*;
import java.util.*;
public class B16165 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //걸그룹의 수
        int m=Integer.parseInt(input[1]); //문제의 수
        Map<String,String> memberToGroup=new HashMap<>();
        Map<String,ArrayList<String>> groupToMembers=new HashMap<>();
        for(int i=0;i<n;i++) //걸그룹을 입력받음
        {
            String group_name=br.readLine(); //걸그룹의 이름을 입력받음
            int member_count=Integer.parseInt(br.readLine()); //멤버의 수를 입력받음
            ArrayList<String> member=new ArrayList<>();
            for(int j=0;j<member_count;j++) //hash에 집어넣을거임
            {
                String name=br.readLine(); //멤버의 이름을 입력받음
                memberToGroup.put(name,group_name);
                member.add(name); //Arraylist에 집어넣음
            }
            Collections.sort(member);
            groupToMembers.put(group_name,member); //그룹의 이름이 주어지면 멤버들을 출력함
        }
        for(int i=0;i<m;i++) //m개의 퀴즈를 입력받음
        {
            String quiz=br.readLine(); //문제를 입력받음
            int quiz_type=Integer.parseInt(br.readLine()); //타입을 입력받음
            if(quiz_type==1) //type==1인 경우 멤버의 이름이 주어짐 (그룹을 출력)
            {
                sb.append(memberToGroup.get(quiz)).append("\n");
            }
            else if(quiz_type==0) //type==0인 경우 그룹의 이름이 주어짐 (멤버의 이름을 출력)
            {
                ArrayList<String> list=groupToMembers.get(quiz);
                for(String membername : list)
                {
                    sb.append(membername).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
