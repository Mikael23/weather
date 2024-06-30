package org.example.domain;

import org.example.domain.DailyTemp;

public class Result {
    private String cityName;

    private Double dailyTemp;
    public Result(String cityName, Double dailyTemp) {
        this.cityName = cityName;
        this.dailyTemp = dailyTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public Double getDailyTemp() {
        return dailyTemp;
    }
}
