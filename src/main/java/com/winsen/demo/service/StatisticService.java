package com.winsen.demo.service;

import com.winsen.demo.model.ProductSales;
import com.winsen.demo.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<ProductSales> getProductSalesSortedByQuantity(){
        return statisticRepository.getProductSalesSortedByQuantity();
    }
}
