package vn.techmaster.obo.service;

import vn.techmaster.obo.entity.Category;
import vn.techmaster.obo.model.dto.CategoryInfo;
import vn.techmaster.obo.model.request.CreateCategoryReq;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryService {
    public List<Category> getListCategory();

    public List<CategoryInfo> getListCategoryAndProductCount();

    public Category createCategory(CreateCategoryReq req);

    public void updateCategory(int id, CreateCategoryReq req);

    public void deleteCategory(int id);
}
