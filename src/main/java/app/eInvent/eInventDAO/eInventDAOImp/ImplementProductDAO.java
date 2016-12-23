package app.eInvent.eInventDAO.eInventDAOImp;

import app.eInvent.eInventDAO.ProductDAO;
import app.eInvent.eInventModel.Product;
import java.util.ArrayList;
import java.util.List;

public class ImplementProductDAO implements ProductDAO {

    private List<Product> arrayListProduct;

    public ImplementProductDAO() {
        arrayListProduct = new ArrayList<Product>();
    }

    @Override
    public void saveProduct(Product product) {
        product.setProductId(arrayListProduct.size() + 1L);
        arrayListProduct.add(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return arrayListProduct;
    }
}
