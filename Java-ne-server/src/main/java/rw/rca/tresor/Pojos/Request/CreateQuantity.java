package rw.rca.tresor.Pojos.Request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateQuantity {
    @NotNull
    private Integer productCode;
    @NotNull
    private Integer quantity;
    private String operation;
}
