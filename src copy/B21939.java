import java.io.*;
import java.util.*;
public class B21939
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //문제의 개수가 주어짐
        TreeMap<Integer,TreeSet<Integer>> levelMap=new TreeMap<>(); //난이도별 문제 저장
        Map<Integer,Integer> problemMap=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            int p=Integer.parseInt(input[0]); //문제 번호
            int level=Integer.parseInt(input[1]); //난이도
            problemMap.put(p,level); //문제 번호와 난이도 맵핑

            levelMap.putIfAbsent(level, new TreeSet<>()); //level이 비어있으면 새로운 treeset을 생성
            levelMap.get(level).add(p); // levelset에 문제번호를 집어넣음
        }
        int m=Integer.parseInt(br.readLine()); //명령어 몇번 반복하는지 주어짐
        for(int i=0;i<m;i++)
        {
            String[] input=br.readLine().split(" "); //명령어 + 문제 번호 + 문제 난이도
            if(input[0].equals("add")) //문제 추가
            {
                int p=Integer.parseInt(input[1]); //문제 번호
                int level=Integer.parseInt(input[2]); //문제 난이도
                problemMap.put(p,level); //문제 번호와 난이도 맵핑

                if(levelMap.containsKey(level)) //난이도를 이미 가지고 있는 경우
                {
                    levelMap.get(level).add(p); //이미 존재하는 난이도 모음집에 문제를 집어넣음
                }
                else //난이도 모음집에 존재하지 않는 경우
                {
                    levelMap.putIfAbsent(level, new TreeSet<>()); //새로운 난이도 모음집을 만듦
                    levelMap.get(level).add(p);
                }
            }
            else if(input[0].equals("recommend")) //문제 추천
            {
                int x=Integer.parseInt(input[1]);
                if(x==1) //가장 어려운 난이도 중에서 문제 번호가 큰 거 출력
                {
                    int max=levelMap.lastKey(); //treemap에서 가장 큰 key 반환
                    int maxProblem=levelMap.get(max).last(); //가장 큰 key중에서 가장 큰 element
                    System.out.println(maxProblem);

                }
                else if(x==-1) //가장 쉬운 난이도 중에서 문제 번호가 가장 작은거 출력
                {
                    int min=levelMap.firstKey(); //treemap에서 가장 작은 key 반환
                    int minProblem=levelMap.get(min).first(); //가장 작은 key중에서 가장 작은 element
                    System.out.println(minProblem);
                }
            }
            else if(input[0].equals("solved")) //문제 제거
            {
                int p=Integer.parseInt(input[1]);
                int key=problemMap.get(p); //난이도
                levelMap.get(key).remove(p); //levelmap에서 문제 삭제함
                if(levelMap.get(key).isEmpty()) //난이도 모음집에서 문제 삭제했는데 비어있을 경우
                {
                    levelMap.remove(key);
                }
                problemMap.remove(p);
            }
        }
    }
}
//recommend 1 -> 가장 어려운 문제 번호를 출력(어려운 문제가 여러 개인경우 번호가 큰거 출력)
// ''       -1 -> 가장 쉬운 문제 번호를 출력(여러개가 있으면 번호가 작은 것 출력)
//add p l -> 난이도가 L인 문제번호 p를 추가
//solved p -> 문제 번호 p를 제거