package com.oneinfo.optimalroadapp.repository;

import com.oneinfo.optimalroadapp.entity.Station;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StationRepository {
    private Map<Long, Station> stations = new HashMap<>();

    public void save(Station station) {
        stations.put(station.getId(), station);
    }

    public Station findById(Long id) {
        return stations.get(id);
    }

    public Map<Long, Station> findAll() {
        return stations;
    }

    public void deleteAll() {
        stations.clear();
    }
}