package rw.rca.tresor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.tresor.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findDistinctByCode(Integer code);
}
