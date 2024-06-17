import java.io.*;
import java.util.*;

public class P1296 {
    static class Team {
        int L = 0, O = 0, V = 0, E = 0;

        public Team(String name) {
            for (char c : name.toCharArray()) {
                switch (c) {
                    case 'L':
                        L++;
                        break;
                    case 'O':
                        O++;
                        break;
                    case 'V':
                        V++;
                        break;
                    case 'E':
                        E++;
                }
            }
        }

        public int getWinRate(String team) {
            int l = L, o = O, v = V, e = E;
            for (char c : team.toCharArray()) {
                switch (c) {
                    case 'L':
                        l++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case 'V':
                        v++;
                        break;
                    case 'E':
                        e++;
                }
            }
            return ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Team team = new Team(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        String[] teams = new String[N];
        for (int n = 0; n < N; n++) {
            teams[n] = br.readLine();
        }
        Arrays.sort(teams);

        int max = -1;
        String answer = null;
        for (String s : teams) {
            int winRate = team.getWinRate(s);
            if (winRate > max) {
                answer = s;
                max = winRate;
            }
        }
        System.out.println(answer);
    }
}
