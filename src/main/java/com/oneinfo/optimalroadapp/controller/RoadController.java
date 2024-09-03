package com.oneinfo.optimalroadapp.controller;

import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.service.RoadService;
import com.oneinfo.optimalroadapp.utils.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roads")
public class RoadController {

    private final RoadService roadService;

    public RoadController(RoadService roadService) {
        this.roadService = roadService;
    }

    @PutMapping("/{roadId}")
    public ResponseEntity<?> addRoad(@PathVariable Long roadId, @RequestBody Road road) {
        roadService.addRoad(roadId, road.getCost(), road.getSourceId(), road.getDestinationId());
        return ResponseEntity.ok().body(new StatusResponse("ok"));
    }
}