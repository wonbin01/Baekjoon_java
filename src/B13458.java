import java.io.*;
public class B13458 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //시험장의 개수
        long total=0; //필요한 총 감독관 수
        int[] classroom=new int[n]; //시험장의 변수
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            classroom[i]=Integer.parseInt(input[i]);
        }
        input=br.readLine().split(" ");
        int b=Integer.parseInt(input[0]); //총감독관이 한 시험장에서 감시할 수 있는 응시자 수
        int c=Integer.parseInt(input[1]); //부감독관이 한 시험장에서 감시할 수 있는 응시자 수
        for(int i=0;i<n;i++)
        {
            int student=classroom[i]; //교실의 학생 수
            if(student<=b) //총감독관 하나만 있으면 되는경우
            {
                total++;
            }
            else
            {
                student-=b; total++;
                if(student<=c) //부감독관 하나만 있으면 되는경우
                {
                    total++;
                }
                else
                {
                    int serve=student/c;
                    if(student%c!=0)
                    {
                        serve++;
                    }
                    total+=serve;
                }
            }
        }
        System.out.println(total);
    }
}
//총 감독관은 한 시험장에 한명만 있어야함
//부감독관은 몇명있든 상관 x