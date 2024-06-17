import java.io.*;
import java.util.*;

public class P9091 {
    static class DSLR {
        int num;
        String operations;

        public DSLR(int num, String operations) {
            this.num = num;
            this.operations = operations;
        }

        List<DSLR> operating(boolean[] visit) {
            List<DSLR> result = new ArrayList<>();

            int temp = (this.num * 2) % 10000;
            if (!visit[temp]) {

                result.add(new DSLR(temp, this.operations + "D"));
                visit[temp] = true;
            }

            temp = this.num == 0 ? 9999 : this.num - 1;
            if (!visit[temp]) {
                result.add(new DSLR(temp, this.operations + "S"));
                visit[temp] = true;
            }

            temp = num * 10;
            temp = temp % 10000 + temp / 10000;
            if (!visit[temp]) {
                result.add(new DSLR(temp, this.operations + "L"));
                visit[temp] = true;
            }

            int first = num % 10;
            temp = num / 10 + first * 1000;
            if (!visit[temp]) {
                result.add(new DSLR(temp, this.operations + "R"));
                visit[temp] = true;
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Queue<DSLR> queue = new LinkedList<>();
            boolean[] visit = new boolean[10000];
            queue.offer(new DSLR(A, ""));
            visit[A] = true;
            while (!queue.isEmpty()) {
                DSLR dslr = queue.poll();
                if (dslr.num == B) {
                    System.out.println(dslr.operations);
                    break;
                }
                List<DSLR> list = dslr.operating(visit);
                for (DSLR d : list) {
                    queue.offer(d);
                }
            }
        }
    }
}
