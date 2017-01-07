package app.eInvent.eInventDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import app.eInvent.eInventModel.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long>{
    @Query(value = "SELECT * FROM PRODUCT WHERE product_name LIKE ?1%", nativeQuery = true)
    List<Product> findByProductNameContaining(String productName);
}
