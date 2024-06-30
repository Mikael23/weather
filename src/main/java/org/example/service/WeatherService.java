package org.example.service;

import org.example.domain.City;
import org.example.domain.DailyTemp;
import org.example.interfaces.WeatherAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherService implements WeatherAPI {

    @Override
    public Set<City> getAllCitiesByIds(Set<String> cityIds) {
        Set<City> cities = new HashSet<>();
        return cities;
    }

    @Override
    public List<DailyTemp> getLastYearTemperature(String cityId) {
        List<DailyTemp> listOfWeather = new ArrayList<>();
        return listOfWeather;
    }
}
