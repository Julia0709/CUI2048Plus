import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

class GameManager {
    private final static String[] MODE = {"EASY", "NORMAL", "HARD", "EXPERT"};

    void gameManager() {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Select a mode: \n" +
//                "1 --- " + MODE[0] + " \n" +
//                "2 --- " + MODE[1] + " \n" +
//                "3 --- " + MODE[2] + " \n" +
//                "4 --- " + MODE[3]
//        );

        // TODO Change to 0
        int goal = 512;
//        while (goal <= 0) {
//            goal = selectMode(scan.nextInt());
//        }

        int score = 0;
        System.out.println("Score: " + score);

        GameLogic logic = new GameLogic();
        logic.playGame(goal, score);
    }

    private int selectMode(int n) {
        String mode = MODE[n - 1];
        int goal;
        switch (n) {
            case 1:
                goal = 512;
                break;
            case 2:
                goal = 2048;
                break;
            case 3:
                goal = 4092;
                break;
            case 4:
                goal = 8192;
                break;
            default:
                System.out.println("Please type 1, 2, 3 or 4: ");
                return -1;
        }
        System.out.println(mode + " MODE: GAME START!");
        return goal;
    }
}
