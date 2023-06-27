package rw.rca.ntagungira.Pojos.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateProduct {
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String price;
}
