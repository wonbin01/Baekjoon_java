import java.io.*;
public class B6064{
    public static StringBuilder sb= new StringBuilder();
public static void main(String args[]) throws IOException
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String input=br.readLine();
    int t=Integer.parseInt(input); //테스트케이스 입력받음
    int[][] MNXY=new int[t][4];
    for(int i=0;i<t;i++)
    {
        input=br.readLine(); //입력받음
        String[] parts=input.split(" ");
        MNXY[i][0]=Integer.parseInt(parts[0]); //m입력받음
        MNXY[i][1]=Integer.parseInt(parts[1]); //n입력받음
        MNXY[i][2]=Integer.parseInt(parts[2]); //x입력받음
        MNXY[i][3]=Integer.parseInt(parts[3]); //y입력받음
        calender(MNXY[i][0], MNXY[i][1], MNXY[i][2], MNXY[i][3]);
    }
    System.out.print(sb);
}    
public static void calender(int m, int n, int x, int y) 
{
    int lcm = lcm(m, n);
    for (int k = x; k <= lcm; k += m) 
    {
        int currentY = (k % n == 0) ? n : k % n;
        if (currentY == y) 
        {
            sb.append(k).append("\n");
            return;
        }
    }
    sb.append(-1).append("\n");
}

public static int gcd(int a, int b) 
{
    while (b != 0) 
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

public static int lcm(int a, int b) 
{
    return a * (b / gcd(a, b));
}
}