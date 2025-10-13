package com.Leo.Project.repositories;

import com.Leo.Project.entities.Category;
import com.Leo.Project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
