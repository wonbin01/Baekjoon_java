import java.io.*;
import java.util.LinkedHashSet;
public class B13414 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int k=Integer.parseInt(input[0]); //수강 신청 가능 인원
        int l=Integer.parseInt(input[1]); //대기목록의 길이
        LinkedHashSet<String> set=new LinkedHashSet<>();
        for(int i=0;i<l;i++)
        {
            String studentId=br.readLine();
            set.remove(studentId); //기존 값 제거
            set.add(studentId); //추가
        }
        int count=0;
        for(String id : set)
        {
            System.out.println(id);
            count++;
            if(count==k) break;
        }
    }
}
