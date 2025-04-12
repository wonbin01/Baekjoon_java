import java.io.*;
import java.util.*;
public class B23326 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); // 구역의 개수
        int q=Integer.parseInt(input[1]); //쿼리의 개수
        int current_point=1; //현재 서있는 구역 저장
        int[] hongik=new int[n+1]; //구역의 정보를 저장
        TreeSet<Integer> map=new TreeSet<>();
        String[] input2=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            hongik[i+1]=Integer.parseInt(input2[i]);
            if(hongik[i+1]==1)
            {
                map.add(i+1); //명소로 지정된 경우 map에 추가
            }
        }
        for(int i=0;i<q;i++)
        {
            String[] input3=br.readLine().split(" ");
            if(Integer.parseInt(input3[0])==3) //명소에 도달하기 위해 몇칸 움직여야하는지, 없다면 -1출력
            {
                if(map.isEmpty())
                {
                    System.out.println(-1);
                    continue;
                }
                Integer target=map.ceiling(current_point);
                if(target ==null)
                {
                    target=map.ceiling(1);
                    if(target==null)
                    {
                        System.out.println(-1);
                    }
                    else
                    {
                        int temp=(n-current_point)+target;
                        System.out.println(temp);
                    }
                }
                else
                {
                    System.out.println(target-current_point);
                }
            }
            else if(Integer.parseInt(input3[0])==1) // 이미 명소면 제외, 아니면 명소지정
            {
                int spot=Integer.parseInt(input3[1]);
                if(map.contains(spot)) // 이미 명소인 경우
                {
                    map.remove(spot); //제외
                }
                else // 명소가 아닌 경우
                {
                    map.add(spot);
                }
            }
            else if(Integer.parseInt(input3[0])==2) // 시계방향으로 x만큼 이동
            {
                int move=Integer.parseInt(input3[1]);
                current_point+=move;
                current_point%=n;
                if(current_point==0) //0인 경우
                {
                    current_point=n;
                }
            }
        }
    }
}
