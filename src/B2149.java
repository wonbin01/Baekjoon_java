import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class B2149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String secretKey = br.readLine(); //시크릿 키
        String hiddingString = br.readLine(); //암호문
        int row = secretKey.length(); //세로 길이
        int col = findColLength(hiddingString, row); // 가로 길이
        HashMap<Integer,ArrayList<Character>> hm = new HashMap<>();
        char[] sorted = makeSortedHddingString(secretKey); //정렬된 시크릿 키 문자
        makeHiddingString(hiddingString, hm,row,col);
        char[][] decode = decodeHiddingString(secretKey, sorted, hm, row, col); //decoding한 문자열
        printDecodeString(decode, col, row);
    }

    static int findColLength(String hiddingString, int row) {
        int stringLength = hiddingString.length();
        int div = stringLength/row;
        int remain = stringLength%row;
        if(remain==0) {
            return div;
        }
        return div+1;
    }

    static char[] makeSortedHddingString(String hiddingString) {
        char[] hidding = hiddingString.toCharArray();
        Arrays.sort(hidding);
        return hidding;
    }

    static void makeHiddingString(String hiddingString, HashMap<Integer,ArrayList<Character>> hm, int row,int col) {
        int current=0;
        for(int i=0;i<row;i++) {
            hm.putIfAbsent(i, new ArrayList<>());
            for(int j=current;j<current+col;j++) {
                if(j<hiddingString.length()) {
                    char c = hiddingString.charAt(j);
                    hm.get(i).add(c);
                    
                }
            }
            current+=col;
        }
    }

    static char[][] decodeHiddingString(String keyString, char[] sorted, HashMap<Integer,ArrayList<Character>> hm,int row ,int col) {
        char[][] decode = new char[row][col];
        boolean[] visited = new boolean[sorted.length];
        for(int i=0;i<keyString.length();i++) {
            char current = keyString.charAt(i);
            for(int j=0;j<sorted.length;j++) {
                if(current==sorted[j] && !visited[j]) {
                    for(int k=0;k<hm.get(j).size();k++) {
                        decode[i][k] = hm.get(j).get(k);
                    }
                    visited[j]=true;
                    break;
                }
            }
        }
        return decode;
    }

    static void printDecodeString(char[][] decode,int col, int row) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<col;i++) {
            for(int j=0;j<row;j++) {
                char c = decode[j][i];
                if(c!=' ') {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
    }
}