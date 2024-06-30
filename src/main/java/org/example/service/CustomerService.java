package org.example.service;

import org.example.domain.AggregationType;
import org.example.domain.City;
import org.example.domain.Result;
import org.example.interfaces.AggregationInterface;
import org.example.interfaces.WeatherAPI;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class CustomerService {

    WeatherAPI weatherAPI = new WeatherService();
    // MapService returns the necessary implementation based on enum.
    private final Map<AggregationType, AggregationInterface> mapService = new HashMap<>();

    /*
    Method uses Completable future for parallel execution.
     */
    public List<Result> getTopThreeCityByType(AggregationType type, Set<String> cityIds) {
        Set<City> allCitiesByIds = weatherAPI.getAllCitiesByIds(cityIds);
        List<Result> resultList = allCitiesByIds
                .stream()
                .filter(city -> city.getPopulation() > 50_000)
                .map(city -> {
                    return CompletableFuture.supplyAsync(() ->
                            mapService.get(type).calculate(weatherAPI.getLastYearTemperature(city.getId()), city.getName()));
                })
                .map(CompletableFuture::join)
                .collect(Collectors.toList())
                .stream().sorted(Comparator.comparing(Result::getDailyTemp).reversed())
                .collect(Collectors.toList());

        return resultList.subList(0, Math.min(3, resultList.size()));
    }

    /*
    Method for updating service for different calculation. For adding new type of calculation need to create
    new Service which implements AggregationInterface and add it to Map with its ennum.
     */
    public void updateMap(AggregationType type,AggregationInterface aggregationInterface) {
        mapService.put(type,aggregationInterface);
    }
    public Map<AggregationType, AggregationInterface> getMapService() {
        return mapService;
    }

}
