import java.io.*;
import java.util.Arrays;

public class B1978 
{
    public static int cnt=0;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int n=Integer.parseInt(input); //n을 입력받음
        int[] number=new int[n]; //숫자 입력받음
        input=br.readLine();
        String[] inputs=input.split(" ");
        for(int i=0;i<n;i++) //숫자를 입력받음
        {
            number[i]=Integer.parseInt(inputs[i]);
        }
        isPrime(number);
        System.out.println(cnt);
    }

    public static void isPrime(int[] number)
    {
        int max = Arrays.stream(number).max().getAsInt();
        boolean[] Prime = new boolean[max + 1];
        Arrays.fill(Prime, true);
        Prime[0] = Prime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (Prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    Prime[j] = false;
                }
            }
        }

        for (int num : number) {
            if (Prime[num]) {
                cnt++;
            }
        }
    }
}