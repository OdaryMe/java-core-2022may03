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
    private static int FIELD_SIZE_X ;
    private static int FIELD_SIZE_Y;
    private static int winLength;

    private static String playerOneName = "";
    private static int scoreHuman = 0;
    private static int scoreAI = 0;



    public static void main(String[] args) {
        System.out.print("Представьтесь, пожалуйста >>> ");
        playerOneName = SCANNER.nextLine();
        System.out.println("Введите размеры поля X и Y (от 3-х и более) и длину выигрышной линии.\nЧерез пробел>>>");
        int sizeX = SCANNER.nextInt();
        int sizeY = SCANNER.nextInt();
        int len = SCANNER.nextInt();
        playRound(sizeX, sizeY, len);
    }

    private static void playRound(int sizeX, int sizeY, int len) {
        do {
            initField(sizeX, sizeY, len);
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
        if (checkWin(dot, winLength)) {
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

    private static boolean scanField(char dot, int length) {
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                if (isCellEmpty(i, j)) {
                    field[i][j] = dot;
                    if(checkWin(dot, length)){
                        if (dot == DOT_AI) return true;
                        if (dot == DOT_HUMAN) {
                            field[i][j] = DOT_AI;
                            return true;
                        }
                     }
                     field[i][j] = DOT_EMPTY;
                }
            }
        }return false;
    }

        private static boolean checkWin(char dot, int length) {
        for (int y = 0; y < FIELD_SIZE_Y; y++){
            for (int x = 0; x < FIELD_SIZE_X; x++){
                if(checkLine(x, y, 1, 0, length, dot)) return true;
                if(checkLine(x, y, 1, 1, length, dot)) return true;
                if(checkLine(x, y, 0, 1, length, dot)) return true;
                if(checkLine(x, y, 1, -1, length, dot)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int x, int y, int incrementX, int incrementY, int len, char dot) {
        final int endXLine = x + (len - 1) * incrementX;
        final int endYLine = y + (len - 1) * incrementY;
        if(!isCellValid(endYLine, endXLine)) return false; //Делала наоборот, потом поменяла, как у Саши...
            for (int i = 0; i < len; i++) {
                if(field[y + i * incrementY][x + i * incrementX] != dot) return false;
        }return true;
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
            System.out.print("введите координаты х и у через пробел >>>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn(){
        if(scanField(DOT_AI, winLength)) return;
        if(scanField(DOT_HUMAN, winLength)) return;
        if(scanField(DOT_AI, winLength - 1)) return;
        if(scanField(DOT_HUMAN, winLength - 1)) return;
        if(scanField(DOT_AI, winLength - 2)) return;
        if(scanField(DOT_HUMAN, winLength - 2)) return;
        aiTurnEasy();
    }

    private static void aiTurnEasy() {
        int x, y;
        do {
            x = RANDOM.nextInt(FIELD_SIZE_X);
            y = RANDOM.nextInt(FIELD_SIZE_Y);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean isCellValid(int x, int y) {return x >= 0 && y >= 0 && x < FIELD_SIZE_X && y < FIELD_SIZE_Y;}
    private static boolean isCellEmpty(int x, int y) {return field[y][x] == DOT_EMPTY;}
    private static void initField(int sizeX, int sizeY, int len) {
        FIELD_SIZE_X = sizeX;
        FIELD_SIZE_Y = sizeY;
        winLength = len;
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
