package vn.techmaster.obo.model.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandReq {
    @NotNull(message = "Tên nhãn hiệu trống")
    @NotEmpty(message = "Tên nhãn hiệu trống")
    @Size(min = 1, max = 255, message = "Độ dài tên nhãn hiệu từ 1 - 255 ký tự")
    private String name;

    @NotNull(message = "Logo trống")
    @NotEmpty(message = "Logo trống")
    private String thumbnail;
}
