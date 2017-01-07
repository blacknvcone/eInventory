package app.eInvent.eInventService;

/**
 * Created by blacknvc on 28/12/2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.eInvent.eInventDAO.ProductDAO;
import app.eInvent.eInventModel.Product;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProduct {

    List<Product> data = new ArrayList<Product>();

    @Autowired
    private ProductDAO daoProduct;

    //Constructor
    public ProductDAO getDao(){return daoProduct;}

    //Add Product
    public void add(Product pro){daoProduct.save(pro);}

    //Edit Product
    public boolean update(Product pro){
        Product tgtProduct = daoProduct.findOne(pro.getProductId());
        if(tgtProduct != null){
            tgtProduct.setProductId(pro.getProductId());
            tgtProduct.setProductName(pro.getProductName());
            tgtProduct.setProductPrice(pro.getProductPrice());
            tgtProduct.setProductStock(pro.getProductStock());

            daoProduct.save(tgtProduct);
            return true;
        }else{
            return false;
        }
    }

    //Update Stock Product
    public boolean editStock(Long id,int cnt){
        Product tgtProduct = daoProduct.getOne(id);

        int oldStock = tgtProduct.getProductStock();
        int newStock = oldStock - cnt;

        if(tgtProduct != null){
            tgtProduct.setProductId(tgtProduct.getProductId());
            tgtProduct.setProductName(tgtProduct.getProductName());
            tgtProduct.setProductPrice(tgtProduct.getProductPrice());
            tgtProduct.setProductStock(newStock);

            daoProduct.save(tgtProduct);
            return true;
        }else{
            return false;
        }

    }

    //Get All Product
    public List<Product> getAllProduct(){
        return daoProduct.findAll();
    }

    //Fetch By Id
    public Product getProductById(Long proId){
        return daoProduct.findOne(proId);
    }

    //Delete By Id
    public void deleteProduct(Long proId){
        daoProduct.delete(proId);
    }

    public List<Product> getListProduct(String productName) {
        return daoProduct.findByProductNameContaining(productName);
    }

}
