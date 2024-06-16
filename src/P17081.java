import java.io.*;
import java.util.*;

public class P17081 {
}

class GridCell {
    boolean passable;
    char display;

    GridCell (boolean passable, char display) {
        this.passable = passable;
        this.display = display;
    }
}

class Empty extends GridCell {
    Empty() {
        super(true, '.');
    }
}

class Wall extends GridCell {
    Wall() {
        super(false, '#');
    }
}

enum Item {
    W,
    A,
    HR,
    RE,
    CO,
    EX,
    DX,
    HU,
    CU,
}

class ItemBox extends GridCell {
    Item contain;

    ItemBox() {
        super(true, 'B');
    }

    void setContain(Item item) {
        this.contain = item;
    }
}

class SpikeTrap extends GridCell {
    final int DAMAGE = 5;

    SpikeTrap() {
        super(true, '^');
    }
}

class Monster extends GridCell {
    String name;
    int atk, def, hp, exp;
    boolean isBoss;

    Monster(boolean isBoss) {
        super(true, isBoss ? 'M' : '&');
        this.isBoss = isBoss;
    }

    void setStat(String name, int atk, int def, int hp, int exp) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.exp = exp;
    }
}

class Player extends GridCell {
    int maxHp = 20, hp = 20, atk = 2, def = 2, exp = 0, level = 1;
    int accCapacity = 4;
    Map<Item, Integer> stat = new HashMap<>();
    int[] startPos;

    Player(int sr, int sc) {
        super(true, '@');
        stat.put(Item.W, 0);
        stat.put(Item.A, 0);
        stat.put(Item.HR, 0);
        stat.put(Item.RE, 0);
        stat.put(Item.CO, 0);
        stat.put(Item.EX, 0);
        stat.put(Item.DX, 0);
        stat.put(Item.HU, 0);
        stat.put(Item.CU, 0);

        startPos = new int[]{sr, sc};
    }

    void gainExp(int gained) {
        exp += gained;

        if (exp >= level * 5) {
            level++;
            maxHp += 5;
            atk += 2;
            def += 2;
            hp = maxHp;
            exp = 0;
        }
    }

    boolean battle(Monster monster) {
        return true;
    }
}

