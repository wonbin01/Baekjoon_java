import java.io.*;
import java.util.*;

public class B9017 {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) 
        {
            int N = Integer.parseInt(br.readLine()); // 선수 수
            String[] input = br.readLine().split(" ");

            // 각 팀의 선수 등수를 저장할 Map
            HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
            
            // 각 선수의 팀 정보 입력
            for (int i = 0; i < N; i++) 
            {
                int team = Integer.parseInt(input[i]);
                teams.putIfAbsent(team, new ArrayList<>());
                teams.get(team).add(i + 1); // 선수의 등수는 1부터 시작하므로 i+1
            }

            int minScore = Integer.MAX_VALUE;
            int winnerTeam = 0;

            // 각 팀에 대해서 점수 계산
            for (int team : teams.keySet()) {
                ArrayList<Integer> scores = teams.get(team);
                
                // 팀에 6명 이상이 있어야 점수 계산 가능
                if (scores.size() < 6) continue;

                // 상위 4명 선택을 위해 오름차순 정렬
                Collections.sort(scores);

                // 상위 4명의 점수 합산
                int totalScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);

                // 우승 조건: 점수가 작거나, 동점 시 다섯 번째 점수가 더 작은 팀
                if (totalScore < minScore) {
                    minScore = totalScore;
                    winnerTeam = team;
                } else if (totalScore == minScore) {
                    // 총합이 같을 경우 다섯 번째 선수 점수 비교
                    if (scores.get(4) < teams.get(winnerTeam).get(4)) {
                        winnerTeam = team;
                    }
                }
            }

            sb.append(winnerTeam).append("\n");
        }

        System.out.print(sb);
    }
}
