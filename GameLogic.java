import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class GameLogic {
    private Scanner scan = new Scanner(System.in);

    void playGame(int goal, int score) {
        int n = 4;
        int[][] matrix = new int[n][n];

        generateNewNumber(matrix, n);

        String move;
        boolean isFinished = false;
        while (!isFinished) {

            isFinished = generateNewNumber(matrix, n);
            displayMatrix(matrix, n);

            System.out.println("i(↑)  j(←)  k(↓)  l(→) | p(Pose Game)");
            move = scan.nextLine().toLowerCase();
            switch (move) {
                case "i":
                    shiftUp();
                    break;
                case "j":
                    shiftLeft();
                    break;
                case "k":
                    shiftDown();
                    break;
                case "l":
                    shiftRight();
                    break;
                case "p":
                    isFinished = openMenu();
                    break;
                default:
                    System.out.println("Enter i, j, k or l.");
            }
        }

        System.out.println("GAME OVER");
    }

    private boolean openMenu() {
        System.out.println("Want to finish? Press 'y'.");
        String reply = scan.next();
        switch (reply) {
            case "y":
                return true;
            default:
                System.out.println("Continue");
                return false;
        }
    }

    private void shiftUp() {
        System.out.println("UP");
    }

    private void shiftLeft() {
        System.out.println("LEFT");
    }

    private void shiftDown() {
        System.out.println("DOWN");
    }

    private void shiftRight() {
        System.out.println("RIGHT");
    }


    private void displayMatrix(int[][] matrix, int n) {
//        System.out.println("+------------------------+");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("| " + matrix[i][j] + " ");
            }
            System.out.printf("|\n");
//            System.out.println("+------------------------+");
        }
    }

    private boolean generateNewNumber(int[][] matrix, int n) {
        ArrayList<Integer[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(matrix[i][j] > 0)) {
                    emptyCells.add(new Integer[]{i, j});
                }
            }
        }

        if (emptyCells.size() == 0) {
            return true;
        }

        Collections.shuffle(emptyCells);
        Integer[] t = emptyCells.get(0);
        matrix[t[0]][t[1]] = 2;
        return false;
    }
}
