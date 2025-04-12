import java.io.*;
public class B2531 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //접시의 수
        int d=Integer.parseInt(input[1]); //초밥의 가짓수
        int k=Integer.parseInt(input[2]); //연속해서 먹는 접시의 수
        int c=Integer.parseInt(input[3]); //쿠폰 번호
        int[] plate=new int[n];
        for(int i=0;i<n;i++)
        {
            plate[i]=Integer.parseInt(br.readLine());
        }
        int[] visited=new int[d+1]; //다 0으로 초기화
        int cnt=0,max=0;
        for(int i=0;i<k;i++)
        {
            if(visited[plate[i]]==0) cnt++;
            visited[plate[i]]++;
        }
        if(visited[c]==0) max=cnt+1;
        else max=cnt;

        for(int start=0;start<n;start++)
        {
            int end=(start+k)%n; //원형 인덱스 처리
            if(visited[plate[end]]==0) cnt++;
            visited[plate[end]]++;

            visited[plate[start]]--;
            if(visited[plate[start]]==0) cnt--;

            if(visited[c]==0) max=Math.max(max,cnt+1);
            else max=Math.max(max,cnt);
        }
        System.out.println(max);
    }
}