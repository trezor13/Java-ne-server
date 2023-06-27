package rw.rca.ntagungira.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Purchased")
@Data
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int quantity;
    private double total;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
}
