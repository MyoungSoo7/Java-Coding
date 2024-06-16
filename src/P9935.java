import java.io.*;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String explosion = br.readLine();
        StringBuilder sb = new StringBuilder();

        int size = 0;
        int eSize = explosion.length();
        for (char c : string.toCharArray()) {
            sb.append(c);
            size++;
            if (size >= eSize && sb.substring(size - eSize, size).equals(explosion)) {
                sb.delete(size - eSize, size);
                size -= eSize;
            }
        }
        if (sb.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
