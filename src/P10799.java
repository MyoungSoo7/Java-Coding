import java.io.*;

public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int stick = 0;
        int split = 0;
        boolean isLaser = false;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    isLaser = true;
                    stick++;
                    break;
                case ')':
                    stick--;
                    if (isLaser) {
                        split += stick;
                        isLaser = false;
                    } else {
                        split++;
                    }
                    break;
            }
        }
        System.out.println(split);
    }
}
