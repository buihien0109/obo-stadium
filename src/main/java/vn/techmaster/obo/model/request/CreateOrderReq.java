package vn.techmaster.obo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderReq {
    @NotNull(message = "Sản phẩm trống")
    @NotEmpty(message = "Sản phẩm trống")
    @JsonProperty("product_id")
    private String productId;

    @Min(value = 35)
    @Max(value = 42)
    private int size;

    @NotNull(message = "Họ tên trống")
    @NotEmpty(message = "Họ tên trống")
    @JsonProperty("receiver_name")
    private String receiverName;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Điện thoại không hợp lệ")
    @JsonProperty("receiver_phone")
    private String receiverPhone;

    @NotNull(message = "Địa chỉ trống")
    @NotEmpty(message = "Địa chỉ trống")
    @JsonProperty("receiver_address")
    private String receiverAddress;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("total_price")
    private long totalPrice;

    @JsonProperty("product_price")
    private long productPrice;

    private String note;
}
