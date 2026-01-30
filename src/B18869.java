import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class B18869 {
    static int[][] planetInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); // 우주의 개수
        int n = Integer.parseInt(input[1]); // 각 우주에 존재하는 항성의 개수
        planetInfo = new int[m][n]; // 각 우주에 대한 정보
        int cnt=0;
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                int planetSize = Integer.parseInt(input[j]); // 항성의 크기
                planetInfo[i][j] = planetSize;
            }
        }
        int[][] rankInfo = makeRank(m, n); // 순서가 정해진 배열
        for(int i=0;i<m-1;i++) {
            for(int j=i+1;j<m;j++) {
                if(calculatePair(rankInfo, n, i, j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static int[][] makeRank(int m, int n) {
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++) {
            int[] sorted = planetInfo[i].clone(); // 복제
            int[] rank = new int[n];
            for(int j=0;j<n;j++) rank[j] = -1;
            HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
            int ranking = 1;
            for(int j=0;j<n;j++) {
                hm.putIfAbsent(sorted[j], new ArrayList<>());
                hm.get(sorted[j]).add(j);
            }

            Arrays.sort(sorted);
            for(int j=0;j<n;j++) {
                int current = sorted[j];
                ArrayList<Integer> al = hm.get(current);
                if(al.size()!=1) {
                    for(int num : hm.get(current)) {
                        if(rank[num]==-1) {
                            rank[num] = ranking;
                            break;
                        }
                    }
                }
                else {
                    for(int num : hm.get(current)) { //인덱스값
                    if(rank[num] == -1) { // 초기값이면 채우고, 아니면 다음
                        rank[num] = ranking++;
                        break;
                    }
                }
                }
            }
            result[i] = rank;
        }
        return result;
    }

    static boolean calculatePair(int[][] rank, int n,int cx, int nx) {
        for(int i=0;i<n;i++) {
            if(rank[cx][i] != rank[nx][i]) {
                return false;
            }
        }
        return true;
    }
}