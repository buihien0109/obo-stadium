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
public class CreateCategoryReq {
    @NotNull(message = "Tên category trống")
    @NotEmpty(message = "Tên category trống")
    @Size(min = 1, max = 300, message = "Độ dài tên category từ 1 - 300 ký tự")
    private String name;
}
