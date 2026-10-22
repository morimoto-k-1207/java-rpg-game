import java.util.Random;

public class Character {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attackPower;

    private static final Random random = new Random();

    public Character(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
    }

    // 通常攻撃
    public void attack(Character target) {
        int damage = calculateDamage(attackPower);

        GameText.println(name + "の攻撃！");
        target.takeDamage(damage);
    }

    // 攻撃力から、-5～+5の補正を加える
    protected int calculateDamage(int basePower) {
        int variation = random.nextInt(11) - 5;
        return basePower + variation;
    }

    // 40%の確率など、確率判定に利用
    protected boolean chance(int percent) {
        return random.nextInt(100) < percent;
    }

    // ダメージを受ける
    public void takeDamage(int damage) {
        hp -= damage;

        if (hp < 0) {
            hp = 0;
        }

        GameText.println(name + "は"
                + damage + "のダメージを受けた！");
    }

    // 生存判定
    public boolean isAlive() {
        return hp > 0;
    }

    // ステータス表示
    public void showStatus() {
        GameText.println(name + " HP: "
                + hp + "/" + maxHp
                + " 攻撃力: " + attackPower);
    }
}