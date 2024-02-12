import java.io.*;
import java.util.*;

public class P14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int answer = 0;
        int left = 0, right = N - 1;
        while(left < right) {
            int newSolution = solutions[left] + solutions[right];
            if (newSolution > 0) {
                right--;
            } else {
                left++;
            }

            int abs = Math.abs(newSolution);
            if (abs < min) {
                min = abs;
                answer = newSolution;
            }
        }
        System.out.println(answer);
    }
}
