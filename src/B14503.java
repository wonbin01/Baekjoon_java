import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14503 {
    static int clean_cnt = 0;
    static int cx;
    static int cy;
    static int direction;
    // 0:북, 1:동, 2:남, 3:서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); int m=Integer.parseInt(input[1]);
        int[][] map = new int[n][m]; // 1이면 벽, 0이면 청소 안된 방, 2이면 청소한 방
        input = br.readLine().split(" ");
        cx = Integer.parseInt(input[0]); //현재 위치하는 행
        cy = Integer.parseInt(input[1]); //현재 위치하는 열
        direction = Integer.parseInt(input[2]); // 현재 바라보는 방향, 0:북 1:동 2:남 3:서
        for(int i=0;i<n;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        while(true) {
            if(map[cx][cy] == 0) { //현재 위치한 칸이 청소가 안된 경우
                map[cx][cy]=2;
                clean_cnt++;
                continue;
            }
            if(checkCleanRoom(map,n,m)) {//방이 있는지 확인 -> 그 방으로 이동
                continue;
            }
            
            if(!checkCanBack(map,n,m)) { //방이 없는 경우 뒤로 이동할 수 있는지 확인
                // 뒤로 이동할 수 없으면 종료
                break;
            }
        }
        System.out.println(clean_cnt);
    }
    static boolean checkCleanRoom(int[][] map, int n, int m) { //4방향으로 청소할 방이 있는지 확인하는 메서드
        // 2. 4방향 탐색 (회전만 4번)
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4; // 반시계 회전
            int nx = cx + dx[direction];
            int ny = cy + dy[direction];

            if (nx>=0 && nx < n && ny>=0 && ny<m && map[nx][ny] == 0) { // 앞칸이 미청소
                cx = nx;
                cy = ny;
                return true;
            }
        }
        return false;
    }

    static boolean checkCanBack(int[][] map,int n, int m) { // 뒤로 이동할 수 있는지 확인하는 메서드
            int nx = cx - dx[direction];
            int ny = cy - dy[direction];
            if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]!=1) {
                cx=nx; cy=ny;
                return true;
            }
            return false;
    }
    
}
// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
//     1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//     2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
//     1. 반시계 방향으로 90도 회전한다.
//     2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//     3. 1번으로 돌아간다.