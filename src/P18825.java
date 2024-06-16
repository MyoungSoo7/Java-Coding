import java.io.*;

public class P18825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(Integer.parseInt(input[0]) - Integer.parseInt(input[1]));
    }
}
