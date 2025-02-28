import java.io.*;
import java.util.*;

public class test
{
    static HashMap<Integer, Integer> key = new HashMap<>();
    static boolean[] visited;
    static int[] memo;

    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // n개의 노드
        int m = Integer.parseInt(input[1]); // m개의 간선
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 1; i <= n; i++) 
        {
            hm.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) 
        {
            input = br.readLine().split(" ");
            int hacked = Integer.parseInt(input[0]); // 목적지 노드
            int target = Integer.parseInt(input[1]); // 출발 노드
            hm.get(target).add(hacked); // 방향성 있는 간선
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        for (int i = 1; i <= n; i++) 
        {
            visited = new boolean[n + 1];
            dfs(i, hm);
        }

        int maxHacked = Collections.max(key.values());
        ArrayList<Integer> result = new ArrayList<>();
        for (int node : key.keySet()) 
        {
            if (key.get(node) == maxHacked) 
            {
                result.add(node);
            }
        }
        Collections.sort(result);

        for (int node : result)
        {
            System.out.print(node + " ");
        }
    }

    public static int dfs(int start, HashMap<Integer, ArrayList<Integer>> hm) 
    {
        if (memo[start] != -1) 
        {
            key.put(start,memo[start]);
            return memo[start];
        }

        visited[start] = true;
        int count = 1;

        for (int neighbor : hm.get(start)) 
        {
            if (!visited[neighbor]) 
            {
                count += dfs(neighbor, hm);
            }
        }

        memo[start] = count;
        key.put(start, count);
        return count;
    }
}