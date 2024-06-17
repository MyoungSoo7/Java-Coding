import java.io.*;
import java.util.*;

public class P4084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            int[] testCase = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            if (testCase[0] == 0) {
                break;
            }
            System.out.println(solve(testCase, 0));
        }
    }

    private static int solve(int[] numbers, int count) {
        int first = numbers[0];
        for (int i = 1; i < 4; i++) {
            if (first != numbers[i]) {
                numbers[0] = Math.abs(numbers[0] - numbers[1]);
                numbers[1] = Math.abs(numbers[1] - numbers[2]);
                numbers[2] = Math.abs(numbers[2] - numbers[3]);
                numbers[3] = Math.abs(numbers[3] - first);
                return solve(numbers, count + 1);
            }
        }
        return count;
    }
}
