package org.example.interfaces;

import org.example.domain.City;
import org.example.domain.DailyTemp;

import java.util.List;
import java.util.Set;

public interface WeatherAPI {
    public Set<City>getAllCitiesByIds(Set<String> cityIds);
    List<DailyTemp> getLastYearTemperature(String cityId);
}
