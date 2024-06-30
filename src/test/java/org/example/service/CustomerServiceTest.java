package org.example.service;

import org.example.domain.AggregationType;
import org.example.interfaces.AggregationInterface;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

CustomerService customerService = new CustomerService();

    @Test
    public void testToGetServiceFromMap(){
        customerService.updateMap(AggregationType.AVG,new AggregationAverageService());
        AggregationAverageService aggregationInterface = (AggregationAverageService) customerService.getMapService().get(AggregationType.AVG);
    }
}