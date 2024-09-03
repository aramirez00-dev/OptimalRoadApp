package com.oneinfo.optimalroadapp.service;

import com.oneinfo.optimalroadapp.entity.Station;
import com.oneinfo.optimalroadapp.exception.ValidationException;
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

        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Todos los campos son obligatorios");
        }

        if (id <= 0 || id.getClass() != Long.class) {
            throw new ValidationException("El ID de la estación debe ser un número entero positivo");
        }

        if (stationRepository.findAll().containsKey(id)) {
            throw new ValidationException("El ID de la estación no debe ser repetido");
        }

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