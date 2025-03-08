import java.io.*;
import java.util.*;
public class B1991 
{
    static Map<String,Node> tree=new HashMap<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            String parent=input[0];
            String left=input[1];
            String right=input[2];

            //부모 노드가 없으면 생성
            tree.putIfAbsent(parent, new Node(parent));

            //왼쪽 자식이 있으면 연결
            if(!left.equals("."))
            {
                tree.putIfAbsent(left, new Node(left));
                tree.get(parent).left=tree.get(left);
            }
            // 오른쪽 자식이 있으면 연결
            if (!right.equals(".")) {
                tree.putIfAbsent(right, new Node(right));
                tree.get(parent).right = tree.get(right);
            }
        }
        Node root=tree.get("A"); //항상 A부터 주어짐
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
    static class Node
    {
        String data;
        Node left,right;
        Node(String data){
            this.data=data;
        }
    }
    static void preorder(Node node) //루트 왼쪽 오른쪽
    {
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) // 왼쪽 루트 오른쪽
    {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    static void postorder(Node node) // 왼쪽 오른쪽 루트
    {
        if(node ==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
