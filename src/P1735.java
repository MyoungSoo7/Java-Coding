import java.io.*;

public class P1735 {
    static class Fraction {
        int p, q;

        Fraction(int p, int q) {
            this.p = p;
            this.q = q;
        }

        int gcd(int a, int b) {
            while (a % b != 0) {
                int remain = a % b;
                a = b;
                b = remain;
            }
            return b;
        }

        void add(Fraction f) {
            int lcm = this.q * f.q / gcd(this.q, f.q);
            this.p = (lcm / this.q) * this.p + (lcm / f.q) * f.p;
            this.q = lcm;
            reduce();
        }

        void reduce() {
            int gcd = gcd(p, q);
            p /= gcd;
            q /= gcd;
        }

        @Override
        public String toString() {
            return p + " " + q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A1 = Integer.parseInt(input[0]), B1 = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int A2 = Integer.parseInt(input[0]), B2 = Integer.parseInt(input[1]);

        Fraction f1 = new Fraction(A1, B1);
        Fraction f2 = new Fraction(A2, B2);
        f1.add(f2);
        System.out.println(f1);
    }
}

