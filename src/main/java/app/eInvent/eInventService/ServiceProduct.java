package app.eInvent.eInventService;

/**
 * Created by blacknvc on 28/12/2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.eInvent.eInventDAO.ProductDAO;
import app.eInvent.eInventModel.Product;

import java.util.List;

@Service
public class ServiceProduct {

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
}
