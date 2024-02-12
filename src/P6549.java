import java.io.*;
import java.util.*;

public class P6549 {
    static long getMaxArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i < hist.length; i++) {
            while (!stack.isEmpty() && hist[i] <= hist[stack.peek()]) {
                int height = hist[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, ((long) height * width));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = hist[stack.pop()];
            int width = stack.isEmpty() ? hist.length : hist.length - 1 - stack.peek();
            maxArea = Math.max(maxArea, ((long) height * width));
        }
        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            int[] hist = new int[N];
            for (int i = 0; i < N; i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getMaxArea(hist));
        }
    }
}
