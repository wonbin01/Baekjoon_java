import java.io.IOException;

public class P_86491 {
    public static void main(String[] args) throws IOException {

    }
    public int solution(int[][] sizes) {
        int max_length=0;
        int second_higher=0;
        for(int i=0;i<sizes.length;i++) {
            for(int j=0;j<2;j++) {
                max_length=Math.max(max_length,sizes[i][j]);
            }
        }
        for(int i=0;i<sizes.length;i++) {
            int lower = Integer.MAX_VALUE;
            for(int j=0;j<2;j++) {
                if(sizes[i][j]<=lower) {
                    lower=sizes[i][j];
                }
            }
            second_higher=Math.max(second_higher, lower);
        }
        return max_length*second_higher;
    }
}
// [[60, 50], [30, 70], [60, 30], [80, 40]]	4000
// [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
// [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
// 가장 큰거 고르고, 다른 것들중에서 가장 긴거