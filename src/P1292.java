import java.io.*;
import java.util.*;

public class P1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int index = 1;
        int num = 1;
        int count = 0;
        int sum = 0;
        while (index <= input[1]) {
            if (count == num) {
                count = 0;
                num++;
            }

            if (index >= input[0]) {
                sum += num;
            }
            index++;
            count++;
        }
        System.out.println(sum);
    }
}
