import java.io.*;
import java.util.*;

public class P9205 {
    static class Person {
        int[] pos;
        int beer;

        public Person(int[] pos) {
            this.pos = pos;
            this.beer = 20;
        }

        Person moveTo(int[] destination) {
            int distance = Math.abs(pos[0] - destination[0]) + Math.abs(pos[1] - destination[1]);
            if (beer * 50 < distance) {
                return null;
            }
            return new Person(destination);
        }
    }

    static String go(int[] house, int[][] stores, int[] destination) {
        int len = stores.length;
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(house));
        boolean[] visit = new boolean[len];
        while (!queue.isEmpty()) {
            Person temp = queue.poll();
            if (temp.moveTo(destination) != null) {
                return "happy";
            }

            for (int i = 0; i < len; i++) {
                if (!visit[i]) {
                    Person move = temp.moveTo(stores[i]);
                    if (move != null) {
                        queue.add(move);
                        visit[i] = true;
                    }
                }
            }
        }
        return "sad";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] house = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[][] stores = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                stores[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            st = new StringTokenizer(br.readLine());
            int[] destination = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            System.out.println(go(house, stores, destination));
        }
    }
}
