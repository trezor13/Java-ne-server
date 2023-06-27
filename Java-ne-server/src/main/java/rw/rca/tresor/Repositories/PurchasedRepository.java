package rw.rca.tresor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.tresor.Models.Purchased;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, String> {

}
