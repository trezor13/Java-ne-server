package rw.rca.ntagungira.Pojos.Request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;
}
