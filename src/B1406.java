import java.io.*;
import java.util.Stack;
public class B1406 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Stack<Character> leftStack=new Stack<>();
        Stack<Character> rightStack=new Stack<>();
        for(char c : s.toCharArray())
        {
            leftStack.add(c);
        }
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            String[] command=br.readLine().split(" ");
            if(command[0].equals("P"))
            {
                char c=command[1].charAt(0);
                leftStack.push(c);
            }
            else if(command[0].equals("L"))
            {
                if(!leftStack.isEmpty())
                {
                    char move=leftStack.pop();
                    rightStack.add(move);
                }
            }
            else if(command[0].equals("D"))
            {
                if(!rightStack.isEmpty())
                {
                    char move=rightStack.pop();
                    leftStack.add(move);
                }
            }
            else if(command[0].equals("B"))
            {
                if(!leftStack.isEmpty())
                {
                    leftStack.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!leftStack.isEmpty()) 
        {
            rightStack.push(leftStack.pop());    
        }
        while (!rightStack.isEmpty()) 
        {
            sb.append(rightStack.pop());    
        }
        System.out.println(sb);
    }
}