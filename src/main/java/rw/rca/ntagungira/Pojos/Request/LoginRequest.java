package rw.rca.ntagungira.Pojos.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String username;
    @NotNull
    private String password;
}
