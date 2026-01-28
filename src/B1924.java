import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int month = Integer.parseInt(input[0]); // 월
        int days = Integer.parseInt(input[1]); // 일
        int diffDays = daysDifference(month, days);
        diffDays%=7;
        resultDay(diffDays);
    }
    static int daysDifference(int month, int days) {
        int diffDays=0;
        if(month==1) return days-1;
        for(int i=1;i<month;i++) {
            diffDays+=findEndDay(i);
        }
        diffDays+=(days-1);
        return diffDays;
    }
    static int findEndDay(int month) {
        if(month == 1 || month ==3 || month ==5 || month ==7 || month==8
            || month ==10 || month ==12) {
            return 31;
        }
        if(month == 2) {
            return 28;
        }
        return 30;
    }
    static void resultDay(int remain) {
        if(remain == 0) {
            System.out.println("MON");
        }
        if(remain == 1) {
            System.out.println("TUE");
        }
        if(remain == 2) {
            System.out.println("WED");
        }
        if(remain == 3) {
            System.out.println("THU");
        }
        if(remain == 4) {
            System.out.println("FRI");
        }
        if(remain == 5) {
            System.out.println("SAT");
        }
        if(remain == 6) {
            System.out.println("SUN");
        }
    }
}
// SUN, MON, TUE, WED, THU, FRI, SAT