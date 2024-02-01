import java.io.*;
import java.util.*;

public class P17406 {
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static List<int[]> permutation(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    static void permute(int[] arr, int index, List<int[]> result) {
        if (index == arr.length) {
            result.add(Arrays.copyOf(arr, arr.length));
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                permute(arr, index + 1, result);
                swap(arr, index, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[3];
        for (int i = 0; i < 3; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        int[] serialized = new int[size[0] * size[1]];
        for (int i = 0; i < size[0]; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size[1]; j++) {
                serialized[i * size[1] + j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] rotation = new int[size[2]][3];
        int[] p = new int[size[2]];
        for (int i = 0; i < size[2]; i++) {
            String[] s = br.readLine().split(" ");
            rotation[i][0] = Integer.parseInt(s[0]);
            rotation[i][1] = Integer.parseInt(s[1]);
            rotation[i][2] = Integer.parseInt(s[2]);
            p[i] = i;
        }

        int answer = Integer.MAX_VALUE;
        List<int[]> permuted = permutation(p);
        for (int[] pe : permuted) {
            int[][] arr = new int[size[0]][size[1]];

            for (int i = 0; i < size[0]; i++) {
                System.arraycopy(serialized, i * size[1], arr[i], 0, size[1]);
            }
            for (int i : pe) {
                int r = rotation[i][0], c = rotation[i][1], s = rotation[i][2];
                int r1 = r - s - 2, r2 = r + s;
                int c1 = c - s - 2, c2 = c + s;
                for (int j = 0; j < s; j++) {
                    r1++; r2--; c1++; c2--;
                    int temp = arr[r2][c2];
                    for (int a = r2 - 1; a >= r1; a--) {
                        arr[a + 1][c2] = arr[a][c2];
                    }
                    for (int a = c2 - 1; a >= c1; a--) {
                        arr[r1][a + 1] = arr[r1][a];
                    }
                    for (int a = r1; a <= r2 - 1; a++) {
                        arr[a][c1] = arr[a + 1][c1];
                    }
                    for (int a = c1; a <= c2 - 1; a++) {
                        arr[r2][a] = arr[r2][a + 1];
                    }
                    arr[r2][c2 - 1] = temp;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int[] i : arr) {
                int sum = 0;
                for (int j : i) {
                    sum += j;
                }
                if (sum < min) {
                    min = sum;
                }
            }
            if (min < answer) {
                answer = min;
            }
        }
        System.out.println(answer);
    }
}
