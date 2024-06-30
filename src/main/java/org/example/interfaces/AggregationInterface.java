package org.example.interfaces;

import org.example.domain.DailyTemp;
import org.example.domain.Result;

import java.util.List;

/*
Interface for aggregation calculation
 */
public interface AggregationInterface {
    Result calculate(List<DailyTemp> list, String name);
}
