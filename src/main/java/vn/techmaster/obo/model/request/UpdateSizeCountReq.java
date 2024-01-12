package vn.techmaster.obo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateSizeCountReq {
    private int size;

    @Min(0)
    private int count;

    @NotEmpty(message = "Mã sản phẩm trống")
    @NotNull(message = "Mã sản phẩm trống")
    @JsonProperty("product_id")
    private String productId;
}
