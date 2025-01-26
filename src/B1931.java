import java.io.*;
import java.util.*;
public class B1931 
{
    public static int cnt=0; //회의의 최대 개수
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[][] timetable=new int[n][2];
        for(int i=0;i<n;i++) //입력받는 과정
        {
            String input=br.readLine();
            String[] times=input.split(" ");
            timetable[i][0]=Integer.parseInt(times[0]); //시작시간
            timetable[i][1]=Integer.parseInt(times[1]); //종료시간
        }
        Arrays.sort(timetable, (a, b) ->  //종료시간을 기준으로 정렬
        {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // 시작 시간 오름차순
            }
            return Integer.compare(a[1], b[1]); // 종료 시간 오름차순
        });
        int end_min=timetable[0][1]; //가장 빨리 끝나는 시간 저장
        cnt++;
        for(int i=1;i<n;i++)
        {
            if(end_min<=timetable[i][0]) //끝나는 시간보다 큰 시간 시간을 만날때
            {
                end_min=timetable[i][1];
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.print(sb);
    }
}
