import java.io.*;
import java.util.*;

public class P2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] list = new int[3];
        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
