import java.io.*;
import java.util.*;
public class B31925 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[][] participant_info=new String[n][5];
        ArrayList<candidate> candidates=new ArrayList<>(); //후보를 저장
        ArrayList<String> final_contex=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<5;j++)
            {
                participant_info[i][j]=input[j];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(participant_info[i][1].equals("jaehak")
            && participant_info[i][2].equals("notyet")
            && (Integer.parseInt(participant_info[i][3])>3 || Integer.parseInt(participant_info[i][3])==-1))
            {
                candidates.add(new candidate(participant_info[i][0],Integer.parseInt(participant_info[i][4])));
            }
        }
        Collections.sort(candidates,new candidateComparator());
        if(candidates.size()<=10)
        {
            for(candidate k : candidates)
            {
                final_contex.add(k.getname());
            }
        }
        else
        {
            for(int i=0;i<10;i++)
            {
                final_contex.add(candidates.get(i).getname());
            }
        }
        Collections.sort(final_contex);
        StringBuilder sb=new StringBuilder();
        sb.append(final_contex.size()).append("\n");
        for(String key : final_contex)
        {
            sb.append(key).append("\n");
        }
        System.out.print(sb);
    }
}
class candidate
    {
        String name; int rank;
        candidate(String name,int rank)
        {
            this.name=name;
            this.rank=rank;
        }
        String getname()
        {
            return this.name;
        }
    }
    class candidateComparator implements Comparator<candidate>
    {
        public int compare(candidate c1,candidate c2)
        {
            return Integer.compare(c1.rank, c2.rank);
        }
    }