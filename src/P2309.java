import java.io.*;
import java.util.*;

public class P2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(height);
        loop : for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        sum += height[k];
                    }
                }
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(height[k]);
                        }
                    }
                    break loop;
                }
            }
        }
    }
}
