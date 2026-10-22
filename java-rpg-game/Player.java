public class Player extends Character {

    private int level;

    public Player(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
        level = 1;
    }

    // HP回復
    public void heal() {
        int healAmount = 50;
        int beforeHp = hp;

        hp += healAmount;

        if (hp > maxHp) {
            hp = maxHp;
        }

        GameText.println(name + "はHPを"
                + (hp - beforeHp) + "回復した！");
        GameText.println("現在のHP: " + hp + "/" + maxHp);
    }

    // レベルアップ
    public void levelUp() {
        level++;
        attackPower += 10;
        maxHp += 10;

        GameText.pause(GameText.LONG_WAIT);
        GameText.println("");
        GameText.println("★ レベルアップ！ ★");
        GameText.println("レベルが" + level + "になった！");
        GameText.println("最大HPが10上がった！");
        GameText.println("攻撃力が10上がった！");
        GameText.println("現在のHPは" + hp + "/" + maxHp + "です。");
        GameText.pause(GameText.LONG_WAIT);
    }

    @Override
    public void showStatus() {
        GameText.println(name
                + " Lv." + level
                + " HP: " + hp + "/" + maxHp
                + " 攻撃力: " + attackPower);
    }
}