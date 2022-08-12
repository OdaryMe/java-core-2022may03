package ru.geekbrains.java1.Homeworks.tic_tac_toe;

import ru.geekbrains.java1.Homeworks.catch_the_drop.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    private static final Random RANDOM = new Random();
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static Image gameOver;
    private static Image picX;
    private static Image picO;

    private int stateGameOver;
    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;

    private int scoreHuman;
    private int scoreAI;

   public GameMap() {
       isInitialized = false;
       addMouseListener(new MouseAdapter() {
           @Override
           public void mouseReleased(MouseEvent e) {
               super.mouseReleased(e);
               update(e);
           }
       });
   }
    private void update(MouseEvent e) {
       if(isGameOver || !isInitialized) return;
       int dot = gameMode == MODE_VS_AI ? DOT_HUMAN : playerNumTurn == 1 ? DOT_HUMAN : DOT_AI;
       if(!playerTurn(e, dot)) return;
       if(gameCheck(dot, STATE_WIN_HUMAN)) return;
       if(gameMode == MODE_VS_AI) {
           aiTurn();
           repaint();
           if(gameCheck(DOT_AI, STATE_WIN_AI)) return;
       }
    }

    private boolean playerTurn(MouseEvent e, int dot) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) return false;
        field[cellY][cellX] = dot;
        repaint();
        playerNumTurn = playerNumTurn == 1 ? 2 : 1;
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            render(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void render(Graphics g) throws IOException {
       picX = ImageIO.read(Objects.requireNonNull(GameMap.class.getResourceAsStream("/images/x.png")));
       picO = ImageIO.read(Objects.requireNonNull(GameMap.class.getResourceAsStream("/images/o.png")));

       if(!isInitialized) return;
       int width = getWidth();
       int height = getHeight();
       cellHeight = height / fieldSizeY;
       cellWidth = width / fieldSizeX;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(y, x)) continue;
                if(field[y][x] == DOT_HUMAN) {
                    g.drawImage(picX, x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2, null);
                }else if(field[y][x] == DOT_AI) {
                    g.drawImage(picO, x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth- DOT_PADDING * 2, cellHeight - DOT_PADDING * 2, null);
                }
            }
        }
        if (isGameOver) {
            showGameOverMessage(g);
        }
    }

    private void showGameOverMessage(Graphics g) throws IOException {
        gameOver = ImageIO.read(Objects.requireNonNull(GameMap.class.getResourceAsStream("/images/gameOver.png")));
        g.drawImage(gameOver, 0, 0, null);
        verdict(g);
    }

    private void verdict(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        String s;
        //int txtWidth = g.getFontMetrics().stringWidth(s);
        FontMetrics metrics = g.getFontMetrics();

        switch (stateGameOver) {
            case STATE_DRAW: s = "DRAW!!!"; break;
            case STATE_WIN_HUMAN: s = "Human Wins!"; break;
            case STATE_WIN_AI: s = "AI Wins!"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + stateGameOver);
        }
        int txtWidth = metrics.stringWidth(s);
        g.drawString(s, (getWidth() - txtWidth) / 2, getHeight() / 2 + 25);
    }

    private boolean gameCheck (int dot, int stateGameOver) {

        if (checkWin(dot, winLength)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (checkDraw()) {
            this.stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    private boolean scanField (int dot, int length) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(i, j)){
                    field[i][j] = dot; //поставим фишку в каждую клетку
                    if (checkWin(dot, length)) {
                        if(dot == DOT_AI) return true; //если комп выигрывает, оставляем фишку на этом месте
                        if (dot == DOT_HUMAN) {
                            field[i][j] = DOT_AI; //если так выиграет игрок, комп сам ставит сюда фишку
                            return true;
                        }
                    }
                    field[i][j] = DOT_EMPTY; //если выигрыш никому не светит, возвращаем назад пустую ячейку
                }
            }
        }
        return false;
    }
    private boolean checkWin(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, length, dot)) return true;
                if (checkLine(x, y, 1, 1, length, dot)) return true;
                if (checkLine(x, y, 0, 1, length, dot)) return true;
                if (checkLine(x, y, 1, -1, length, dot)) return true;
            }
        }
        return false;
    }
    private boolean checkLine(int x, int y, int incrementX, int incrementY, int len, int dot) {
        final int endXLine = x + (len - 1) * incrementX; //конец линии по Х
        final int endYLine = y + (len - 1) * incrementY; //конец линии по Y
        if(!isCellValid(endYLine, endXLine)) return false; //выход линии за пределы
        for (int i = 0; i < len; i++) {
            if (field[y + i * incrementY][x + i * incrementX] != dot) return false;
        }
        return true;
    }

    private void aiTurn() {
        if (scanField(DOT_AI, winLength)) return; //проверка выигрыша компа
        if (scanField(DOT_HUMAN, winLength)) return; //проверка выигрыша игрока (на следующем ходу)
        if (scanField(DOT_AI, winLength - 1)) return;;
        if (scanField(DOT_HUMAN, winLength - 1)) return;
        if (scanField(DOT_AI, winLength - 2)) return;;
        if (scanField(DOT_HUMAN, winLength - 2)) return;
        aiTurnEasy();

    }
    private void aiTurnEasy() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isCellEmpty(y, x));
        field[y][x] = DOT_AI;
    }

    private boolean isCellValid (int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }
    private boolean isCellEmpty (int y, int x){
        return field[y][x] == DOT_EMPTY;
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        this.fieldSizeX = this.fieldSizeY = fieldSize;
        this.winLength = winLength;
        this.playerNumTurn = 1;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        isGameOver = false;
        repaint();
    }
}
