import java.util.Scanner;

public class B10485 
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(); //사용자가 입력한 명령의 수
        queueex queue=new queueex();
        for(int i=0;i<n;i++)
        {
            String command=scanner.next();
            switch (command)
            {
                case "push":
                    int number=scanner.nextInt();
                    queue.push(number);
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.getsize();
                    break;
                case "empty":
                    queue.isEmpty();
                    break;
                case "front":
                    queue.getfront();
                    break;
                case "back":
                    queue.getback();
                    break;
            }
        }
        scanner.close();
    }

    public static class queueex
    {
        private int[] queue;
        private int front;
        private int tail;
        private int size;
        private final int Max_Queue_Size= 10001;

        public queueex()
        {
            queue=new int[Max_Queue_Size];
            front=-1;
            tail=-1;
            size=0;
        }

        public void push(int number)
        {
            if(tail==-1) //큐가 비어있는 경우
            {
                front++;
            }
            tail++;
            queue[tail]=number;
            size++;
        }
        public void pop()
        {
            if(size==0) //큐가 비어있는 경우
            {
                System.out.println(-1);
            }
            else
            {
                System.out.println(queue[front]);
                front++;
                size--;
                if(size==0)
                {
                    front=-1;
                    tail=-1;
                }
            }
        }
        public void getsize()
        {
            System.out.println(size);
        }
        public void isEmpty()
        {
            if(size==0)
            {
                System.out.println(1);
            }
            else
            {
                System.out.println(0);
            }
        }
        public void getfront()
        {
            if(size!=0)
            {
                System.out.println(queue[front]);
            }
            else
            {
                System.out.println(-1);
            }
        }
        public void getback()
        {
            if(size!=0)
            {
                System.out.println(queue[tail]);
            }
            else
            {
                System.out.println(-1);
            }
        }
    }
}
