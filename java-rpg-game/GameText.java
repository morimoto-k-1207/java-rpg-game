public class GameText {

    // 1文字ごとの表示速度
    private static final int CHAR_DELAY = 25;

    // メッセージ間の待ち時間
    public static final int SHORT_WAIT = 400;
    public static final int LONG_WAIT = 900;

    // 改行なしで表示
    public static void print(String message) {
        showSlowly(message);
    }

    // 表示したあとに改行
    public static void println(String message) {
        showSlowly(message);
        System.out.println();
    }

    // 空行を表示
    public static void blankLine() {
        System.out.println();
    }

    // 指定した時間待つ
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 1文字ずつ表示
    private static void showSlowly(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            System.out.flush();
            pause(CHAR_DELAY);
        }
    }
}