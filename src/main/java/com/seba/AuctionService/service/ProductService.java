package com.seba.AuctionService.service;

import com.seba.AuctionService.entities.product.Product;
import com.seba.AuctionService.repository.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductService {

    @Autowired
    ProductInterface productInterface;

    public List<Product> findAll(){
        return productInterface.findAll();
    }

    public Product findByID(long id){
        return productInterface.findById(id);
    }


    public void save(Product product){
        productInterface.save(product);
    }


}
