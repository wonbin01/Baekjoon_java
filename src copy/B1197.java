import java.io.*;
import java.util.*;

public class B1197 {
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]); // 정점의 개수
        int e = Integer.parseInt(input[1]); // 간선의 개수

        // 그래프 초기화
        //graph = (ArrayList<Edge>[]) new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph[v1].add(new Edge(v2, weight));
            graph[v2].add(new Edge(v1, weight));
        }

        // 최소 스패닝 트리의 가중치 출력
        System.out.println(prim(v, 1));
    }

    static long prim(int v, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        long totalWeight = 0;

        // 시작 정점의 간선들을 우선순위 큐에 추가
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.to]) continue; // 이미 방문한 정점은 무시

            visited[edge.to] = true;
            totalWeight += edge.weight;

            // 새로 추가된 정점의 간선들을 큐에 추가
            for (Edge next : graph[edge.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return totalWeight;
    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}