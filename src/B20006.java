import java.io.*;
import java.util.Arrays;

public class B20006 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]); // 플레이어의 수
        int m = Integer.parseInt(input[1]); // 방의 정원

        member[][] info = new member[p][m]; // 최대 p개의 방
        int roomCount = 0; // 현재까지 생성된 방 수

        for (int i = 0; i < p; i++) {
            input = br.readLine().split(" ");
            int level = Integer.parseInt(input[0]);
            String id = input[1];
            member mem = new member(level, id);

            boolean placed = false;

            // 이미 존재하는 방에 배치
            for (int j = 0; j < roomCount; j++) {
                if (Math.abs(info[j][0].level - mem.level) <= 10) {
                    for (int k = 0; k < m; k++) {
                        if (info[j][k] == null) {
                            info[j][k] = mem;
                            placed = true;
                            break;
                        }
                    }
                    if (placed) break;
                }
            }

            // 들어갈 방이 없으면 새로운 방 생성
            if (!placed) {
                info[roomCount][0] = mem;
                roomCount++;
            }
        }

        // 출력
        for (int i = 0; i < roomCount; i++) {
            int count = 0;
            for (member mem : info[i]) if (mem != null) count++;

            if (count == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Arrays.sort(info[i], (a, b) -> {
                if (a == null && b == null) return 0;
                if (a == null) return 1;
                if (b == null) return -1;
                return a.id.compareTo(b.id);
            });

            for (member mem : info[i]) {
                if (mem == null) break;
                sb.append(mem.level).append(" ").append(mem.id).append("\n");
            }
        }

        System.out.println(sb);
    }
}

class member {
    int level;
    String id;

    member(int level, String id) {
        this.level = level;
        this.id = id;
    }
}
