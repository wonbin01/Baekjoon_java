import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14891 {
    static int[] first = new int[8]; //12시부터 시계방향 
    static int[] second = new int[8];
    static int[] third = new int[8];
    static int[] fourth = new int[8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputCircle(first,br); inputCircle(second,br); inputCircle(third,br); inputCircle(fourth,br);
        int k=Integer.parseInt(br.readLine()); // 시행 횟수
        for(int i=0;i<k;i++) {
            String[] input = br.readLine().split(" ");
            int circle = Integer.parseInt(input[0]); // 돌릴 바퀴
            int direction = Integer.parseInt(input[1]); //돌릴 방향
            if(circle==1) {
                changeCircle(first, direction, circle);
            }
            else if(circle==2) {
                changeCircle(second, direction, circle);
            }
            else if(circle==3) {
                changeCircle(third, direction, circle);
            }
            else if(circle==4) {
                changeCircle(fourth, direction, circle);
            }
        }
        int result=calculateResult();
        System.out.println(result);
    }

    static void inputCircle(int[] candidate,BufferedReader br) throws IOException {
        String input = br.readLine();
        for(int i=0;i<8;i++) {
            char c = input.charAt(i);
            int n = c-'0';
            candidate[i]=n;
        }
    }

    static void changeCircle(int[] candidate, int direction, int circle) { // 1:시계방향, -1:반시계방향, N극:0, S극:1
        if(direction == 1) { // 시계방향인 경우
            rotateCircle(circle, direction);
        }
        else{ // 반시계 방향 인경우
            rotateCircle(circle, direction);
        }
    }

    static void rotateClockwise(int[] candidate) { //시계방향으로 회전
        int last = candidate[7];  // 마지막 값 저장
        for (int i = 7; i > 0; i--) {
            candidate[i] = candidate[i - 1];
        }
        candidate[0] = last;
    }
    static void rotateCounterClockwise(int[] candidate) { //반시계방향으로 회전
        int first = candidate[0];
        for (int i = 0; i < 7; i++) {
            candidate[i] = candidate[i + 1];
        }
        candidate[7] = first;
    }
    static void rotateCircle(int circle, int direction) {
        if(circle==1) {
            if(first[2] != second[6] && direction==1) { // 시계방향인 경우
                rotateCounterClockwise(second); //반시계방향으로 회전
                if(second[2]!=third[6]) {
                    rotateClockwise(third); //시계방향으로 회전
                    if(third[2]!=fourth[6]) {
                        rotateCounterClockwise(fourth);
                    }
                }
            }
            else if (first[2] != second[6] && direction==-1) { // 반시계방향인 경우
                rotateClockwise(second); //시계방향회전
                if(second[2]!=third[6]) {
                    rotateCounterClockwise(third); //반시계방향 회전
                    if(third[2]!=fourth[6]) {
                        rotateClockwise(third); //시계방향회전
                    }
                }
            }
            if(direction==1) rotateClockwise(first);
            if(direction==-1) rotateCounterClockwise(first);
        }
        else if (circle==2) {
            if(first[2]!=second[6] && direction==1) {
                rotateCounterClockwise(first);
            }
            else if (first[2]!=second[6] && direction==-1) {
                rotateCounterClockwise(first);
            }

            if(second[2]!=third[6] && direction==1) {
                rotateCounterClockwise(third);
                if(third[2]!=fourth[6]) {
                    rotateClockwise(fourth);
                }
            }
            else if (second[2]!=third[6] && direction==-1) {
                rotateClockwise(third);
                if(third[2]!=fourth[6]) {
                    rotateCounterClockwise(fourth);
                }
            }
            if(direction==1) rotateClockwise(second);
            if(direction==-1) rotateCounterClockwise(second);
        }
        else if(circle==3) {
            if(second[2]!=third[6] && direction==1) {
                rotateCounterClockwise(second);
                if(second[6]!=first[2]) {
                    rotateClockwise(first);
                }
            }
            else if(second[2]!=third[6] && direction==-1) {
                rotateClockwise(second);
                if(second[6]!=first[2]) {
                    rotateCounterClockwise(first);
                }
            }
            if(third[2]!=fourth[6] && direction==1) {
                rotateCounterClockwise(fourth);
            }
            else if(third[2]!=fourth[6] && direction==-1) {
                rotateClockwise(fourth);
            }
            if(direction==1) rotateClockwise(third);
            if(direction==-1) rotateCounterClockwise(third);
        }
        else if(circle==4) {
            if(fourth[6]!=third[2] && direction==1) {
                rotateCounterClockwise(third);
                if(third[6]!=second[2]) {
                    rotateClockwise(second);
                    if(second[6]!=first[2]) {
                        rotateCounterClockwise(first);
                    }
                }
            }
            else if(fourth[6]!=third[2] && direction==-1) {
                rotateClockwise(third);
                if(third[6]!=second[2]) {
                    rotateCounterClockwise(second);
                    if(second[6]!=first[2]) {
                        rotateClockwise(first);
                    }
                }
            }
            if(direction==1) rotateClockwise(fourth);
            if(direction==-1) rotateCounterClockwise(fourth);
        }
    }
    static int calculateResult() {
        int total=0;
        if(first[0]==1) total+=1;
        if(second[0]==1) total+=2;
        if(third[0]==1) total+=4;
        if(fourth[0]==1) total+=8;
        return total;
    }
}
