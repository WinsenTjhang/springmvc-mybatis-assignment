package com.winsen.demo.repository;

import com.winsen.demo.model.ProductSales;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticRepository {

    List<ProductSales> getProductSalesSortedByQuantity();

}
