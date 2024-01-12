package vn.techmaster.obo.service.impl;

import vn.techmaster.obo.entity.Category;
import vn.techmaster.obo.exception.BadRequestException;
import vn.techmaster.obo.exception.InternalServerException;
import vn.techmaster.obo.exception.NotFoundException;
import vn.techmaster.obo.model.dto.CategoryInfo;
import vn.techmaster.obo.model.request.CreateCategoryReq;
import vn.techmaster.obo.repository.CategoryRepository;
import vn.techmaster.obo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryInfo> getListCategoryAndProductCount() {
        return categoryRepository.getListCategoryAndProductCount();
    }

    @Override
    public Category createCategory(CreateCategoryReq req) {
        Category category = new Category();
        category.setName(req.getName());

        categoryRepository.save(category);

        return category;
    }

    @Override
    public void updateCategory(int id, CreateCategoryReq req) {
        // Check category exist
        Optional<Category> rs = categoryRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Category không tồn tại");
        }

        Category category = rs.get();
        category.setName(req.getName());

        try {
            categoryRepository.save(category);
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi chỉnh sửa category");
        }
    }

    @Override
    public void deleteCategory(int id) {
        // Check category exist
        Optional<Category> rs = categoryRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Category không tồn tại");
        }

        // Check product in category
        int count = categoryRepository.checkProductInCategory(id);
        if (count == 1) {
            throw new BadRequestException("Có sản phẩm thuộc category không thể xóa");
        }

        Category category = rs.get();

        try {
            categoryRepository.delete(category);
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi xóa category");
        }
    }
}
