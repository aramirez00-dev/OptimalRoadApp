package com.oneinfo.optimalroadapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Road {

    private Long id;
    private double cost;

    // les indico el nombre de la jsonProperty para respetar camel case desde mi código
    @JsonProperty("source_id")
    private Long sourceId;
    @JsonProperty("destination_id")
    private Long destinationId;

    public Road(Long id, double cost, Long sourceId, Long destinationId) {
        this.id = id;
        this.cost = cost;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
}