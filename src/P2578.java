import java.io.*;


public class P2578 {
    static class Cell {
        int value;
        int checked = 0;

        Cell(int value) {
            this.value = value;
        }
    }

    static class Bingo {
        Cell[][] board = new Cell[5][5];

        void setChecked(int value) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Cell c = this.board[i][j];
                    if (c.value == value) {
                        c.checked++;
                        return;
                    }
                }
            }
        }

        int getBingo() {
            int horizontal = 0;
            for (int i = 0; i < 5; i++) {
                int row = 0;
                for (int j = 0; j < 5; j++) {
                    row += this.board[i][j].checked;
                }
                if (row == 5) {
                    horizontal++;
                }
            }

            int vertical = 0;
            for (int i = 0; i < 5; i++) {
                int column = 0;
                for (int j = 0; j < 5; j++) {
                    column += this.board[j][i].checked;
                }
                if (column == 5) {
                    vertical++;
                }
            }

            int diagonal = 0;
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 5; i++) {
                d1 += this.board[i][i].checked;
                d2 += this.board[4 - i][i].checked;
            }

            if (d1 == 5) {
                diagonal++;
            }
            if (d2 == 5) {
                diagonal++;
            }

            return horizontal + vertical + diagonal;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Bingo bingo = new Bingo();
        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo.board[i][j] = new Cell(Integer.parseInt(s[j]));
            }
        }

        int[][] moderator = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                moderator[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = 0;
        exit : for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo.setChecked(moderator[i][j]);
                if (bingo.getBingo() >= 3) {
                    result = i * 5 + j + 1;
                    break exit;
                }
            }
        }
        System.out.println(result);
    }
}
