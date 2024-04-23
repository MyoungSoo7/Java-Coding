import java.io.*;
import java.util.*;

public class P11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        for (int l = 1; l <= str.length(); l++) {
            for (int s = 0; s <= str.length() - l; s++) {
                set.add(str.substring(s, s + l));
            }
        }
        System.out.println(set.size());
    }
}
