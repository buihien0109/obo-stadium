package vn.techmaster.obo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileReq {
    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Điện thoại không hợp lệ")
    private String phone;

    @NotNull(message = "Họ tên trống")
    @NotEmpty(message = "Họ tên trống")
    @JsonProperty("full_name")
    private String fullName;

    private String address;
}
