import java.io.*;

public class P1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder binary = new StringBuilder(br.readLine());
        binary.insert(0, "0".repeat((3 - binary.length() % 3) % 3));

        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < binary.length() / 3; i++) {
            int n = Integer.parseInt(binary.substring(i * 3, i * 3 + 3), 2);
            octal.append(Integer.toOctalString(n));
        }
        System.out.println(octal);
    }
}
