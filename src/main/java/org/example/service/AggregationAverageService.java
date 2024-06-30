package org.example.service;

import org.example.domain.DailyTemp;
import org.example.domain.Result;
import org.example.interfaces.AggregationInterface;

import java.util.List;

/*
Service for calculation average temperature
 */
public class AggregationAverageService implements AggregationInterface {
    @Override
    public Result calculate(List<DailyTemp> list, String name) {
        return new Result(name, list.stream().mapToDouble(DailyTemp::getTemperature).average().orElse(0.0));
    }
}
