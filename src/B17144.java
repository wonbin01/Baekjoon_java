import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17144 {
    static int[][] map;
    static int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int row = Integer.parseInt(input[0]); //행
    int col = Integer.parseInt(input[1]); //열
    int t = Integer.parseInt(input[2]); // 시간
    int lowAirConditional=-1; //밑에 있는 공기청정기 위치
    map = new int[row][col];
    for(int i=0; i<row; i++) {
        input = br.readLine().split(" ");
        for(int j=0;j<col;j++) {
            map[i][j] = Integer.parseInt(input[j]);
            if(map[i][j]==-1) {
                lowAirConditional=i;
            }
        }
    }
    for(int i=0; i<t;i++) {
        airPollution(lowAirConditional, lowAirConditional-1, row, col);
        playhighAirConditional(lowAirConditional-1, row, col);
        playlowAirConditional(lowAirConditional, row, col);
    }
    
    System.out.println(calculateAirPollution(row, col));
}    
    static void airPollution (int lowAirConditional, int highAirConditional, int row, int col) { //미세먼지 확산 메서드
        int[][] pollution = new int[row][col];
        for(int i=0;i<row;i++) { // 초기화
            for(int j=0;j<col;j++) {
                pollution[i][j]=0;
            }
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(map[i][j]!=0 && map[i][j]!=-1) {
                    int directCount=0;
                    int dirtyAir=map[i][j];
                    int enemy = dirtyAir/5; //다른곳으로 빠져나가는 공기
                    if(enemy == 0) continue;
                    for(int d=0;d<4;d++) {
                        int nx = i+direction[d][0];
                        int ny = j+direction[d][1];
                        if(nx>=0 && nx<row && ny>=0 && ny<col && map[nx][ny]!=-1) {
                            directCount++;
                            pollution[nx][ny]+=enemy;
                        }
                    }
                    map[i][j] = dirtyAir-enemy*directCount;
                }
            }
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                map[i][j] +=pollution[i][j];
            }
        }
    }
    static void playhighAirConditional(int highAirConditional, int row, int col) {
    int r = highAirConditional; // 공기청정기 윗부분의 행 위치
    int c = col; // 열의 전체 크기
    for (int i = r - 1; i > 0; i--) {
        map[i][0] = map[i - 1][0];
    }

    for (int i = 0; i < c - 1; i++) {
        map[0][i] = map[0][i + 1];
    }

    for (int i = 0; i < r; i++) {
        map[i][c - 1] = map[i + 1][c - 1];
    }

    for (int i = c - 1; i > 1; i--) {
        map[r][i] = map[r][i - 1];
    }

    map[r][1] = 0;
}
static void playlowAirConditional(int lowAirConditional, int row, int col) {
    int r = lowAirConditional; // 공기청정기 아래부분의 행 위치
    int c = col; // 열의 전체 크기

    for (int i = r + 1; i < row - 1; i++) {
        map[i][0] = map[i + 1][0];
    }


    for (int i = 0; i < c - 1; i++) {
        map[row - 1][i] = map[row - 1][i + 1];
    }

 
    for (int i = row - 1; i > r; i--) {
        map[i][c - 1] = map[i - 1][c - 1];
    }

    for (int i = c - 1; i > 1; i--) {
        map[r][i] = map[r][i - 1];
    }

    map[r][1] = 0;
}
static int calculateAirPollution(int row, int col) {
    int total=0;
    for(int i=0;i<row;i++) {
        for(int j=0;j<col;j++) {
            if(map[i][j]!=0 && map[i][j]!=-1) {
                total+=map[i][j];
            }
        }
    }
    return total;
}
}
