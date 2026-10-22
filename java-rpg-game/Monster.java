public class Monster extends Character {

    public Monster(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(Character target) {
        int damage = calculateDamage(attackPower);

        GameText.println(name + "の反撃！");
        target.takeDamage(damage);
    }
}