package com.oneinfo.optimalroadapp.controller;

import com.oneinfo.optimalroadapp.entity.Station;
import com.oneinfo.optimalroadapp.service.StationService;
import com.oneinfo.optimalroadapp.utils.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PutMapping("/{stationId}")
    public ResponseEntity<?> addStation(@PathVariable Long stationId, @RequestBody Station station) {
        stationService.addStation(stationId, station.getName());
        return ResponseEntity.ok().body(new StatusResponse("ok"));
    }
}