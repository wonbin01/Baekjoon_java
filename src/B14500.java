import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class B14500 {
    static int[][] scoreMap; //Map의 점수를 저장하는 Map
    static int max=Integer.MIN_VALUE;
    static int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static int row; static int col;
    static int maxCell = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");
        row = Integer.parseInt(sizeInput[0]); //행의 길이
        col = Integer.parseInt(sizeInput[1]); //열의 길이
        scoreMap = new int[row][col];
        visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            String[] scoreInput = br.readLine().split(" ");
            for(int j=0;j<col;j++){
                scoreMap[i][j] = Integer.parseInt(scoreInput[j]);
                maxCell = Math.max(maxCell, scoreMap[i][j]);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                visited[i][j]=true;
                createList(i, j, visited, 1, scoreMap[i][j]);
                visited[i][j] = false;
                checkException(i, j);
            }
        }
        System.out.println(max);
    }
    static void createList(int x, int y, boolean[][] visited, int depth, int sum) {
    if (sum + (4 - depth) * maxCell <= max) return;

    if (depth == 4) {
        max = Math.max(max, sum);
        return;
    }

    for (int d = 0; d < 4; d++) {
        int nx = x + direction[d][0];
        int ny = y + direction[d][1];
        if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
        if (visited[nx][ny]) continue;

        visited[nx][ny] = true;
        createList(nx, ny, visited, depth + 1, sum + scoreMap[nx][ny]);
        visited[nx][ny] = false;
    }
}


    static void checkException(int x, int y) {
    // ㅗ
    if (x - 1 >= 0 && y - 1 >= 0 && y + 1 < col) {
        int sum = scoreMap[x][y]
                + scoreMap[x-1][y]
                + scoreMap[x][y-1]
                + scoreMap[x][y+1];
        max = Math.max(max, sum);
    }

    // ㅜ
    if (x + 1 < row && y - 1 >= 0 && y + 1 < col) {
        int sum = scoreMap[x][y]
                + scoreMap[x+1][y]
                + scoreMap[x][y-1]
                + scoreMap[x][y+1];
        max = Math.max(max, sum);
    }

    // ㅓ
    if (x - 1 >= 0 && x + 1 < row && y - 1 >= 0) {
        int sum = scoreMap[x][y]
                + scoreMap[x-1][y]
                + scoreMap[x+1][y]
                + scoreMap[x][y-1];
        max = Math.max(max, sum);
    }

    // ㅏ
    if (x - 1 >= 0 && x + 1 < row && y + 1 < col) {
        int sum = scoreMap[x][y]
                + scoreMap[x-1][y]
                + scoreMap[x+1][y]
                + scoreMap[x][y+1];
        max = Math.max(max, sum);
    }
}


    static void calculateScore(List<int[]> list) {
        int total = 0;
        for(int[] dir : list) {
            total+=scoreMap[dir[0]][dir[1]];
        }
        max = Math.max(total, max);
    }
}
