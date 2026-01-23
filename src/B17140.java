import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class B17140 {
    static int time=0;
    static int[][] currentArrays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        currentArrays= new int[3][3];
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]); //A[r][c]==k 가 되는데 걸리는 시간
        for(int i=0;i<3;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<3;j++) {
                currentArrays[i][j]=Integer.parseInt(input[j]);
            }
        }
        while (time<=100) {
            boolean check = calculation(currentArrays, r-1, c-1, k);
            if(check) {
                System.out.println(time);
                return;
            }
            time++;
        }
        System.out.println(-1);
    }
    static boolean calculation(int[][] arrays, int r, int c, int k) { //r-1, c-1해서 전달
        int row = arrays.length; //행의 크기
        int col = arrays[0].length; //열의 크기
        if(row>r && col >c && arrays[r][c]==k) return true; //값을 찾은 경우
        if(row>=col) { //R 연산을 실행
           HashMap<Integer,ArrayList<Integer>> result =  R_Calculation(arrays, row, col);
           R_remakeArrays(result, row);
           return false;
        }
        else { // C연산을 실행
            HashMap<Integer, ArrayList<Integer>> result = C_calculation(arrays, col, row);
            C_remakeArrays(result,col);
            return false;
        }
    }

    static HashMap<Integer, ArrayList<Integer>> R_Calculation(int[][] arrays, int row, int col) {
        HashMap<Integer,ArrayList<Integer>> result = new HashMap<>();
        for(int i=0;i<row;i++) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j=0;j<col;j++) {
                if (arrays[i][j] == 0) continue;
                hm.put(arrays[i][j],hm.getOrDefault(arrays[i][j], 0)+1);
            }
            List<Integer> list = new ArrayList<>(hm.keySet());
            Collections.sort(list,(a,b) -> {
                if(hm.get(a)==hm.get(b)) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(hm.get(a), hm.get(b));
            });
            ArrayList<Integer> sortedList = new ArrayList<>();
            for(int n : list) {
                sortedList.add(n);
                sortedList.add(hm.get(n));
            }
            result.put(i, sortedList);
        }
        return result;
    }

    static HashMap<Integer, ArrayList<Integer>> C_calculation(int[][] arrays, int col, int row) {
        HashMap<Integer,ArrayList<Integer>> result = new HashMap<>();
        for(int i=0;i<col;i++) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j=0;j<row;j++) {
                if (arrays[j][i] == 0) continue;
                    hm.put(arrays[j][i], hm.getOrDefault(arrays[j][i], 0) + 1);
            }
            List<Integer> list = new ArrayList<>(hm.keySet());
            Collections.sort(list,(a,b) -> {
                if(hm.get(a)==hm.get(b)) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(hm.get(a), hm.get(b));
            });
            ArrayList<Integer> sortedList = new ArrayList<>();
            for(int n : list) {
                sortedList.add(n);
                sortedList.add(hm.get(n));
            }
            result.put(i, sortedList);
        }
        return result;
    }

    static void R_remakeArrays(HashMap<Integer, ArrayList<Integer>> result, int row) {
        int max_col=0;
        for(ArrayList<Integer> al : result.values()) {
            int length = al.size();
            max_col = Math.max(max_col,length);
            max_col = Math.min(max_col,100);
        }
        int[][] remakeArrays = new int[row][max_col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<max_col;j++) {
                if(j>=result.get(i).size()) {
                    remakeArrays[i][j]=0;
                }
                else {
                    remakeArrays[i][j] = result.get(i).get(j);
                }
            }
        }
        currentArrays=remakeArrays;
    }

    static void C_remakeArrays(HashMap<Integer, ArrayList<Integer>> result, int col) {
        int max_row=0;
        for(ArrayList<Integer> al : result.values()) {
            int length = al.size();
            max_row = Math.max(max_row, length);
            max_row = Math.min(max_row,100);
        }
        int[][] remakeArrays = new int[max_row][col];
        for(int i=0;i<col;i++) {
            for(int j=0;j<max_row;j++) {
                if(j>=result.get(i).size()) {
                    remakeArrays[j][i]=0;
                }
                else {
                    remakeArrays[j][i] = result.get(i).get(j);
                }
            }
        }
        currentArrays=remakeArrays;
    }
}
