import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1759 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int length = Integer.parseInt(input[0]); //암호문의 길이
        int cnt = Integer.parseInt(input[1]); // 암호문의 후보
        String[] secretCandidate = new String[cnt];
        input = br.readLine().split(" ");
        for(int i=0;i<cnt;i++) {
            secretCandidate[i] = input[i];
        }
        Arrays.sort(secretCandidate);
        makeSecret(secretCandidate, 0, new ArrayList<>(), length);
        System.out.println(sb.toString());
    }
    static void makeSecret(String[] secretCandidate, int index,
                       ArrayList<String> list, int length) {
    if (list.size() == length && checkValidInput(list)) {       
        makeResult(list);
        return;
    }
    for (int i = index; i < secretCandidate.length; i++) {
        list.add(secretCandidate[i]);
        makeSecret(secretCandidate, i + 1, list, length);
        list.remove(list.size() - 1);
    }
}

    static boolean checkValidInput(ArrayList<String> list) {
        int moumCnt=0; //모음의 개수
        for(String c : list) {
            if(c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
                moumCnt++;
            }
        }
        int jaumCnt=list.size()-moumCnt;
        if(moumCnt>=1 && jaumCnt>=2) {
            return true;
        }
        return false;
    }

    static void makeResult(ArrayList<String> list) {
        for(String c : list) {
            sb.append(c);
        }
        sb.append("\n");
    }
}