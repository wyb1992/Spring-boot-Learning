package com.example.demo.service;

import com.example.demo.mapper.ProductDao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyb on 2018/9/6.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }


}



