public class BossMonster extends Monster {

    public BossMonster(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(Character target) {

        // 30%の確率で必殺技
        if (chance(30)) {

            GameText.pause(GameText.LONG_WAIT);
            GameText.println("魔王：「滅びろ…」");

            GameText.pause(GameText.LONG_WAIT);
            GameText.println("");
            GameText.println("★ Breath of Perish ★");
            GameText.println("魔王はBreath of Perishを放った！");

            // 攻撃力2倍を基準に計算
            int damage = calculateDamage(attackPower * 2);

            GameText.pause(GameText.SHORT_WAIT);
            target.takeDamage(damage);

            GameText.pause(GameText.LONG_WAIT);

        } else {

            // 必殺技が出なければ通常攻撃
            super.attack(target);
        }
    }
}