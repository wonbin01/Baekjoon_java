import java.io.*;
import java.util.*;
public class B7662 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) //t번 반복
        {
            int k=Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int j=0;j<k;j++)
            {
                String[] command=br.readLine().split(" ");
                if(command[0].equals("I")) //I인 경우 삽입
                {
                    int key=Integer.parseInt(command[1]);
                    map.put(key,map.getOrDefault(key, 0)+1); //map에 key,개수 저장
                }
                else if(command[0].equals("D"))
                {
                    if(map.isEmpty()) continue; //map이 비어있다면, 무시
                    int type=Integer.parseInt(command[1]); //-1인지 1인지 확인
                    if(type==-1) //-1인 경우 최솟값을 삭제
                    {
                        int min=map.firstKey();
                        if(map.get(min)==1)
                        {
                            map.remove(min);
                        }
                        else
                        {
                            map.put(min,map.get(min)-1);
                        }
                    }
                    else if(type==1) //1인 경우 최댓값을 삭제
                    {
                        int max=map.lastKey();
                        if(map.get(max)==1)
                        {
                            map.remove(max);
                        }
                        else
                        {
                            map.put(max,map.get(max)-1);
                        }
                    }
                }
            }
            if(map.isEmpty()) //비어있는 경우
            {
                System.out.println("EMPTY");
            }
            else //비어있지 않은 경우
            {
                int max=map.lastKey();
                int min=map.firstKey();
                System.out.print(max+" "+min+"\n");
            }

        }
    }
}
