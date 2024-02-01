import java.io.*;
import java.util.*;

class Cell {
    char getIcon() {
        return '.';
    }
}

class Wall extends Cell {
    @Override
    public char getIcon() {
        return '#';
    }
}

class Item extends Cell {
    @Override
    public char getIcon() {
        return 'B';
    }
}

class Weapon extends Item {

}

class Armor extends Item {

}

class Acc extends Item {

}

class Trap extends Cell {
    @Override
    char getIcon() {
        return '^';
    }
}

class Entity extends Cell {
    int hp, maxHp;
    int atk;
    int def;
    int exp;

    Entity(int hp, int maxHp, int atk, int def, int exp) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.atk = atk;
        this.exp = exp;
    }
}

class Monster extends Entity {
    String name;

    Monster(int hp, int maxHp, int atk, int def, int exp, String name) {
        super(hp, maxHp, atk, def, exp);
        this.name = name;
    }

    @Override
    char getIcon() {
        return '&';
    }
}

class Boss extends Monster {
    Boss(int hp, int maxHp, int atk, int def, int exp, String name) {
        super(hp, maxHp, atk, def, exp, name);
    }

    @Override
    char getIcon() {
        return 'M';
    }
}

class Player extends Entity {
    int level = 1;
    int nextExp = 5;
    Weapon weapon = new Weapon();
    Armor armor = new Armor();
    Acc[] acc = new Acc[4];

    Player(int hp, int maxHp, int atk, int def, int exp) {
        super(hp, maxHp, atk, def, exp);
    }

    @Override
    char getIcon() {
        return '@';
    }
}

class Game {
    private Cell[][] map;
    private int turn = 0;
    private int playerX;
    private int playerY;

    Game(int x, int y) {
        map = new Cell[x][y];
    }

    Cell[][] getCells() {
        return map;
    }

    Cell getCell(int x, int y) {
        return map[x][y];
    }

    void setPlayerPos(int x, int y) {

    }

    void movePlayer(int x, int y) {

    }
}

public class P17081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[0]);
        Game game = new Game(N, M);
        Cell[][] cell = game.getCells();
        for (int i = 0; i < N; i++) {
            String map = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (map.charAt(j)) {
                    case '.':
                        cell[i][j] = new Cell();
                        break;
                    case '#':
                        cell[i][j] = new Wall();
                        break;
                    case '@':
                        break;
                    case '&':
                        break;
                    case 'M':
                        break;
                    case 'B':
                        break;
                    case '^':
                        break;

                }
            }
        }
    }
}