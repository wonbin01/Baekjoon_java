import java.io.*;
import java.util.*;
public class B1043
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //사람의 수
        int m=Integer.parseInt(input[1]); //파티의 수
        input=br.readLine().split(" ");
        int fact=Integer.parseInt(input[0]); //진실을 아는 사람의 수
        HashSet<Integer> ts=new HashSet<>(); //진실을 아는 사람을 저장
        if(fact!=0) //진실을 아는 사람이 있다면
        {
            for(int i=1;i<fact+1;i++)
            {
                ts.add(Integer.parseInt(input[i])); //진실을 아는 사람들 저장
            }
        }
        ArrayList<ArrayList<Integer>> parties=new ArrayList<>(); //파티들의 정보 저장
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            int num=Integer.parseInt(input[0]); //파티 참석자 수 저장
            ArrayList<Integer> party=new ArrayList<>();

            for(int j=1;j<num+1;j++)
            {
                party.add(Integer.parseInt(input[j]));
            }
            parties.add(party);
        }
        boolean changed=true; //진실이 퍼지는 과정
        while(changed)
        {
            changed=false;
            for(ArrayList<Integer> party : parties)
            {
                boolean hasTruthful=false;
                for(int person : party)
                {
                    if(ts.contains(person)) //한명이라도 진실을 아는 사람이 있다면
                    {
                        hasTruthful=true;
                        break;
                    }
                }
                if(hasTruthful)
                {
                    for(int person :party)
                    {
                        if(!ts.contains(person))
                        {
                            ts.add(person);
                            changed=true;
                        }
                    }
                }
            }
        }

        int total=0;
        for(ArrayList<Integer> party : parties)
        {
            boolean hasTruthful=false;
            for(int person : party)
            {
                if(ts.contains(person))
                {
                    hasTruthful=true;
                    break;
                }
            }
            if(!hasTruthful)
            {
                total++;
            }
        }
        System.out.println(total);
    }
}
