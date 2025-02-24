class Thread7{
    public static void main(String[] args) {
        ThreadEX7 th1=new ThreadEX7();
        th1.start();
    }
}
class ThreadEX7 extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
        }
    }
}