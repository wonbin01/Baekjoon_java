import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class B3758 
{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); //테스트 케이스의 개수
        while(t>0)
        {
            t--;
            String[] input=br.readLine().split(" ");
            int n=Integer.parseInt(input[0]); //팀의 개수
            int k=Integer.parseInt(input[1]); //문제의 개수
            int id=Integer.parseInt(input[2]); //팀의 id
            int m=Integer.parseInt(input[3]); //로그 엔트리의 개수
            boolean[] isPresent=new boolean[n+1];
            ArrayList<teamScore> al=new ArrayList<>();
            for(int i=0;i<m;i++)
            {
                input=br.readLine().split(" ");
                int team=Integer.parseInt(input[0]); //해당 팀Id
                int problemNumber=Integer.parseInt(input[1]); //문제 번호
                int score=Integer.parseInt(input[2]); //획득한 점수
                if(isPresent[team]) //이미 존재하는 객체인경우
                {
                    teamScore T=null;
                    for(teamScore candidate : al)
                    {
                        if(candidate.teamId==team)
                        {
                            T=candidate;
                        }
                    }
                    if(T.score[problemNumber]<=score) //현재 획득한 점수가 더 높은 경우
                    {
                        T.score[problemNumber]=score;
                    }
                    T.finalNumber=i;
                    T.cnt++;
                }
                else //존재하지 않는 객체인경우
                {
                    teamScore T=new teamScore(k);
                    isPresent[team]=true;
                    T.teamId=team;
                    if(T.score[problemNumber]<=score) //현재 획득한 점수가 더 높은 경우
                    {
                        T.score[problemNumber]=score;
                    }
                    T.finalNumber=i; //현재 제출된 번호 저장
                    T.cnt++;; //제출된 횟수 증가
                    al.add(T);
                }
            }
            for(teamScore candidate : al)
            {
                for(int s : candidate.score)
                {
                    candidate.totalScore+=s; //최종 점수를 저장
                }
            }
            Collections.sort(al,(a,b)->{
                if(a.totalScore==b.totalScore) //최종 점수가 같은 경우
                {
                    if(a.cnt==b.cnt) //제출횟수가 같은 경우
                    {
                        return Integer.compare(a.finalNumber, b.finalNumber);
                    }
                    return Integer.compare(a.cnt, b.cnt);
                }
                return Integer.compare(b.totalScore, a.totalScore);
            });
            for(int i=0;i<n;i++)
            {
                if(al.get(i).teamId==id)
                {
                    sb.append(i+1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
 //최종점수, 제출횟수, 제출 번호
 class teamScore
 {
    public int teamId=0;
    public int totalScore=0;
    public int cnt=0;
    public int finalNumber=0;
    int[] score; //각 번호에 대한 점수를 저장
    public teamScore(int k)
    {
        score=new int[k+1];
    }
 }