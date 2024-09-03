package com.oneinfo.optimalroadapp.service;

import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.repository.RoadRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class RoadService {

    private static final Logger logger = Logger.getLogger(RoadService.class.getName());

    private final RoadRepository roadRepository;

    public RoadService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    public void addRoad(Long id, double cost, Long sourceId, Long destinationId) {

        Road road = new Road(id, cost, sourceId, destinationId);
        roadRepository.save(road);
        showRoads(roadRepository.findAll());
    }

    // muestro en log los roads hasta ahora
    public void showRoads(Map<Long, Road> roads) {
        for (Map.Entry<Long, Road> entry : roads.entrySet()) {
            Long key = entry.getKey();
            Road value = entry.getValue();
            logger.info("RoadID: " + key + ", SourceID: " + value.getSourceId()
                    + ", DestinationID: " + value.getDestinationId() + ", Cost: " + value.getCost());
        }
    }
}