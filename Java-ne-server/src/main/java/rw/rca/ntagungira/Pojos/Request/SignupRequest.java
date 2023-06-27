package rw.rca.ntagungira.Pojos.Request;

import javax.validation.constraints.*;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Length(min = 10, max = 10)
    private String phone;
    @NotBlank
    private String password;
    Set<String> role;
}
