import java.io.*;
import java.util.Arrays;

public class B2295 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];

        for (int i = 0; i < n; i++) 
        {
            number[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(number); // 숫자 정렬

        for (int i = n - 1; i >= 0; i--) 
        {
            if (findMax(number[i], i, number)) 
            {
                System.out.print(sb);
                return;
            }
        }
    }

    public static boolean findMax(int p, int en, int[] number) 
    {
        // 같은 수 3개
        if (p % 3 == 0 && binarySearch(number, 0, en, p / 3)) 
        {
            sb.append(p).append("\n");
            return true;
        }

        // 같은 수 2개 + 다른 수 1개
        for (int i = en; i >= 0; i--) 
        {
            int doubled = 2 * number[i];
            int key = p - doubled;
            if (key > 0 && binarySearch(number, 0, en, key)) 
            {
                sb.append(p).append("\n");
                return true;
            }
        }

        // 서로 다른 수 3개
        for (int i = en; i >= 0; i--) 
        {
            for (int j = i - 1; j >= 0; j--) 
            {
                int key = p - number[i] - number[j];
                if (key > 0 && binarySearch(number, 0, j - 1, key)) 
                {
                    sb.append(p).append("\n");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int start, int end, int key) 
    {
        while (start <= end) 
        {
            int mid = (start + end) / 2;
            if (arr[mid] == key) 
            {
                return true;
            } else if (arr[mid] < key) 
            {
                start = mid + 1;
            } else 
            {
                end = mid - 1;
            }
        }
        return false;
    }
}
