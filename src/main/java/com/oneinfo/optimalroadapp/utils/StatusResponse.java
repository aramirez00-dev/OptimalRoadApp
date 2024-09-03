package com.oneinfo.optimalroadapp.utils;

public class StatusResponse {

    // clase personalizada de response
    private String status;

    public StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
