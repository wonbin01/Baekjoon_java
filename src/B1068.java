import java.io.*;
import java.util.*;
public class B1068 
{
    static Map<Integer,ArrayList<Integer>> hm=new HashMap<>();
    static int root;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //노드의 개수
        for(int i=0;i<n;i++)
        {
            hm.put(i,new ArrayList<>());
        }
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            int parent=Integer.parseInt(input[i]);
            if(parent==-1)
            {
                root=i;
            }
            else
            {
                hm.get(parent).add(i);
            }
        }
        int e=Integer.parseInt(br.readLine()); //지울 노드의 번호
        if(e==root)
        {
            System.out.println(0);
            return;
        }

        dfs(e,n);
    }
    static void dfs(int e,int n)
    {
        Stack<Integer> stack=new Stack<>();
        stack.push(root);
        int leaf=0;
        while(!stack.isEmpty())
        {
            int node=stack.pop();

            if(hm.get(node).size()==1 && hm.get(node).contains(e)) leaf++; //부모의 자식이 1개밖에 없고 그 자식 1개를 삭제하는 상황

            for(Integer neighbor : hm.get(node))
            {
                if(hm.get(neighbor).isEmpty() && neighbor!=e) 
                {
                    leaf++;
                }
                else
                {
                    if(e!=neighbor)
                    {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println(leaf);
    }
}
