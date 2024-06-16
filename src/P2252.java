import java.io.*;
import java.util.*;

public class P2252 {
    static class Student {
        List<Student> next;
        int nextCount;
        int num;

        Student(int num) {
            next = new ArrayList<>();
            nextCount = 0;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            students[i] = new Student(i + 1);
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            students[A - 1].next.add(students[B - 1]);
            students[B - 1].nextCount++;
        }

        Queue<Student> queue = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            if (students[n].nextCount == 0) {
                queue.offer(students[n]);
            }
        }

        for (int n = 0; n < N; n++) {
            Student student = queue.poll();
            System.out.print(student.num + " ");

            for (Student s : student.next) {
                s.nextCount--;
                if (s.nextCount == 0) {
                    queue.offer(s);
                }
            }
        }
    }
}
