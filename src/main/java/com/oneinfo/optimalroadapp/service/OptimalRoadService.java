package com.oneinfo.optimalroadapp.service;
import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.repository.RoadRepository;
import com.oneinfo.optimalroadapp.repository.StationRepository;
import com.oneinfo.optimalroadapp.utils.Node;
import com.oneinfo.optimalroadapp.utils.OptimalRoad;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class OptimalRoadService {

    private static final Logger logger = Logger.getLogger(OptimalRoadService.class.getName());

    private final RoadRepository roadRepository;
    private final StationRepository stationRepository;

    public OptimalRoadService(RoadRepository roadRepository, StationRepository stationRepository) {
        this.roadRepository = roadRepository;
        this.stationRepository = stationRepository;
    }

    public OptimalRoad findOptimalRoad(Long sourceId, Long destinationId) {
        // algoritmo con asistencia de nodo Node y clase Optimal Road para buscar la mejor ruta
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getCost));
        Map<Long, Double> minCost = new HashMap<>();
        Map<Long, Long> previousStation = new HashMap<>();
        Set<Long> visited = new HashSet<>();

        // Incializo la prioridad de cola
        priorityQueue.add(new Node(sourceId, 0));
        minCost.put(sourceId, 0.0);

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            Long currentStation = currentNode.getStationId();
            double currentCost = currentNode.getCost();

            if (visited.contains(currentStation)) {
                continue;
            }
            visited.add(currentStation);

            // Si ya encontré el destino, finalizar búsqueda
            if (currentStation.equals(destinationId)) {
                break;
            }

            // Verifico qué conexiones llegan a destino
            for (Road road : roadRepository.findAll().values()) {
                if (road.getSourceId().equals(currentStation)) {
                    Long adjacentStation = road.getDestinationId();
                    double newCost = currentCost + road.getCost();

                    if (!minCost.containsKey(adjacentStation) || newCost < minCost.get(adjacentStation)) {
                        minCost.put(adjacentStation, newCost);
                        previousStation.put(adjacentStation, currentStation);
                        priorityQueue.add(new Node(adjacentStation, newCost));
                    }
                }
            }
        }

        // Si el destino nunca fue encontrado
        if (!minCost.containsKey(destinationId)) {
            return new OptimalRoad(Collections.emptyList(), Double.POSITIVE_INFINITY);
        }

        // Backtracking
        List<Long> optimalPath = new LinkedList<>();
        Long step = destinationId;
        while (step != null) {
            optimalPath.add(0, step);
            step = previousStation.get(step);
        }

        // Verifico que el path inicie con el id de origen
        if (!optimalPath.get(0).equals(sourceId)) {
            return new OptimalRoad(Collections.emptyList(), Double.POSITIVE_INFINITY);
        }

        return new OptimalRoad(optimalPath, minCost.get(destinationId));
    }



}
