package com.winsen.demo.repository;

import com.winsen.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductRepository {

    Product findById(String id);

    List<Product> getLimit(int limit);

}
