package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wyb on 2018/9/6.
 */
@Mapper
public interface ProductDao {

    List<Product> getAllProduct();

}
