import java.io.*;
import java.util.*;

public class B22856 {
    static HashMap<Integer, Integer> left_child = new HashMap<>();
    static HashMap<Integer, Integer> right_child = new HashMap<>();
    static int count = 0;
    static int lastNode = 0; // 가장 오른쪽 노드
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]); // 현재 노드
            int b = Integer.parseInt(input[1]); // 왼쪽 자식
            int c = Integer.parseInt(input[2]); // 오른쪽 자식

            if (b != -1) left_child.put(a, b);
            if (c != -1) right_child.put(a, c);
        }
        if(n==1)
        {
            System.out.println(0);
            return;
        }
        findLastNode(1); // 가장 오른쪽 노드 찾기
        if(lastNode==1)
        {
            move2_cnt(1, -1);
        }
        else move_cnt(1, -1);
        System.out.println(count);
    }

    static void findLastNode(int node) 
    {
        while (right_child.containsKey(node)) {
            node = right_child.get(node);
        }
        lastNode = node;
    }

    static void move_cnt(int node, int parent) 
    {
        if(node==lastNode)
        {
            check=true;
        }

        if (left_child.containsKey(node)) 
        {
            count++; // 이동 횟수 증가
            move_cnt(left_child.get(node), node);
        }

        if (right_child.containsKey(node)) 
        {
            count++; // 이동 횟수 증가
            move_cnt(right_child.get(node), node);
        }
        // **마지막 노드에서는 부모로 돌아가지 않도록 수정**
        if (parent != -1 && node != lastNode && check==false) 
        {
            count++; // 부모로 돌아오는 이동 횟수
        }
    }


    static void move2_cnt(int node, int parent) 
    {

        if (left_child.containsKey(node)) 
        {
            count++; // 이동 횟수 증가
            move_cnt(left_child.get(node), node);
        }

        if (right_child.containsKey(node)) 
        {
            count++; // 이동 횟수 증가
            move_cnt(right_child.get(node), node);
        }
        // **마지막 노드에서는 부모로 돌아가지 않도록 수정**
        if (parent != -1 && node != lastNode) 
        {
            count++; // 부모로 돌아오는 이동 횟수
        }
    }
}
