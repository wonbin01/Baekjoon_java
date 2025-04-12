import java.io.*;
import java.util.*;

public class B21944 
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); // 현재 들어있는 문제의 수
        
        // 데이터 구조 초기화
        HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> algo = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> list = new TreeMap<>();
        HashMap<Integer, Integer> problemToAlgo = new HashMap<>();
        HashMap<Integer, Integer> problemToLevel = new HashMap<>();
        
        // 초기 문제 입력
        for (int i = 0; i < n; i++) 
        {
            String[] input = br.readLine().split(" ");
            int problem = Integer.parseInt(input[0]); // 문제 번호
            int level = Integer.parseInt(input[1]); // 난이도
            int G = Integer.parseInt(input[2]); // 알고리즘 분류
            
            algo.putIfAbsent(G, new TreeMap<>());
            algo.get(G).putIfAbsent(level, new TreeSet<>());
            algo.get(G).get(level).add(problem);

            list.putIfAbsent(level, new TreeSet<>());
            list.get(level).add(problem);

            problemToAlgo.put(problem, G);
            problemToLevel.put(problem, level);
        }
        
        int m = Integer.parseInt(br.readLine()); // 명령어의 개수
        
        // 명령어 처리
        for (int i = 0; i < m; i++) 
        {
            String[] input2 = br.readLine().split(" ");
            String command = input2[0];
            
            // 문제 추가
            if (command.equals("add")) 
            {
                int p = Integer.parseInt(input2[1]); // 문제 번호
                int level = Integer.parseInt(input2[2]); // 난이도
                int g = Integer.parseInt(input2[3]); // 알고리즘
                
                algo.putIfAbsent(g, new TreeMap<>());
                algo.get(g).putIfAbsent(level, new TreeSet<>());
                algo.get(g).get(level).add(p);
                
                list.putIfAbsent(level, new TreeSet<>());
                list.get(level).add(p);
                
                problemToAlgo.put(p, g);
                problemToLevel.put(p, level);
            }
            
            // 특정 알고리즘에서 가장 어려운/쉬운 문제 추천
            else if (command.equals("recommend")) 
            {
                int g = Integer.parseInt(input2[1]);
                int x = Integer.parseInt(input2[2]);
                
                if (algo.containsKey(g) && !algo.get(g).isEmpty()) 
                {
                    if (x == 1) 
                    { // 가장 어려운 문제
                        int max = algo.get(g).lastKey();
                        int maxProblem = algo.get(g).get(max).last();
                        sb.append(maxProblem).append("\n");
                    } 
                    else if (x == -1) 
                    { // 가장 쉬운 문제
                        int min = algo.get(g).firstKey();
                        int minProblem = algo.get(g).get(min).first();
                        sb.append(minProblem).append("\n");
                    }
                }
                 else 
                 {
                    sb.append(-1).append("\n");
                }
            }
            
            // 알고리즘 상관 없이 가장 어려운/쉬운 문제 추천
            else if (command.equals("recommend2")) 
            {
                int x = Integer.parseInt(input2[1]);
                
                if (!list.isEmpty()) 
                {
                    if (x == 1) 
                    {
                        int max = list.lastKey();
                        int maxProblem = list.get(max).last();
                        sb.append(maxProblem).append("\n");
                    } 
                    else if (x == -1) 
                    {
                        int min = list.firstKey();
                        int minProblem = list.get(min).first();
                        sb.append(minProblem).append("\n");
                    }
                } 
                else 
                {
                    sb.append(-1).append("\n");
                }
            }
            
            // 특정 난이도 기준으로 문제 추천
            else if (command.equals("recommend3")) 
            {
                int x = Integer.parseInt(input2[1]);
                int L = Integer.parseInt(input2[2]);
                
                if (x == 1) 
                {
                    Integer higher = list.ceilingKey(L);
                    if (higher == null || list.get(higher) == null) 
                    {
                        sb.append(-1).append("\n");
                    } 
                    else 
                    {
                        int easyProblem = list.get(higher).first();
                        sb.append(easyProblem).append("\n");
                    }
                } 
                else if (x == -1) 
                {
                    Integer lower = list.lowerKey(L);
                    if (lower == null || list.get(lower) == null) 
                    {
                        sb.append(-1).append("\n");
                    } 
                    else 
                    {
                        int hardProblem = list.get(lower).last();
                        sb.append(hardProblem).append("\n");
                    }
                }
            }
            
            // 문제 해결 후 삭제
            else if (command.equals("solved")) 
            {
                int p = Integer.parseInt(input2[1]); // 문제 번호
                Integer algorithm = problemToAlgo.get(p);
                Integer level = problemToLevel.get(p);
                
                if (algorithm != null && level != null) 
                {
                    if (algo.containsKey(algorithm) && algo.get(algorithm).containsKey(level)) 
                    {
                        algo.get(algorithm).get(level).remove(p);
                        if (algo.get(algorithm).get(level).isEmpty()) 
                        {
                            algo.get(algorithm).remove(level);
                        }
                        if (algo.get(algorithm).isEmpty()) 
                        {
                            algo.remove(algorithm);
                        }
                    }

                    if (list.containsKey(level)) 
                    {
                        list.get(level).remove(p);
                        if (list.get(level).isEmpty()) 
                        {
                            list.remove(level);
                        }
                    }

                    problemToAlgo.remove(p);
                    problemToLevel.remove(p);
                }
            }
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}
