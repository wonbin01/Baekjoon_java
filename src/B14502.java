import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B14502
{
    static List<int[]> empty = new ArrayList<>(); //비어있는곳 저장
    static int max = Integer.MIN_VALUE; //가장 큰 안전지대 생성
    static int[][] map;
    static int[][] direction = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]); //세로
        int col = Integer.parseInt(input[1]); //가로 

        map = new int[row][col];
        for(int i=0;i<row;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<col;j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==0) {
                    empty.add(new int[]{i,j});
                }
            }
        }
        createWall(0, 0, new ArrayList<>());
        System.out.println(max);
    }

    public static void createWall(int index, int wallCount, List<int[]> wallList) {
    if (wallCount == 3) {
        //여기서 바로 시뮬레이션
        bfs(wallList);
        return;
    }

    for (int i = index; i < empty.size(); i++) {
        wallList.add(empty.get(i));
        createWall(i + 1, wallCount + 1, wallList);
        wallList.remove(wallList.size() - 1);
    }
}


public static void bfs(List<int[]> wallList) {
    int[][] copyMap = new int[map.length][map[0].length];
    for (int i = 0; i < map.length; i++) {
        copyMap[i] = map[i].clone();
    }

    for (int[] wall : wallList) {
        copyMap[wall[0]][wall[1]] = 1;
    }

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < copyMap.length; i++) {
        for (int j = 0; j < copyMap[0].length; j++) {
            if (copyMap[i][j] == 2) {
                queue.add(new int[]{i, j});
            }
        }
    }

    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        for (int k = 0; k < 4; k++) {
            int nx = cur[0] + direction[k][0];
            int ny = cur[1] + direction[k][1];

            if (nx >= 0 && nx < copyMap.length &&
                ny >= 0 && ny < copyMap[0].length &&
                copyMap[nx][ny] == 0) {

                copyMap[nx][ny] = 2;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    checkSafePlace(copyMap);
}


    public static void checkSafePlace(int[][] copyMap) {
        int row = copyMap.length; int col = copyMap[0].length;
        int cnt=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(copyMap[i][j]==0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max,cnt);
    }
}

    // 벽 세우는 경우의 수 어떤식으로??
    // 0이면 빈 공간, 1이면 벽, 2이면 바이러스