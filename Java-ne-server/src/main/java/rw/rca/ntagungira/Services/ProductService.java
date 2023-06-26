package rw.rca.ntagungira.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.ntagungira.Models.Product;
import rw.rca.ntagungira.Models.Quantity;
import rw.rca.ntagungira.Pojos.Request.CreateProduct;
import rw.rca.ntagungira.Pojos.Request.CreateQuantity;
import rw.rca.ntagungira.Repositories.ProductRepository;
import rw.rca.ntagungira.Repositories.QuantityRepository;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private QuantityRepository quantityRepository;


    public Product createProduct(CreateProduct product){
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setType(product.getType());
        return productRepository.save(newProduct);
    }

    public Product getProductByCode(Integer code){
        //UUID uuid = UUID.fromString(code);
        return productRepository.findDistinctByCode(code);
    }

    public Quantity createQuantity(CreateQuantity quantity){
        Product product = getProductByCode(quantity.getProductCode());
        System.out.println(product.getCode());
        Quantity newQuantity = new Quantity();
        newQuantity.setProduct(product);
        newQuantity.setQuantity(quantity.getQuantity());
        newQuantity.setOperation("ADD");
        product.setQuantity(newQuantity);
        return productRepository.save(product).getQuantity();
    }


}
