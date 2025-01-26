import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B13913 {
    static int max = 100001;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 수빈 위치
        int k = scan.nextInt(); // 동생 위치
        Subin subin = new Subin();

        Subin result = bfs(n, k, subin); // BFS 호출
        System.out.println(result.time);
        
        // 경로 출력 (뒤집어서 출력)
        Stack<Integer> stack = new Stack<>();
        while (!result.location.isEmpty()) {
            stack.push(result.location.poll()); // 큐에서 값을 꺼내 스택에 넣음
        }
        while (result.time>=0) 
        {
            System.out.print(stack.pop() + " "); // 스택에서 값을 꺼내면서 출력
            result.time--;
        }

        scan.close();
    }

    public static Subin bfs(int n, int k, Subin subin) {
        Queue<Subin> queue = new LinkedList<>(); // 큐 정의
        int[] visited = new int[max]; // 각 위치에 도달한 최소 시간 저장
        int[] parent = new int[max]; // 경로 추적을 위한 배열

        for (int i = 0; i < max; i++) {
            visited[i] = -1; // -1로 초기화하여 방문되지 않았음을 나타냄
        }
        visited[n] = 0;
        subin.loc = n;
        subin.time = 0;
        subin.location.offer(n);
        queue.offer(subin);

        while (!queue.isEmpty()) {
            Subin current = queue.poll(); // 큐에서 하나씩 빼기
            int currentLoc = current.loc;
            int currentTime = current.time;

            if (currentLoc == k) {
                // 동생에게 도달했을 때 경로 추적
                while (currentLoc != n) {
                    current.location.offer(currentLoc);
                    currentLoc = parent[currentLoc]; // 부모 위치로 이동
                }
                current.location.offer(n); // 시작 위치도 큐에 추가
                return current; // 동생 위치까지 도달한 경로 반환
            }

            // 이동 가능한 위치 탐색
            if (currentLoc - 1 >= 0 && visited[currentLoc - 1] == -1) {
                visited[currentLoc - 1] = currentTime + 1;
                parent[currentLoc - 1] = currentLoc; // 부모로 현재 위치 설정
                queue.offer(new Subin(currentLoc - 1, currentTime + 1, current.location));
            }

            if (currentLoc + 1 < max && visited[currentLoc + 1] == -1) {
                visited[currentLoc + 1] = currentTime + 1;
                parent[currentLoc + 1] = currentLoc; // 부모로 현재 위치 설정
                queue.offer(new Subin(currentLoc + 1, currentTime + 1, current.location));
            }

            if (currentLoc * 2 < max && visited[currentLoc * 2] == -1) {
                visited[currentLoc * 2] = currentTime + 1;
                parent[currentLoc * 2] = currentLoc; // 부모로 현재 위치 설정
                queue.offer(new Subin(currentLoc * 2, currentTime + 1, current.location));
            }
        }

        return null; // 목표 위치에 도달할 수 없으면 null 반환
    }

    // Subin 클래스 정의
    public static class Subin {
        int loc;
        int time;
        Queue<Integer> location = new LinkedList<>(); // 위치를 저장하는 큐

        // 기본 생성자
        public Subin() {}

        // 위치와 시간을 설정하는 생성자
        public Subin(int loc, int time, Queue<Integer> next) {
            this.loc = loc;
            this.time = time;
            // 큐의 기존 요소를 복사
            this.location = new LinkedList<>(next);
        }
    }
}
