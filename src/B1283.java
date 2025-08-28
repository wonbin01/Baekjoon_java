import java.io.*;
public class B1283 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //옵션의 개수
        boolean[] option=new boolean[26];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            int cnt=input.length;
            boolean insert=false; //현재 단어중에서 옵션으로 등록된지 확인
            for(int j=0;j<cnt;j++)
            {
                String candidate=input[j];
                String lowerStr=candidate.toLowerCase();
                char c=lowerStr.charAt(0); //단어의 첫번쨰 문자
                if(option[c-'a']) continue; //단어의 첫번째 단어가 등록된 경우 다음으로 이동
                else // 단어의 첫번째 문자가 등록되지 않은 경우
                {
                    option[c-'a']=true;
                    insert=true;
                    for(int k=0;k<cnt;k++)
                    {
                        if(k!=j) //옵션 넣지 않아도 되는 부분은 그냥 sb에 추가
                        {
                            sb.append(input[k]).append(" ");
                        }
                        else //옵션을 넣어야하는 위치인 경우, 괄호 추가해서 sb에 추가
                        {
                            String insertedString=changeString(candidate, 0);
                            sb.append(insertedString).append(" ");
                        }
                    }
                    break;
                }
            }
            if(insert) //옵션 입력된 경우
            {
                sb.append("\n");
                continue;
            }
            //옵션이 입력되지 않은 경우
            for(int j=0;j<cnt;j++) 
            {
                String candidate=input[j];
                if(insert)
                {
                    sb.append(candidate).append(" ");
                    continue;
                }
                for(int k=0;k<candidate.length();k++) 
                {
                    char c=Character.toLowerCase(candidate.charAt(k));
                    if(!option[c-'a']) 
                    {
                        option[c-'a']=true;
                        sb.append(changeString(candidate,k)).append(" ");
                        insert=true;
                        break;
                    }
                }
                if(!insert) sb.append(candidate).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        }        
    public static String changeString(String candiate,int index)
    {
        int length=candiate.length(); //단어의 길이
        StringBuilder builder =new StringBuilder();
        for(int i=0;i<length;i++)
        {
            if(i==index)
            {
                builder.append('[').append(candiate.charAt(index)).append(']');
            }
            else
            {
                builder.append(candiate.charAt(i));
            }
        }
        return builder.toString();
    }
}
