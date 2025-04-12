import java.io.*;
import java.util.*;
public class B19700 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    
        int n=Integer.parseInt(br.readLine()); //수강생의 수
        int[][] student=new int[n][2]; //학생들의 정보([0]에는 키, [1]에는 등수)
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            student[i][0]=Integer.parseInt(input[0]);
            student[i][1]=Integer.parseInt(input[1]);
        }
        Arrays.sort(student,new student_com()); //키 큰 순서부터 차례대로 정렬시킴
        
        TreeMap<Integer,Integer> teams=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            int maxtall=student[i][1];
            Integer key=teams.lowerKey(maxtall); //이게 존재하면 들어갈 수 있음
            if(key!=null)
            {
                teams.put(key+1,teams.getOrDefault(key+1, 0)+1); //집어넣음
                if(teams.get(key)==1) //하나만 존재하는 경우
                {
                    teams.remove(key);
                }
                else if(teams.get(key)>1)
                {
                    teams.put(key,teams.get(key)-1);
                }
            }
            else //새로운 팀을 생성함
            {
                teams.put(1,teams.getOrDefault(1,0)+1);
            }
        }
        int totalteams=0;
            for(int count : teams.values())
            {
                totalteams+=count;
            }
            System.out.println(totalteams);

    }
    public static class student_com implements Comparator<int[]>
    {
        @Override
        public int compare(int[] a,int[] b)
        {
            return Integer.compare(b[0],a[0]);
        }
    }
}
