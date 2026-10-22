import java.util.Scanner;

public class Battle {

    private Player player;
    private Monster[] monsters;
    private Scanner scanner;

    public Battle(Player player, Monster[] monsters, Scanner scanner) {
        this.player = player;
        this.monsters = monsters;
        this.scanner = scanner;
    }

    // ゲーム開始
    public void start() {
        GameText.println("================================");
        GameText.println("      モンスター討伐ゲーム");
        GameText.println("================================");
        GameText.println("4体の敵を倒して魔王を討伐しよう！");
        GameText.pause(GameText.LONG_WAIT);

        for (Monster monster : monsters) {

            GameText.println("");
            GameText.println("================================");
            GameText.println(monster.name + "が現れた！");
            GameText.println("================================");

            GameText.pause(GameText.LONG_WAIT);

            fightMonster(monster);

            if (!player.isAlive()) {
                GameText.println("");
                GameText.println("勇者は力尽きた……");
                GameText.println("ゲームオーバー！");
                return;
            }

            GameText.println("");
            GameText.println(monster.name + "を倒した！");
            GameText.pause(GameText.LONG_WAIT);

            player.levelUp();
        }

        GameText.println("");
        GameText.println("================================");
        GameText.println("魔王を討伐した！");
        GameText.println("ゲームクリア！");
        GameText.println("================================");
    }

    // 1体のモンスターとの戦闘
    private void fightMonster(Monster monster) {

        while (player.isAlive() && monster.isAlive()) {

            GameText.println("");
            player.showStatus();
            monster.showStatus();

            GameText.println("");
            GameText.println("どうする？");
            GameText.println("1：攻撃");
            GameText.println("2：回復");
            GameText.print("番号を入力：");

            if (!scanner.hasNextInt()) {
                scanner.next();
                GameText.println("");
                GameText.println("1か2を入力してください。");
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 1) {

                player.attack(monster);

            } else if (choice == 2) {

                player.heal();

            } else {

                GameText.println("1か2を入力してください。");
                continue;
            }

            // モンスターが生きている場合反撃
            if (monster.isAlive()) {
                GameText.pause(GameText.SHORT_WAIT);
                monster.attack(player);
            }
        }
    }
}