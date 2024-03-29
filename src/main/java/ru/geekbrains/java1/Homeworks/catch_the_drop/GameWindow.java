package ru.geekbrains.java1.Homeworks.catch_the_drop;

/*я могу внести исправления, которые подсказывает идея, но после этих исправлений работать не начинает
сейчас оставила так, как было в уроке*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static Image background;
    private static Image game_over;
    private static Image drop;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.pmg"));
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(906, 478);
        game_window.setResizable(false);
        GameField game_field = new GameField();
        game_window.add(game_field);
        game_window.setVisible(true);
    }
    private static void onRepaint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, 100, 100, null);
        g.drawImage(game_over, 280, 120, null);
    }

    private static class GameField extends JPanel {

        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
