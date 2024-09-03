package com.oneinfo.optimalroadapp.repository;

import com.oneinfo.optimalroadapp.entity.Road;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoadRepository {
    private Map<Long, Road> roads = new HashMap<>();

    public void save(Road road) {
        roads.put(road.getId(), road);
    }

    public Road findById(Long id) {
        return roads.get(id);
    }

    public Map<Long, Road> findAll() {
        return roads;
    }

    public void deleteAll() {
        roads.clear();
    }
}