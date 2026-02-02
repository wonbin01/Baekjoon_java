import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1107 {
    static int[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetInput = br.readLine();
        int targetNum = Integer.parseInt(targetInput);


        ArrayList<Integer> target = new ArrayList<>();
        for (char c : targetInput.toCharArray()) {
            target.add(c-'0');
        }
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
        if(m!=0) { // 고장난 버튼이 0이 아닌 경우
            String[] input = br.readLine().split(" ");
            broken = new int[m];
            for(int i=0;i<m;i++) {
                broken[i] = Integer.parseInt(input[i]);
            }
        }
        if(targetNum == 100) {
            System.out.println(0);
            return;
        }
        int current = 100; // 초기에 보고 있는 값
        int diff = Math.abs(targetNum-current);
        if(!plusMinusButtonRequired(target, m)) { // 숫자 버튼으로만 이동이 가능한 경우
            int length = target.size();
            System.out.println(Math.min(diff, length));
            return;
        }

        // 숫자버튼이 고장나서 +-를 사용해야하는 경우
        // 만들 수 있는 가장 가까운 수 만들고, +- 버튼으로 이동
        int totalCnt = Math.abs(targetNum - current);

        for (int tmp = 0; tmp <= 999999; tmp++) {
            String tmpString = String.valueOf(tmp);
            ArrayList<Integer> al = new ArrayList<>();

                for (int i = 0; i < tmpString.length(); i++) {
                al.add(tmpString.charAt(i) - '0');
            }

        if (!plusMinusButtonRequired(al, m)) {
            int buttonCnt = al.size();
            buttonCnt += Math.abs(targetNum - tmp);
            totalCnt = Math.min(totalCnt, buttonCnt);
        }
    }
    System.out.println(totalCnt);
    }
    static boolean plusMinusButtonRequired(ArrayList<Integer> target,int m) {
        if(m==0) return false; // 고장난게 없으니까 false
        for(int num : broken) {
            if(target.contains(num)) { // 고장난 숫자를 가지고 있으므로 true
                return true;
            }
        }
        return false; // 고장난 숫자를 가지고 있지 않으므로 false
    }
}
// 5457
// 3
// 6 7 8 -> 6 ( 5455로 갔다가 ++해서 5457 )