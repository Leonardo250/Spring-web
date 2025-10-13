package com.Leo.Project.services;

import com.Leo.Project.entities.Product;
import com.Leo.Project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository ;

    public List<Product> finall(){
        return repository.findAll();
    }

    public Product findByID(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
