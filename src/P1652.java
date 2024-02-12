import java.io.*;
import java.util.*;

public class P1652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] room = new String[N];

        for (int i = 0; i < N; i++) {
            room[i] = br.readLine();
        }

        StringBuilder[] sb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            sb[i] = new StringBuilder(room[i]);
        }

        int horizontal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (sb[i].substring(j, j + 2).equals("..")) {
                    horizontal++;
                    for (int k = j + 2; k < N; k++) {
                        if (sb[i].charAt(k) == 'X') {
                            break;
                        } else {
                            sb[i].setCharAt(k, 'X');
                        }
                    }
                }
            }
        }

        sb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            sb[i] = new StringBuilder(room[i]);
        }

        int vertical = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (sb[j].charAt(i) == '.' && sb[j + 1].charAt(i) == '.') {
                    vertical++;
                    for (int k = j + 2; k < N; k++) {
                        if (sb[k].charAt(i) == 'X') {
                            break;
                        } else {
                            sb[k].setCharAt(i, 'X');
                        }
                    }
                }
            }
        }

        System.out.println(horizontal + " " +  vertical);
    }
}
