import java.util.*;

public class PP12921 {
}

class Main1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(2));
    }
}

class Solution1 {
    public int solution(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        loop : for (int i = 3; i <= n; i += 2) {
            int sqrt = (int) Math.sqrt(i);
            for (int prime : primes) {
                if (sqrt < prime) {
                    primes.add(i);
                    continue loop;
                } else if (i % prime == 0) {
                    continue loop;
                }
            }
        }
        return primes.size();
    }
}