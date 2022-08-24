package ru.geekbrains.java2.homeworks.hw1;

import ru.geekbrains.java1.lesson7.ObstacleType;

public abstract class Obstacle {
    protected int overcomeParameter;
    protected final ObstacleType type;

    public Obstacle(int overcomeParameter, ObstacleType type) {
        this.overcomeParameter = overcomeParameter;
        this.type = type;
    }

    public int getOvercomeParameter() {
        return overcomeParameter;
    }

    public ObstacleType getType() {
        return type;
    }
}
