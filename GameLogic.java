import java.util.ArrayList;
import java.util.Collections;

class GameLogic {
    void playGame(int goal, int score) {
        int n = 4;
        int[][] matrix = new int[n][n];

        genarateNewNumber(matrix, n);
        genarateNewNumber(matrix, n);

        displayMatrix(matrix, n);
    }

    private void displayMatrix(int[][] matrix, int n) {
        System.out.println("+------------------------+");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("| " + matrix[i][j] + " ");
            }
            System.out.printf("|\n");
        }
        System.out.println("+------------------------+");
    }

    private void genarateNewNumber(int[][] matrix, int n) {
        ArrayList<Integer[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(matrix[i][j] > 0)) {
                    emptyCells.add(new Integer[]{i, j});
                }
            }
        }
        Collections.shuffle(emptyCells);
        Integer[] t = emptyCells.get(0);
        matrix[t[0]][t[1]] = 2;
    }
}
