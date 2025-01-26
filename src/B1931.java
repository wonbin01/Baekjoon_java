import java.io.*;
import java.util.*;
public class B1931 
{
    public static int cnt=0; //ȸ���� �ִ� ����
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[][] timetable=new int[n][2];
        for(int i=0;i<n;i++) //�Է¹޴� ����
        {
            String input=br.readLine();
            String[] times=input.split(" ");
            timetable[i][0]=Integer.parseInt(times[0]); //���۽ð�
            timetable[i][1]=Integer.parseInt(times[1]); //����ð�
        }
        Arrays.sort(timetable, (a, b) ->  //����ð��� �������� ����
        {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // ���� �ð� ��������
            }
            return Integer.compare(a[1], b[1]); // ���� �ð� ��������
        });
        int end_min=timetable[0][1]; //���� ���� ������ �ð� ����
        cnt++;
        for(int i=1;i<n;i++)
        {
            if(end_min<=timetable[i][0]) //������ �ð����� ū �ð� �ð��� ������
            {
                end_min=timetable[i][1];
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.print(sb);
    }
}
