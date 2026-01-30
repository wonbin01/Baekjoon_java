import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class B2644 {
    static Map<Integer,ArrayList<Integer>> hm = new HashMap<>(); // 각 사람들의 관계를 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람의 수
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]); int end = Integer.parseInt(input[1]); // 촌수를 구해야하는 사람의 정보
        int m = Integer.parseInt(br.readLine()); // 관계의 수
        boolean[] visited = new boolean[n+1]; // 방문 여부를 저장
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]); // 부모
            int child = Integer.parseInt(input[1]); // 자식
            hm.putIfAbsent(parent, new ArrayList<>());
            hm.putIfAbsent(child, new ArrayList<>());
            hm.get(parent).add(child); //양방향 가능
            hm.get(child).add(parent);
        }
        findCnt(hm, start, end, visited);
    }
    static void findCnt(Map<Integer,ArrayList<Integer>> hm, int start, int end, boolean[] visited) {
        Queue<FamilyInfo> queue = new LinkedList<>();
        FamilyInfo current = new FamilyInfo(start, 0);
        visited[start] = true;
        queue.add(current);
        while(!queue.isEmpty()) {
            FamilyInfo cx = queue.poll();
            int currentNumber = cx.number;
            int cnt = cx.currentCnt;
            if(currentNumber==end) {
                System.out.println(cnt);
                return;
            }
            ArrayList<Integer> list = hm.getOrDefault(currentNumber, new ArrayList<>());
            for(int n : list) {
                if(!visited[n]) { //접근되지 않은 경우
                    FamilyInfo nx = new FamilyInfo(n, cnt+1);
                    visited[n] = true;
                    queue.add(nx);
                }
            }
        }
        System.out.println(-1);
        return;
    }
    static public class FamilyInfo {
        int number;
        int currentCnt;
        public FamilyInfo(int number, int currentCnt) {
            this.number = number;
            this.currentCnt = currentCnt;
        }
    }
}
