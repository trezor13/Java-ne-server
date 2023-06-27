package rw.rca.tresor.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    @JsonBackReference
    private Product product;

    private int quantity;
    private String operation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date=new Date();
}
