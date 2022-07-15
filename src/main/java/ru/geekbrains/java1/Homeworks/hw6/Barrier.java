package ru.geekbrains.java1.Homeworks.hw6;

public class Barrier {
    public String getKind() {
        return kind;
    }

    private String kind;

    public int getMeter() {
        return meter;
    }

    private int meter;

    public Barrier(String kind, int meter) {
        this.kind = kind;
        this.meter = meter;
    }
}
