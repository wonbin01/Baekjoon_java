import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
public class B2461 
{
    static class Student implements Comparable<Student>
    {
        int value,classIDX,index;
        public Student(int value,int classIDX,int index)
        {
            this.value=value;
            this.classIDX=classIDX;
            this.index=index;
        }
        public int compareTo(Student o)
        {
            return Integer.compare(this.value,o.value);
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]); //학급의 수
        int m=Integer.parseInt(input[1]); //학생의 수
        int[][] student=new int[n][m]; //학생들의 능력치 저장
        for(int i=0;i<n;i++)
        {
            input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                student[i][j]=Integer.parseInt(input[j]);
            }
            Arrays.sort(student[i]); //정렬시킴
        }
        PriorityQueue<Student> pq=new PriorityQueue<>();
        int maxVal=0;
        for(int i=0;i<n;i++)
        {
            Student temp=new Student(student[i][0],i,0);
            pq.offer(temp);
            maxVal=Math.max(maxVal,student[i][0]);
        }
        int minDiff=Integer.MAX_VALUE;
        while(true)
        {
            Student minStudent=pq.poll();
            int minVal=minStudent.value;
            minDiff=Math.min(minDiff,maxVal-minVal);

            if(minStudent.index+1<m) //다음학생이 존재하는 경우
            {
                int nextValue=student[minStudent.classIDX][minStudent.index+1];
                pq.offer(new Student(nextValue,minStudent.classIDX,minStudent.index+1));
                maxVal=Math.max(maxVal,nextValue); //최대값 갱신함
            }
            else //다음학생이 존재하지 않는 경우
            {
                break;
            }
        }
        System.out.println(minDiff);
    }
}
