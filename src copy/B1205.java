import java.io.*;
import java.util.*;

public class B1205 {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 현재 리스트에 있는 개수
        int score = Integer.parseInt(input[1]); // 새로운 점수
        int p = Integer.parseInt(input[2]); // 리스트에 올라갈 수 있는 최대 개수
        ArrayList<Integer> list = new ArrayList<>();

        if (n > 0) 
        { // n이 0보다 클 때만 주어짐
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) 
            {
                int s = Integer.parseInt(input[i]);
                list.add(s);
            }
        }
        list.sort(Collections.reverseOrder()); // 내림차순 정렬

        int rank = 0; // 순위 계산 - 나보다 큰게 rank개 있음
        int same = 0; // 같은 점수가 몇개인지 저장

        for (int i = 0; i < list.size(); i++) 
        {
            if (list.get(i) > score) {
                rank++;
            } 
            else if (list.get(i) == score) 
            {
                same++;
            } 
            else 
            {
                break;
            }
        }
        if(same!=0) //같은 숫자가 존재함
        {
            rank+=same;
        }
        if(rank==0){
            System.out.println(1);
            return;
        }
        if(rank==p)
        {
            System.out.println(-1);
            return;
        }
        else if(rank<p)
        {
            rank-=same;
            rank+=1;
            System.out.println(rank);
            return;
        }
    }
}