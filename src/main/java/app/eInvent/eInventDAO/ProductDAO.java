package app.eInvent.eInventDAO;
import app.eInvent.eInventModel.Product;
import java.util.List;

public interface ProductDAO {
    public void saveProduct(Product product);
    public List<Product> getAllProduct();
}
