package ru.geekbrains.java2.homeworks.hw1;

import ru.geekbrains.java1.lesson7.ObstacleType;

public class Wall extends Obstacle {
    public Wall (int overcomeParameter) {
        super(overcomeParameter, ObstacleType.WALL);
    }
}
