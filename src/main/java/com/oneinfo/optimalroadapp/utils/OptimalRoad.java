package com.oneinfo.optimalroadapp.utils;

import java.util.List;

public class OptimalRoad {
    // clase base para la obtencion del camino óptimo al destino

    private List<Long> path;
    private double cost;

    public OptimalRoad(List<Long> path, double cost) {
        this.path = path;
        this.cost = cost;
    }

    public List<Long> getPath() {
        return path;
    }

    public double getCost() {
        return cost;
    }
}
