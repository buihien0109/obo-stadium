package vn.techmaster.obo.repository;

import vn.techmaster.obo.entity.Brand;
import vn.techmaster.obo.model.dto.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(nativeQuery = true, name = "getListBrandAndProductCount")
    public List<BrandInfo> getListBrandAndProductCount();
}
