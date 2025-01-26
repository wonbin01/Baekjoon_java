import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B13913 {
    static int max = 100001;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // ���� ��ġ
        int k = scan.nextInt(); // ���� ��ġ
        Subin subin = new Subin();

        Subin result = bfs(n, k, subin); // BFS ȣ��
        System.out.println(result.time);
        
        // ��� ��� (����� ���)
        Stack<Integer> stack = new Stack<>();
        while (!result.location.isEmpty()) {
            stack.push(result.location.poll()); // ť���� ���� ���� ���ÿ� ����
        }
        while (result.time>=0) 
        {
            System.out.print(stack.pop() + " "); // ���ÿ��� ���� �����鼭 ���
            result.time--;
        }

        scan.close();
    }

    public static Subin bfs(int n, int k, Subin subin) {
        Queue<Subin> queue = new LinkedList<>(); // ť ����
        int[] visited = new int[max]; // �� ��ġ�� ������ �ּ� �ð� ����
        int[] parent = new int[max]; // ��� ������ ���� �迭

        for (int i = 0; i < max; i++) {
            visited[i] = -1; // -1�� �ʱ�ȭ�Ͽ� �湮���� �ʾ����� ��Ÿ��
        }
        visited[n] = 0;
        subin.loc = n;
        subin.time = 0;
        subin.location.offer(n);
        queue.offer(subin);

        while (!queue.isEmpty()) {
            Subin current = queue.poll(); // ť���� �ϳ��� ����
            int currentLoc = current.loc;
            int currentTime = current.time;

            if (currentLoc == k) {
                // �������� �������� �� ��� ����
                while (currentLoc != n) {
                    current.location.offer(currentLoc);
                    currentLoc = parent[currentLoc]; // �θ� ��ġ�� �̵�
                }
                current.location.offer(n); // ���� ��ġ�� ť�� �߰�
                return current; // ���� ��ġ���� ������ ��� ��ȯ
            }

            // �̵� ������ ��ġ Ž��
            if (currentLoc - 1 >= 0 && visited[currentLoc - 1] == -1) {
                visited[currentLoc - 1] = currentTime + 1;
                parent[currentLoc - 1] = currentLoc; // �θ�� ���� ��ġ ����
                queue.offer(new Subin(currentLoc - 1, currentTime + 1, current.location));
            }

            if (currentLoc + 1 < max && visited[currentLoc + 1] == -1) {
                visited[currentLoc + 1] = currentTime + 1;
                parent[currentLoc + 1] = currentLoc; // �θ�� ���� ��ġ ����
                queue.offer(new Subin(currentLoc + 1, currentTime + 1, current.location));
            }

            if (currentLoc * 2 < max && visited[currentLoc * 2] == -1) {
                visited[currentLoc * 2] = currentTime + 1;
                parent[currentLoc * 2] = currentLoc; // �θ�� ���� ��ġ ����
                queue.offer(new Subin(currentLoc * 2, currentTime + 1, current.location));
            }
        }

        return null; // ��ǥ ��ġ�� ������ �� ������ null ��ȯ
    }

    // Subin Ŭ���� ����
    public static class Subin {
        int loc;
        int time;
        Queue<Integer> location = new LinkedList<>(); // ��ġ�� �����ϴ� ť

        // �⺻ ������
        public Subin() {}

        // ��ġ�� �ð��� �����ϴ� ������
        public Subin(int loc, int time, Queue<Integer> next) {
            this.loc = loc;
            this.time = time;
            // ť�� ���� ��Ҹ� ����
            this.location = new LinkedList<>(next);
        }
    }
}
