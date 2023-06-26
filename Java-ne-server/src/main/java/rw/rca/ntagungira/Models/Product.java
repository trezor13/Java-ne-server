package rw.rca.ntagungira.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;
    private String name;
    private String type;
    private String price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private Quantity quantity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;
}
