import java.io.*;
import java.util.*;

public class B1620 
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]); // 포켓몬의 수
        int m = Integer.parseInt(input1[1]); // 문제의 개수

        HashMap<String, Integer> nameToIndex = new HashMap<>(); // 포켓몬 이름 -> 번호
        String[] indexToName = new String[n + 1]; // 번호 -> 포켓몬 이름

        for (int i = 1; i <= n; i++) 
        {
            String pokemon = br.readLine();
            indexToName[i] = pokemon;
            nameToIndex.put(pokemon, i);
        }

        for (int i = 0; i < m; i++) 
        {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) // 숫자인 경우
            { 
                int index = Integer.parseInt(input);
                sb.append(indexToName[index]).append("\n");
            }
             else // 포켓몬 이름인 경우 
             { 
                sb.append(nameToIndex.get(input)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
