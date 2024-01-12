package vn.techmaster.obo.service;

import vn.techmaster.obo.entity.Brand;
import vn.techmaster.obo.model.dto.BrandInfo;
import vn.techmaster.obo.model.request.CreateBrandReq;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BrandService {
    public List<Brand> getListBrand();

    public List<BrandInfo> getListBrandAndProductCount();

    public Brand createBrand(CreateBrandReq req);

    public void updateBrand(int id, CreateBrandReq req);

    public void deleteBrand(int id);
}
