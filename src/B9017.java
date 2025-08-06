import java.io.*;
import java.util.*;

public class B9017 {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (t-->0) 
        {
            int n=Integer.parseInt(br.readLine()); //선수들의 수
            String[] input=br.readLine().split(" ");
            int[] teamScore = new int[n];
            int[] teamCount = new int[201];
            for (int i = 0; i < n; i++) 
            {
                teamScore[i] = Integer.parseInt(input[i]);
                teamCount[teamScore[i]]++;
            }
            // 팀이 6명 이상인 경우에만 점수 부여
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            int rank = 0;
            for (int i = 0; i < n; i++) 
            {
                int team = teamScore[i];
                if (teamCount[team] >= 6) 
                {
                    hm.putIfAbsent(team, new ArrayList<>());
                    hm.get(team).add(rank++);
                }
            }
            int winner=0; int winner_score=Integer.MAX_VALUE; int extra_point=Integer.MAX_VALUE;
            for(int candidate : hm.keySet())
            {
                ArrayList<Integer> al=hm.get(candidate);
                if(al.size()<6) continue;
                Collections.sort(al);
                int total_score=0;
                for(int i=0;i<4;i++)
                {
                    total_score+=al.get(i);
                }
                if(total_score==winner_score) //4번째 선수까지 합산이 같은 경우
                {
                    int extra=al.get(4);
                    if(extra<extra_point)
                    {
                        winner=candidate;
                        extra_point=extra;
                    }
                    continue;
                }
                if(total_score<winner_score)
                {
                    winner=candidate;
                    winner_score=total_score;
                    extra_point=al.get(4);
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.println(sb);
    }
}
