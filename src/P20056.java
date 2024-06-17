import java.io.*;
import java.util.*;

public class P20056 {
    static class Fireball {
        int mass;
        int speed;
        int direction;

        public Fireball(int mass, int speed, int direction) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }

    static class Grid1 {
        final int[] DX = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        final int[] DY = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        Queue<Fireball>[][] grid;

        int size;

        Grid1(int N) {
            this.grid = new LinkedList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = new LinkedList<>();
                }
            }
            this.size = N;
        }

        void addFireball(int x, int y, Fireball fireball) {
            grid[x][y].add(fireball);
        }

        void move() {
            int[][] sizeList = new int[this.size][this.size];
            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < this.size; y++) {
                    sizeList[x][y] = this.grid[x][y].size();
                }
            }

            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < this.size; y++) {
                    Queue<Fireball> cell = grid[x][y];
                    for (int i = 0; i < sizeList[x][y]; i++) {
                        Fireball fireball = cell.remove();
                        int direction = fireball.direction;
                        int speed = fireball.speed;
                        int dx = x + speed * DX[direction];
                        int dy = y + speed * DY[direction];
                        dx = adjustPos(dx);
                        dy = adjustPos(dy);
                        grid[dx][dy].add(fireball);
                    }
                }
            }

            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < this.size; y++) {
                    Queue<Fireball> cell = grid[x][y];
                    int size = cell.size();
                    if (size > 1) {
                        int sumMass = 0;
                        int sumSpeed = 0;
                        int countOddEven = 0;
                        for (int i = 0; i < size; i++) {
                            Fireball fireball = cell.remove();
                            sumMass += fireball.mass;
                            sumSpeed += fireball.speed;
                            if (fireball.direction % 2 == 0) {
                                countOddEven++;
                            } else {
                                countOddEven--;
                            }
                        }

                        if (sumMass / 5 > 0) {
                            int only = 0;
                            if (Math.abs(countOddEven) != size) {
                                only++;
                            }
                            for (int i = 0; i < 4; i++) {
                                cell.add(new Fireball(sumMass / 5, sumSpeed / size, i * 2 + only));
                            }
                        }
                    }
                }
            }
        }

        int adjustPos(int pos) {
            if (pos >= this.size) {
                int sub = pos / this.size;
                return pos - sub * this.size;
            } else if (pos < 0) {
                int add = (-pos + this.size - 1) / this.size;
                return pos + add * this.size;
            }
            return pos;
        }

        int getMassSum() {
            int result = 0;
            for (Queue<Fireball>[] queues : this.grid) {
                for (Queue<Fireball> queue : queues) {
                    for (Fireball fireball : queue) {
                        result += fireball.mass;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        Grid1 grid1 = new Grid1(Integer.parseInt(s[0]));
        for (int i = 0; i < Integer.parseInt(s[1]); i++) {
            String[] fireball = br.readLine().split(" ");
            int[] I = new int[5];
            for (int j = 0; j < 5; j++) {
                I[j] = Integer.parseInt(fireball[j]);
            }
            grid1.addFireball(I[0] - 1, I[1] - 1, new Fireball(I[2], I[3], I[4]));
        }
        for (int i = 0; i < Integer.parseInt(s[2]); i++) {
            grid1.move();
        }
        System.out.println(grid1.getMassSum());
    }
}
