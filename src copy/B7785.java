import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class B7785 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //로그 개수가 주어짐
        HashMap<String, String> person = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            if(input[1].equals("enter")) //들어온 경우
            {
                person.put(input[0],input[0]);
            }
            else if(input[1].equals("leave")) //나간 경우
            {
                person.remove(input[0]);
            }
        }
        List<String> inCompanyList = new ArrayList<>(person.values());
        Collections.sort(inCompanyList, Collections.reverseOrder());

        for (String name : inCompanyList) 
        {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
