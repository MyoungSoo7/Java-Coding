import java.io.*;

public class P17356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        double M = (Integer.parseInt(input[1]) - Integer.parseInt(input[0])) / 400.0;
        System.out.println(1 / (1 + Math.pow(10, M)));
    }
}
