import java.io.*;
import java.util.*;
public class B21276 
{
    static HashMap<String,ArrayList<String>> Parent_List=new HashMap<>();
    static HashMap<String,ArrayList<String>> Child_list=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine()); //가문의 개수
        String[] present_neighbor=new String[k]; //현재 살고 있는 주민 이름 저장
        String[] input=br.readLine().split(" ");
        for(int i=0;i<k;i++)
        {
            present_neighbor[i]=input[i];
            Parent_List.put(present_neighbor[i],new ArrayList<>());
            Child_list.put(present_neighbor[i],new ArrayList<>());
        }
        int m=Integer.parseInt(br.readLine()); //기억하는 가문의 수
        for(int i=0;i<m;i++)
        {
            input=br.readLine().split(" ");
            String x=input[0];
            String y=input[1]; 
            Parent_List.get(x).add(y); //x의 조상 중에 y가 있음
        }
        ArrayList<String> al=new ArrayList<>();
        int count=0; //루트의 개수를 저장
        for(int i=0;i<k;i++)
        {
            if(Parent_List.get(present_neighbor[i]).isEmpty()) //부모가 없는 node
            {
                al.add(present_neighbor[i]);
                count++;
            }
        }
        sb.append(count).append("\n"); //루트의 개수를 출력
        Collections.sort(al);
        for(String node : al)
        {
            sb.append(node).append(" ");
        }
        sb.append("\n");
        for(String child : present_neighbor)
        {
            if(Parent_List.get(child).isEmpty()) continue;

            HashSet<String> directParents=new HashSet<>(Parent_List.get(child));
            for(String parent : Parent_List.get(child))
            {
                for(String ancestor : Parent_List.get(parent))
                {
                    directParents.remove(ancestor);
                }
            }
            for(String directParent : directParents)
            {
                Child_list.get(directParent).add(child);
            }
        }
        Arrays.sort(present_neighbor);
        for(String present : present_neighbor)
        {
            sb.append(present).append(" ");
            int num=Child_list.get(present).size();
            sb.append(num).append(" ");
            if(num>0)
            {
                ArrayList<String> childhood=new ArrayList<>();
                for(String child : Child_list.get(present))
                {
                    childhood.add(child);
                }
                Collections.sort(childhood);
                for(String child : childhood)
                {
                    sb.append(child).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
// root먼저 찾음(부모가 없는 node찾음)
//부모가 하나면 바로 연결 가능
//배열 순회하면서 자식으로 하나씩 추가