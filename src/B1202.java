import java.io.*;
import java.util.*;
public class B1202 
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
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long total=0; int j=0;
        for(int i=0;i<k;i++)
        {
            while(j<n&&information[j][0]<=bag[i])
            {
                pq.add(information[j][1]);
                j++;
            }
            if(!pq.isEmpty())
            {
                total+=pq.poll();
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
