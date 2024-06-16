import java.util.*;

public class P10947 {
    public static void main(String[] args) {
        Set<Integer> lotto = new TreeSet<>();
        while (lotto.size() != 6) {
            int num = (int) (Math.random() * 45 + 1);
            lotto.add(num);
        }

        for (int i : lotto) {
            System.out.print(i + " ");
        }
    }
}
