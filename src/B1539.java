import java.io.*;
import java.util.*;

public class B1539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long total = 0;
        
        for(int i=0; i<n; i++)
        {
            int value=Integer.parseInt(br.readLine());
            
            // value보다 큰 값 중 최솟값 (오른쪽 자식 후보)
            Integer right = map.higherKey(value);
            // value보다 작은 값 중 최댓값 (왼쪽 자식 후보)
            Integer left = map.lowerKey(value);
            
            // 현재 노드의 높이
            int depth = 1;
            if(left != null && right != null) 
                depth = Math.max(map.get(left), map.get(right)) + 1;
            else if(left != null)
                depth = map.get(left) + 1;
            else if(right != null)
                depth = map.get(right) + 1;
            
            // 트리에 현재 노드 추가
            map.put(value, depth);
            // 총 높이 누적
            total += depth;
        }
        
        System.out.println(total);
    }
}
