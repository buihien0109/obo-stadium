package vn.techmaster.obo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStatusOrderReq {
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

    private String note;

    private int status;
}
