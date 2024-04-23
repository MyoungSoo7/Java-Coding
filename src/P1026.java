import java.io.*;
import java.util.*;

public class P1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] AInput = br.readLine().split(" ");
        List<Integer> A = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            A.add(Integer.parseInt(AInput[n]));
        }

        String[] BInput = br.readLine().split(" ");
        List<Integer> B = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            B.add(Integer.parseInt(BInput[n]));
        }

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        int S = 0;
        for (int n = 0; n < N; n++) {
            S += (A.get(n) * B.get(n));
        }
        System.out.println(S);
    }
}
