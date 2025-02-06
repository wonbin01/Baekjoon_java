import java.io.*;
public class B20922 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" "); //n과 k가 주어짐
        int n=Integer.parseInt(input[0]); int k=Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        int[] number=new int[n];
        int[] visited=new int[100001];
        for(int i=0;i<n;i++)
        {
            number[i]=Integer.parseInt(input[i]); //수열을 입력받음
        }
        int st=0; int en=0; int cnt=0;
        while(en<n)
        {
            visited[number[en]]++;
            while(visited[number[en]]>k)
            {
                visited[number[st]]--;
                st++;
            }
            cnt=Math.max(cnt,en-st+1);
            en++;
        }
        System.out.println(cnt);
    }
}
