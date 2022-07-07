package ru.geekbrains.java1.Homeworks;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4_TicTacToe {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static char[][] field;
    private static final int FIELD_SIZE_X = 3;
    private static final int FIELD_SIZE_Y = 3;

    private static String playerOneName = "";
    private static int scoreHuman = 0;
    private static int scoreAI = 0;



    public static void main(String[] args) {
        System.out.print("Представьтесь пожалуйста >>> ");
        playerOneName = SCANNER.nextLine();
        playRound();

    }

    private static void playRound() {
        do {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, String.format("Ай, маладца, %s! Победа!", playerOneName))) break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, String.format("%s, вы проиграли! Примите наши соболезнования...", playerOneName)))
                    break;
            }
            System.out.printf("SCORE IS:\n%s: %d || AI: %d\n", playerOneName, scoreHuman, scoreAI);
            System.out.println("Еще раунд? >>> Y or N >>");
        } while (SCANNER.next().toLowerCase().equals("y"));
        System.out.println("GAME OVER");
    }


    private static boolean gameCheck(char dot, String s) {
        if (checkWin(dot)) {
            if (dot == DOT_HUMAN) {
                scoreHuman++;
            } else {
                scoreAI++;
            }
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("DRAW!!!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char dot) {
        //понимаю, что можно ввести переменную, котора будет увеличиваться при каждом непустом значении ячейки,
        // но ни один код, который я таким образом написала, не срабатывает.
        // Ну, например:
//        private static boolean checkHorizontal(char dot) {
//            int i = 0;
//            int lineHorizontal = 0;
//            for (int j = 0; j < FIELD_SIZE_Y; j++) {
//                if (field[j][i + lineHorizontal] == dot)
//                    lineHorizontal++;
//                else lineHorizontal = 0;
//            }
//            return lineHorizontal == WIN_LINE;
//        }
        // То есть хочу сказать, что с точки зрения алгоритма я этот вопрос условно решила, а вот синтаксис не догоняю.
        // Поэтому вот только такая хрень:

        int i = 0;
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            if ((field[y][i] == dot && field[y][i + 1] == dot && field[y][i + 2] == dot)) return true;
        }
        int j = 0;
        for (int x = 0; x < FIELD_SIZE_X; x++) {
            if ((field[j][x] == dot && field[j + 1][x] == dot && field[j + 2][x] == dot)) return true;
        }

        if (field[j][i] == dot && field[j + 1][i + 1] == dot && field[j + 2][i + 2] == dot) return true;
        if (field[j][i + 2] == dot && field[j + 1][i + 1] == dot && field[j + 2][i] == dot) return true;

        return false;
    }


    private static boolean checkDraw() {
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            for (int x = 0; x < FIELD_SIZE_X; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.printf("введите координаты х и у через пробел >>>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(FIELD_SIZE_X);
            y = RANDOM.nextInt(FIELD_SIZE_Y);
        } while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < FIELD_SIZE_X && y < FIELD_SIZE_Y;
    }

    private static boolean isCellEmpty(int x, int y) {return field[y][x] == DOT_EMPTY;
    }

    private static void initField() {
        field = new char[FIELD_SIZE_Y][FIELD_SIZE_X];
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            for (int x = 0; x < FIELD_SIZE_X; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("TTT");
        for (int i = 0; i < FIELD_SIZE_X * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            System.out.print(" " + (i + 1) + " |");
            for (int j = 0; j < FIELD_SIZE_X; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= FIELD_SIZE_X * 2 + 4; i++)
            System.out.print("-");
        System.out.println();
    }

}
