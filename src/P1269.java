import java.io.*;
import java.util.*;

public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int a = 0; a < A; a++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int b = 0; b < B; b++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> setA_ = new HashSet<>(Set.copyOf(setA));
        Set<Integer> setB_ = new HashSet<>(Set.copyOf(setB));

        setA_.removeAll(setB);
        setB_.removeAll(setA);

        setA_.addAll(setB_);
        System.out.println(setA_.size());
    }
}
