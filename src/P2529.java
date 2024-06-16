import java.io.*;
import java.util.*;

public class P2529 {
    static void getNum(List<List<Integer>> result, List<Integer> temp, boolean[] visit, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp.add(i);
            getNum(result, temp, visit, k);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] sign = br.readLine().split(" ");

        List<List<Integer>> numList = new ArrayList<>();
        getNum(numList, new ArrayList<>(), new boolean[10], k + 1);
        List<List<Integer>> validList = new ArrayList<>();
        for (List<Integer> num : numList) {
            boolean isValid = true;
            for (int i = 0; i < k; i++) {
                if (sign[i].equals("<") ) {
                    if (num.get(i) > num.get(i + 1)) {
                        isValid = false;
                        break;
                    }
                } else {
                    if (num.get(i) < num.get(i + 1)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                validList.add(num);
            }
        }

        for (int i : validList.get(validList.size() - 1)) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : validList.get(0)) {
            System.out.print(i);
        }

    }
}
