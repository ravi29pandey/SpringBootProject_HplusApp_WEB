package com.test.hplus.restcontrollers;


import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller , now RestController does both (@Controller + @ResponseBody)
@RestController
public class ProductsRestController {
    @Autowired
    private ProductRepository productRepository;

    /*@GetMapping("/hplus/rest/products")
    @ResponseBody
    public List<Product> getProducts(){
        //call product repo to get data
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }*/
@GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name){
     List<Product> products =productRepository.searchByName(name);
return new ResponseEntity<>(products, HttpStatus.OK);
/*In order to bind Incoming  Request Parameter we have @RequestParam */
}

@GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductByPathVariable(@PathVariable("name") String name){
        List<Product> products =productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    /*In order to bind incoming path Variable Parameter we have @PathVariable */
    }

}






