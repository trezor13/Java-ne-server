package rw.rca.ntagungira.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.rca.ntagungira.Models.Product;
import rw.rca.ntagungira.Models.Quantity;
import rw.rca.ntagungira.Pojos.Request.CreateProduct;
import rw.rca.ntagungira.Pojos.Request.CreateQuantity;
import rw.rca.ntagungira.Services.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product createProduct(@Valid @RequestBody CreateProduct product){
        return productService.createProduct(product);
    }

    @PostMapping("/quantity")
    public Quantity createQuantity(@Valid @RequestBody CreateQuantity quantity){
        return productService.createQuantity(quantity);
    }
}
