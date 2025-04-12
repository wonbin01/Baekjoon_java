import java.io.*;
import java.util.*;

public class B2514 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 역의 수
        int k = Integer.parseInt(input[1]); // 한 하이퍼튜브당 연결된 역의 개수
        int m = Integer.parseInt(input[2]); // 하이퍼튜브의 개수
        
        // 그래프 생성 (역 1~n, 하이퍼튜브는 n+1~ n+m)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n + m; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 하이퍼튜브 연결 정보 처리
        for (int tube = 1; tube <= m; tube++) {
            input = br.readLine().split(" ");
            int tubeNode = n + tube; // 하이퍼튜브를 별도의 노드로 취급

            for (int j = 0; j < k; j++) 
            {
                int station = Integer.parseInt(input[j]);
                graph.get(station).add(tubeNode); // 역에 하이퍼튜브 추가
                graph.get(tubeNode).add(station); // 하이퍼튜브에 역 추가
            }
        }
        
        // BFS로 최단 경로 찾기
        System.out.println(bfs(graph, n));
    }

    static int bfs(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + graph.size()]; // visited 배열 크기 수정

        queue.add(new int[]{1, 1}); // (현재 역, 역의 개수)
        visited[1] = true;

        while (!queue.isEmpty()) 
        {
            int[] curr = queue.poll();
            int station = curr[0], distance = curr[1];

            // 목적지 역에 도달하면 이동 횟수 리턴
            if (station == n) return distance;

            // 연결된 역 탐색
            for (int next : graph.get(station)) 
            {
                if (!visited[next]) 
                {
                    visited[next] = true;

                    // 하이퍼튜브를 지나가는 경우, 이동 횟수 증가하지 않음
                    if (next > n) 
                    {
                        queue.add(new int[]{next, distance}); // 하이퍼튜브는 이동 횟수 증가 안 함
                    } 
                    else 
                    {
                        queue.add(new int[]{next, distance + 1}); // 역을 지나갈 때는 이동 횟수 증가
                    }
                }
            }
        }
        return -1; // 도달 불가능
    }
}
