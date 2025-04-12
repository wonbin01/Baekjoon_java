import java.io.*;
import java.util.*;

public class B15681 {
    static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    static int[] subtreeSize; // 서브트리 크기 저장 배열

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 정점 개수
        int root = Integer.parseInt(input[1]); // 루트 노드
        int q = Integer.parseInt(input[2]); // 쿼리 개수

        subtreeSize = new int[n + 1]; // 서브트리 크기 저장 배열

        // 트리 초기화
        for (int i = 1; i <= n; i++) 
        {
            tree.put(i, new ArrayList<>());
        }

        // 간선 입력 받기 (양방향 그래프)
        for (int i = 0; i < n - 1; i++) 
        {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // 서브트리 크기 미리 계산 (DFS)
        dfs(root, -1);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) 
        {
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[queryNode]).append("\n");
        }
        System.out.print(sb);
    }

    // DFS를 이용한 서브트리 크기 계산
    static int dfs(int node, int parent) 
    {
        subtreeSize[node] = 1; // 자기 자신 포함
        for (int child : tree.get(node)) 
        {
            if (child != parent) 
            { // 부모 노드는 제외 (방향성 부여)
                subtreeSize[node] += dfs(child, node);
            }
        }
        return subtreeSize[node];
    }
}
