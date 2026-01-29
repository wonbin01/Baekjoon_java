import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B6603 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            if(k==0) break;
            int[] numbers = new int[k]; // 조합해야되는 수
            for(int i=1;i<=k;i++) {
                int num = Integer.parseInt(input[i]);
                numbers[i-1] = num;
            }
            makeCollections(numbers,new ArrayList<>(),0);
            System.out.println();
        }
    }
    static void makeCollections(int[] numbers,ArrayList<Integer> collection, int start) { //조합을 만드는 메서드
        if(collection.size()==6) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++) {
                sb.append(collection.get(i)).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            collection.add(numbers[i]);
            makeCollections(numbers, collection, i + 1);
            collection.remove(collection.size() - 1);
    }
    }
}