import java.io.*;
public class B1539T 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        BinarysearchTree bst=new BinarysearchTree();
        for(int i=0;i<n;i++)
        {
            int value=Integer.parseInt(br.readLine());
            bst.insert(value);
        }
        System.out.println(bst.total);
    }
}
    class Node
    {
        int value;
        Node leftNode, rightNode;
        public Node(int value)
        {
            this.value=value;
            this.leftNode=this.rightNode=null;
        }
    }
    class BinarysearchTree
    {
        Node root;
        int total=0;
        //insert메서드 구현
        public void insert(int value)
        {
            root=insertRecursive(root, value, 1);
        }
        private Node insertRecursive(Node node, int value, int depth)
        {
            if(node==null)
            {
                total+=depth;
                return new Node(value);
            }
            if(value<node.value)
            {
                node.leftNode=insertRecursive(node.leftNode, value, depth+1);
            }
            else if(value>node.value)
            {
                node.rightNode=insertRecursive(node.rightNode, value, depth+1);
            }

            return node;
        }
    }

