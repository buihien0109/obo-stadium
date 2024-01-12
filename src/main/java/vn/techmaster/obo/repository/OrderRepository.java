package vn.techmaster.obo.repository;

import vn.techmaster.obo.entity.Order;
import vn.techmaster.obo.model.dto.OrderDetailDto;
import vn.techmaster.obo.model.dto.OrderInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true, name = "getListOrderOfPersonByStatus")
    public List<OrderInfoDto> getListOrderOfPersonByStatus(int status, long userId);

    @Query(nativeQuery = true, name = "userGetDetailById")
    public OrderDetailDto userGetDetailById(long id, long userId);

    public int countByProductId(String id);

    @Query(nativeQuery = true, value = "SELECT * FROM orders " +
            "WHERE id LIKE ?1 AND receiver_name LIKE CONCAT('%',?2,'%') " +
            "AND receiver_phone LIKE CONCAT('%',?3,'%') AND status LIKE ?4 " +
            "AND product_id LIKE ?5")
    public Page<Order> adminGetListOrder(String id, String name, String phone, String status, String product, Pageable page);
}
