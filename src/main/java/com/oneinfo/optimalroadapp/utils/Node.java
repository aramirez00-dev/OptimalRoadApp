package com.oneinfo.optimalroadapp.utils;

public class Node {
    // clase de nodo que asiste en el algoritmo para buscar mejor camino a destino
    Long stationId;
    double cost;

    public Node(Long stationId, double cost) {
        this.stationId = stationId;
        this.cost = cost;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}