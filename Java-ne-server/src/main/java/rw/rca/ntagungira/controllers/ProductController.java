package rw.rca.ntagungira.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.ntagungira.Models.Cart;
import rw.rca.ntagungira.Models.Product;
import rw.rca.ntagungira.Models.Purchased;
import rw.rca.ntagungira.Models.Quantity;
import rw.rca.ntagungira.Pojos.Request.CreateProduct;
import rw.rca.ntagungira.Pojos.Request.CreateQuantity;
import rw.rca.ntagungira.Services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @ModelAttribute("cart")
//    public Cart getCart() {
//        return new Cart(); // Create a new cart for each user session
//    }
    
    @PostMapping("/add")
    public Product createProduct(@Valid @RequestBody CreateProduct product){
        return productService.createProduct(product);
    }

    @PostMapping("/quantity")
    public Quantity createQuantity(@Valid @RequestBody CreateQuantity quantity){
        return productService.createQuantity(quantity);
    }


    @GetMapping("/all")
    public Iterable<Product> getAllProducts(HttpServletRequest req){
        //System.out.println(req.getHeader("Authorization"));
        return productService.getAllProducts();
    }


//    @PostMapping("/cart/add")
//    public ResponseEntity<?> addToCart(
//            @RequestParam("productId") String productId,
//            @RequestParam("quantity") int quantity,
//            @ModelAttribute("cart") Cart cart) {
//        cart.addItem(productId, quantity);
//        return new ResponseEntity<>(cart.getItems(), HttpStatus.OK);
//    }


//    @GetMapping("/cart/items")
//    public ResponseEntity<Map<String, Integer>> getCartItems(@ModelAttribute("cart") Cart cart) {
//        Map<String, Integer> items = cart.getItems();
//        return new ResponseEntity<>(items, HttpStatus.OK);
//    }


    @PostMapping("/purchase")
    public ResponseEntity<List<Purchased>> purchase(Map<String, Integer> cart) {
        List<Purchased> purchased = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();
            Purchased product = productService.purchase(productId, quantity);
            purchased.add(product);
        }
        return new ResponseEntity<>(purchased, HttpStatus.OK);
    }
}
