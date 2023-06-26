package rw.rca.ntagungira.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.ntagungira.Models.Purchased;

import java.util.UUID;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, String> {

}
