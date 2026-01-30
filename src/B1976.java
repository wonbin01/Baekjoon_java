import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

class B1976 {
    static HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행계획에 포함된 도시의 수
        int[] travel = new int[m]; // 여행계획에 포함된 도시
        String[] input;
        for(int i=1;i<=n;i++) {
            hm.putIfAbsent(i, new TreeSet<>());
        }
        for(int i=1;i<=n;i++) {
            input = br.readLine().split(" ");
            for(int j=1;j<=n;j++) {
                if(Integer.parseInt(input[j-1]) == 1) {
                    hm.get(i).add(j); // 여행 가능
                    hm.get(j).add(i); // 여행 가능
                }
            }
        }
        input = br.readLine().split(" "); // 여행 계획에 포함된 도시
        for(int i=0;i<m;i++) {
            travel[i] = Integer.parseInt(input[i]);
        }
        //연결 여부만 확인하면 됨
        for(int i=0;i<m-1;i++) {
            int start = travel[i]; // 시작 위치
            int end = travel[i+1]; // 종료 위치
            if(!canApproach(start, end)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static boolean canApproach(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[hm.size()+1];
            queue.add(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int cx = queue.poll();
                if(cx==end) {
                    return true;
                }
                for(int nx : hm.get(cx)) {
                    if(!visited[nx]) {
                    queue.add(nx);
                    visited[nx] = true;
            }
        }
            }
            return false;
    }
}