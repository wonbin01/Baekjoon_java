import java.io.*;
public class B19941 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //식탁의 길이
        int k=Integer.parseInt(input[1]); //햄버거를 선택할 수 있는 거리
        String info=br.readLine();
        char[] desk=new char[n]; //식탁의 구성
        boolean[] visited=new boolean[n]; //햄버거를 먹었는지 아닌지
        int result=0;
        for(int i=0;i<n;i++)
        {
            desk[i]=info.charAt(i);
        }
        for(int i=0;i<n;i++)
        {
            if(desk[i]=='P') //사람인 경우
            {
                for(int j=i-k;j<i+k+1;j++)
                {
                    if(j>=0 && j<n && desk[j]=='H' && !visited[j]) //햄버거가 아직 방문되지 않았을때
                    {
                        visited[j]=true; //방문 처리
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
