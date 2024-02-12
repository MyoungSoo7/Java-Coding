import java.io.*;

public class P2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (String s : br.readLine().split(" ")) {
                if (s.equals("1")) {
                    count++;
                }
            }
            switch (count) {
                case 0:
                    System.out.println('D');
                    break;
                case 1:
                    System.out.println('C');
                    break;
                case 2:
                    System.out.println('B');
                    break;
                case 3:
                    System.out.println('A');
                    break;
                case 4:
                    System.out.println('E');
                    break;
            }
        }
    }
}
