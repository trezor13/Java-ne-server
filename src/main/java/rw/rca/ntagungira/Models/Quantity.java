package rw.rca.ntagungira.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    @JsonManagedReference
    private Product product;
    private int quantity;
    private String operation;
    private Date date;
}
