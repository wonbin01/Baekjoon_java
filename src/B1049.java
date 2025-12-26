import java.io.*;

public class B1049
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //끊어진 기타줄의 개수
        int m=Integer.parseInt(input[1]); //기타줄 브랜드의 개수
        int[][] guitar_info=new int[m][2]; //기타줄의 정보
        int minimal_package=Integer.MAX_VALUE; //패키지 중에서 가장 싼거
        int minimal_normal=Integer.MAX_VALUE; //일반 중에서 가장 싼거
        int total_price=0;
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int packagePrice=Integer.parseInt(input[0]); //패키지 가격 -> 패키지에는 6개 들어있음
            int normalPrice=Integer.parseInt(input[1]); //낱개 가격
            guitar_info[i][0]=packagePrice;
            guitar_info[i][1]=normalPrice;
            minimal_package=Math.min(minimal_package,packagePrice);
            minimal_normal=Math.min(minimal_normal,normalPrice);
        }
        while(n>0){
            if(n<=6) { //6개보다 같거나 작은지 확인
            int min=Math.min(minimal_package,minimal_normal*n);
            total_price+=min;
            n-=6;
        }
        if(n>6) { //6개보다 큰지 확인
            int min=Math.min(minimal_package,minimal_normal*6);
            total_price+=min;
            n-=6;
        }
        }
         System.out.println(total_price);   
    }
}