package app.eInvent.eInventDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import app.eInvent.eInventModel.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

}
