import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        while (t>0) {
            t--;
            int m = Integer.parseInt(br.readLine()); // 수열의 크기 : 홀수
            int[] map = new int[m]; // 숫자들을 저장
            int cx=0;
            int row = m/10; int remain = m%10; // 몇번 반복 + 나머지
            clientInput(map, row, remain, cx, br); // 사용자에게 배열 정보 입력을 받는 메서드
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은값들중에 가장 큰 값
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값들중에 가장 작은 값
            StringBuilder sb = new StringBuilder();
            int cnt=0;
            for(int i=0;i<m;i++) {
                int index = i+1;
                calculateMiddleValue(minHeap, maxHeap, map[i]);
                if(index%2!=0) {
                    sb.append(maxHeap.peek()).append(" ");
                    cnt++;
                    if(cnt%10==0) {
                        sb.append("\n");
                    }
                }
            }
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }

    static void clientInput(int[] map, int row, int remain, int cx, BufferedReader br) throws IOException {
        String[] input;
        if(row==0 && remain!=0) {
                input = br.readLine().split(" ");
                for(int i=0;i<remain;i++) {
                    map[cx] = Integer.parseInt(input[i]);
                    cx++;
                }
            }
            else if (row!=0 && remain==0) {
                for(int i=0;i<row;i++) {
                    input = br.readLine().split(" ");
                    for(int j=0;j<10;j++) {
                        map[cx] = Integer.parseInt(input[j]);
                        cx++;
                    }
                }
            }
            else if (row!=0 && remain!=0) {
                for(int i=0;i<row+1;i++) {
                    input = br.readLine().split(" ");
                    if(i==row) {
                        for(int j=0;j<remain;j++) {
                            map[cx] = Integer.parseInt(input[j]);
                            cx++;
                        }
                    }
                    else {
                        for(int j=0;j<10;j++) {
                            map[cx] = Integer.parseInt(input[j]);
                            cx++;
                        }
                    }
                }
            }
    }

    static void calculateMiddleValue(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int currentValue) {
        maxHeap.offer(currentValue); // 1. 먼저 minHeap에 넣음
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
    }
    }

}
