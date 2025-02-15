import java.io.*;
import java.util.*;

public class test 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); // 보석의 총 개수
        int k=Integer.parseInt(input[1]); // 가방의 개수(가방에는 최대 한 개의 보석만 가능)
        int[][] information=new int[n][2]; //보석의 무게와 가격 저장
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            information[i][0]=Integer.parseInt(input[0]); //무게
            information[i][1]=Integer.parseInt(input[1]); //가격
        }
        Arrays.sort(information, new infor_sort()); // 무게를 기준으로 오름차순 정렬
        int[] bag=new int[k];
        for(int i=0;i<k;i++)
        {
            bag[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag); // 가방에 최대로 넣을 수 있는 무게 정렬

        long total=0; 
        boolean[] used = new boolean[n]; // 보석 사용 여부를 저장하는 배열

        for(int i=0;i<k;i++)
        {
            int maxPrice = 0;
            int maxIndex = -1;
            for(int j=0; j<n; j++)
            {
                if(!used[j] && information[j][0] <= bag[i] && information[j][1] > maxPrice)
                {
                    maxPrice = information[j][1];
                    maxIndex = j;
                }
            }
            if(maxIndex != -1)
            {
                total += maxPrice;
                used[maxIndex] = true; // 해당 보석을 사용했음을 표시
            }
        }
        System.out.println(total);
    }

    public static class infor_sort implements Comparator<int[]>
    {
        @Override
        public int compare(int[] a, int[] b)
        {
            return Integer.compare(a[0], b[0]); // 무게를 기준으로 오름차순 정렬
        }
    }
}