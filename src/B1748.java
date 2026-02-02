import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long length = 0;
        for(int i=1;i<=n;i++) {
            if(i<10) length+=1;
            else if(10<=i && i<100) length+=2;
            else if(100<=i && i<1000) length+=3;
            else if(1000<=i && i<10000) length+=4;
            else if(10000<=i && i<100000) length+=5;
            else if(100000<=i && i<1000000) length+=6;
            else if(1000000<=i && i<10000000) length+=7;
            else if(10000000<=i && i<100000000) length+=8;
            else if(i==100000000) length+=9;
        }
        System.out.println(length);
    }
}