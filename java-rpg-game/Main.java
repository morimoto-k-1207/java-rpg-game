import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // プレイヤーを作成
        Player player = new Player("勇者", 100, 20);

        // モンスターを順番に作成
        Monster[] monsters = {
            new Monster("スライム", 50, 17),
            new Monster("ゴブリン", 90, 24),
            new Monster("ドラゴン", 150, 30),
            new BossMonster("魔王", 250, 37)
        };

        // ゲームを開始
        Battle battle = new Battle(player, monsters, scanner);
        battle.start();

        scanner.close();
    }
}