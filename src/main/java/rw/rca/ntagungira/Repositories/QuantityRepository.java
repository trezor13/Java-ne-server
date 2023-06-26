package rw.rca.ntagungira.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.ntagungira.Models.Quantity;

import java.util.UUID;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
}
