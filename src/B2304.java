import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B2304 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); // 기둥의 개수
        ArrayList<int[]> al=new ArrayList<>();
        
        int maxHeight=0; 
        for(int i=0;i<n;i++) 
        {
            String[] input=br.readLine().split(" ");
            int l=Integer.parseInt(input[0]); 
            int h=Integer.parseInt(input[1]); 
            maxHeight=Math.max(maxHeight, h);
            al.add(new int[] {l,h});
        }

        // 위치 기준 정렬
        Collections.sort(al,(a,b)->Integer.compare(a[0], b[0]));
        
        // 가장 높은 기둥의 index 찾기 (왼쪽에서 가장 먼저 나오는 것)
        int maxIdx=0;
        for(int i=0;i<n;i++) 
        {
            if(al.get(i)[1]==maxHeight) 
            {
                maxIdx=i;
                break;
            }
        }

        int total=0;
        
        // 왼쪽 → 최고 높이까지 누적
        int curH=al.get(0)[1];
        int curX=al.get(0)[0];
        for(int i=1;i<=maxIdx;i++) 
        {
            if(al.get(i)[1] >= curH) 
            {
                total += (al.get(i)[0]-curX) * curH;
                curH = al.get(i)[1];
                curX = al.get(i)[0];
            }
        }
        
        // 오른쪽 → 최고 높이까지 누적
        curH=al.get(n-1)[1];
        curX=al.get(n-1)[0];
        for(int i=n-2;i>=maxIdx;i--) 
        {
            if(al.get(i)[1] >= curH) 
            {
                total += (curX - al.get(i)[0]) * curH;
                curH = al.get(i)[1];
                curX = al.get(i)[0];
            }
        }
        
        // 가장 높은 기둥 부분 더하기
        total += maxHeight;

        System.out.println(total);
    }
}
