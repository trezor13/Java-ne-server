package rw.rca.ntagungira.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.ntagungira.Models.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findDistinctByCode(Integer code);
}
