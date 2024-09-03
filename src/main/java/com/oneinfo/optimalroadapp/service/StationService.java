package com.oneinfo.optimalroadapp.service;

import com.oneinfo.optimalroadapp.entity.Station;
import com.oneinfo.optimalroadapp.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class StationService {

    private static final Logger logger = Logger.getLogger(StationService.class.getName());
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addStation(Long id, String name) {
        Station station = new Station(id, name);
        stationRepository.save(station);
        showStations(stationRepository.findAll());
    }

    // muestro en log las stations hasta ahora
    public void showStations(Map<Long, Station> stations){
        for (Map.Entry<Long, Station> entry : stations.entrySet()) {
            Long key = entry.getKey();
            Station value = entry.getValue();
            logger.info("StationID: " + key + ", Name: " + value.getName());
        }
    }
}