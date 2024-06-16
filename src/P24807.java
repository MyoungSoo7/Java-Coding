import java.io.*;

public class P24807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int l = Integer.parseInt(input[3]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i * a <= l; i++) {
            for (int j = 0; i * a + j * b <= l ; j++) {
                if ((l - (i * a + j * b)) % c == 0) {
                    sb.append(i).append(" ").append(j).append(" ").append((l - (i * a + j * b)) / c).append("\n");
                }
            }
        }
        if (sb.isEmpty()) {
            System.out.println("impossible");
        } else {
            System.out.println(sb.toString().strip());
        }
    }
}
