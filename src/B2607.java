import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String target = br.readLine();
        // 기준 단어의 알파벳 빈도수를 저장할 배열
        int[] targetAlphabet = new int[26];
        for (char c : target.toCharArray()) {
            targetAlphabet[c - 'A']++;
        }

        int similarWordsCount = 0;
        for (int i = 0; i < n - 1; i++) {
            String candidate = br.readLine();
            
            // 길이 차이가 2 이상 나면 절대 비슷한 단어가 될 수 없음
            if (Math.abs(target.length() - candidate.length()) > 1) {
                continue;
            }

            // 기준 단어의 빈도수 배열을 복사하여 사용 (원본은 보존해야 함)
            int[] tempTargetAlphabet = targetAlphabet.clone();
            int sameCharCount = 0;

            // 비교 대상 단어의 알파벳을 순회하며 기준 단어에 있는지 확인
            for (char c : candidate.toCharArray()) {
                if (tempTargetAlphabet[c - 'A'] > 0) {
                    sameCharCount++; // 공통으로 존재하는 알파벳 개수 증가
                    tempTargetAlphabet[c - 'A']--; // 사용한 알파벳은 하나 줄임
                }
            }

            // 1. 두 단어의 길이가 같은 경우
            if (target.length() == candidate.length()) {
                // 한 글자만 바꾸거나, 구성이 완전히 같은 경우
                // 바꾼 경우: 공통 알파벳 개수 = 길이 - 1
                // 같은 경우: 공통 알파벳 개수 = 길이
                if (sameCharCount == target.length() || sameCharCount == target.length() - 1) {
                    similarWordsCount++;
                }
            } 
            // 2. 기준 단어가 1글자 더 긴 경우 (비교 대상에서 한 글자 추가)
            else if (target.length() - 1 == candidate.length()) {
                // 공통 알파벳 개수가 비교 대상 단어의 길이와 같아야 함
                if (sameCharCount == candidate.length()) {
                    similarWordsCount++;
                }
            } 
            // 3. 기준 단어가 1글자 더 짧은 경우 (비교 대상에서 한 글자 제거)
            else if (target.length() + 1 == candidate.length()) {
                // 공통 알파벳 개수가 기준 단어의 길이와 같아야 함
                if (sameCharCount == target.length()) {
                    similarWordsCount++;
                }
            }
        }
        System.out.println(similarWordsCount);
    }
}