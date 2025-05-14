import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B28126 
{
    public static void main(String[] args) throws IOException
    {
        int total=0; //전체 탐사가능 지점점
        HashMap<String,Integer> hm=new HashMap<>(); //명령어의 개수를 저장
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //로봇의 이동횟수
        String input=br.readLine(); //입력
        String[] console=new String[n];
        for(int i=0;i<n;i++)
        {
            console[i]=String.valueOf(input.charAt(i));
            hm.put(console[i],hm.getOrDefault(console[i],0)+1);
        }
        int k=Integer.parseInt(br.readLine()); //탐사하고 싶은 지점의 수
        int[][] space=new int[k][2]; //0에는 x좌표, 1에는 y좌표표
        for(int i=0;i<k;i++)
        {
            String[] in=br.readLine().split(" ");
            int x=Integer.parseInt(in[0])-1;
            int y=Integer.parseInt(in[1])-1;
            space[i][0]=x; space[i][1]=y;
        }
        for(int[] node : space)
        {
            int target_x=node[0];
            int target_y=node[1];
            if(target_x==0 && target_y==0) //시작 지점이면 탐사 가능
            {
                total++;
                continue;
            }
            int diag=hm.getOrDefault("X",0); //X의 개수를 저장
            for(int i=0;i<diag;i++)
            {
                if(target_x>=1 && target_y>=1)
                {
                    target_x-=1; target_y-=1;
                }
                else break;
            }
            if(target_x<=hm.getOrDefault("R",0) && target_y<=hm.getOrDefault("U",0))
            {
                total++;
            }
        }
        System.out.println(total);
    }
}
//R : x증가 ,U : y 증가 , X : x,y증가
//로봇은 처음에 1,1에 위치함 + 시작 지점은 항상 접근 가능함