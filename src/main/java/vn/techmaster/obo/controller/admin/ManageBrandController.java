package vn.techmaster.obo.controller.admin;

import jakarta.validation.Valid;
import vn.techmaster.obo.entity.Brand;
import vn.techmaster.obo.entity.User;
import vn.techmaster.obo.model.dto.BrandInfo;
import vn.techmaster.obo.model.request.CreateBrandReq;
import vn.techmaster.obo.security.CustomUserDetails;
import vn.techmaster.obo.service.BrandService;
import vn.techmaster.obo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageBrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/admin/brands")
    public String getPostManagePage(Model model) {
        // Get list image of user
        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        List<String> images = imageService.getListImageOfUser(user.getId());
        model.addAttribute("images", images);

        List<BrandInfo> brands = brandService.getListBrandAndProductCount();
        model.addAttribute("brands", brands);

        return "admin/brand/list";
    }

    @PostMapping("/api/admin/brands")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateBrandReq req) {
        Brand brand = brandService.createBrand(req);

        return ResponseEntity.ok(brand);
    }

    @PutMapping("/api/admin/brands/{id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody CreateBrandReq req, @PathVariable int id) {
        brandService.updateBrand(id, req);

        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/brands/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        brandService.deleteBrand(id);

        return ResponseEntity.ok("Xóa thành công");
    }
}
