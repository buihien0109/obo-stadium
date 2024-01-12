package vn.techmaster.obo.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandInfo {
    private int id;

    private String name;

    private String thumbnail;

    private int productCount;
}

