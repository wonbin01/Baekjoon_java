import java.util.*;
import java.io.*;

public class B31932 {
    static class Edge {
        int to, length, collapseTime;

        Edge(int to, int length, int collapseTime) {
            this.to = to;
            this.length = length;
            this.collapseTime = collapseTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 빙하의 수
        int m = Integer.parseInt(input[1]); // 얼음 다리의 수

        HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) hm.put(i, new ArrayList<>()); // 1번부터 n번까지 초기화

        int maxCollapseTime = 0; // 다리의 최대 무너지는 시간
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]); // u-v를 잇는 다리
            int d = Integer.parseInt(input[2]); // 다리의 길이
            int t = Integer.parseInt(input[3]); // t초에 다리가 무너짐
            hm.get(u).add(new Edge(v, d, t));
            hm.get(v).add(new Edge(u, d, t));
            maxCollapseTime = Math.max(maxCollapseTime, t); // 최대 무너지는 시간 갱신
        }

        int left = 0, right = maxCollapseTime, result = -1;
        boolean reach=false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canReachHome(mid, n, hm)) { // 집에 갈 수 있으면
                result = mid;
                left = mid + 1; // 더 오래 머물 수 있는지 확인
                reach=true;
            } else {
                right = mid - 1; // 시간을 줄임
            }
        }
        if(reach) System.out.println(result);
        else System.out.println(-1);
    }

    static boolean canReachHome(int timeSpent, int n, HashMap<Integer, ArrayList<Edge>> hm) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, timeSpent});
        dist[1] = timeSpent;
    
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int time = cur[1];
    
            if (node == n) return true;
    
            if (dist[node] < time) continue; // 이미 더 좋은 경로 있음
    
            for (Edge edge : hm.get(node)) {
                int nextTime = time + edge.length;
                if (nextTime <= edge.collapseTime && nextTime < dist[edge.to]) {
                    dist[edge.to] = nextTime;
                    pq.add(new int[]{edge.to, nextTime});
                }
            }
        }
    
        return false;
    }
    
    
}