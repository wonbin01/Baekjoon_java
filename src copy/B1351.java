import java.io.*;
import java.util.*;
public class B1351 
{
    static Map<Long,Long> memo=new HashMap<>();
    public static long solve(long n,long p,long q)
    {
        if(n==0) return 1;
        if(memo.containsKey(n)) return memo.get(n);

        long result=solve(n/p,p,q)+solve(n/q,p,q);
        memo.put(n,result);
        return result;
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        long n=Long.parseLong(input[0]);
        long p=Long.parseLong(input[1]);
        long q=Long.parseLong(input[2]);
        System.out.println(solve(n,p,q));
    }
}
