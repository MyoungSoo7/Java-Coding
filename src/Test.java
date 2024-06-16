import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));

        for (int i = 0; i < 500000; i++) {
            bw.write("a");
        }
        for (int i = 0; i < 500000; i++) {
            bw.write("b");
        }
        bw.close();
    }
}
