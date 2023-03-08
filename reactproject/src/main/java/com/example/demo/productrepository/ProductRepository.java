package com.example.demo.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.product.product;
@Repository
public interface ProductRepository extends JpaRepository<product,Integer> {

}
