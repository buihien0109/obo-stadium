package vn.techmaster.obo.model.mapper;

import vn.techmaster.obo.entity.Promotion;
import vn.techmaster.obo.model.request.CreatePromotionReq;
import static vn.techmaster.obo.config.Constant.*;

public class PromotionMapper {
    public static Promotion toProduct(CreatePromotionReq req) {
        Promotion promotion = new Promotion();
        promotion.setCouponCode(req.getCode());
        promotion.setName(req.getName());
        promotion.setExpiredAt(req.getExpiredDate());
        promotion.setActive(req.isActive());
        promotion.setPublic(req.isPublic());
        promotion.setDiscountType(req.getDiscountType());
        promotion.setDiscountValue(req.getDiscountValue());
        if (req.getDiscountType() == DISCOUNT_PERCENT) {
            promotion.setMaximumDiscountValue(req.getMaxValue());
        } else {
            promotion.setMaximumDiscountValue(req.getDiscountValue());
        }

        return promotion;
    }
}
