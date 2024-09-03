package com.oneinfo.optimalroadapp.controller;

import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.service.OptimalRoadService;
import com.oneinfo.optimalroadapp.service.RoadService;
import com.oneinfo.optimalroadapp.utils.OptimalRoad;
import com.oneinfo.optimalroadapp.utils.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roads")
public class RoadController {

    private final OptimalRoadService optimalRoadService;
    private final RoadService roadService;

    public RoadController(RoadService roadService, OptimalRoadService optimalRoadService) {
        this.roadService = roadService;
        this.optimalRoadService = optimalRoadService;
    }

    @PutMapping("/{roadId}")
    public ResponseEntity<?> addRoad(@PathVariable Long roadId, @RequestBody Road road) {
        roadService.addRoad(roadId, road.getCost(), road.getSourceId(), road.getDestinationId());
        return ResponseEntity.ok().body(new StatusResponse("ok"));
    }

    @GetMapping("/{sourceId}/{destinationId}")
    public ResponseEntity<?> getOptimalRoute(@PathVariable Long sourceId, @PathVariable Long destinationId) {
        OptimalRoad optimalRoute = optimalRoadService.findOptimalRoad(sourceId, destinationId);
        return ResponseEntity.ok(optimalRoute);
    }
}