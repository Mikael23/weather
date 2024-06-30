package org.example.domain;

import java.util.Date;

public class DailyTemp {
    private final Date date;
    private final double temperature;

    public DailyTemp(Date date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }
}
