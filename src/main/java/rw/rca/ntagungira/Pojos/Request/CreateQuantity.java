package rw.rca.ntagungira.Pojos.Request;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateQuantity {
    @NotNull
    private Integer productCode;
    @NotNull
    private Integer quantity;
    private String operation;
}
