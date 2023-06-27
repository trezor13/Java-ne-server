package rw.rca.tresor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.tresor.Models.Quantity;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
}
