package app.eInvent;
import app.eInvent.eInventDAO.ProductDAO;
import app.eInvent.eInventDAO.eInventDAOImp.ImplementProductDAO;

/**
 * Created by ibnua on 12/22/2016.
 */
public class AppContainer {
    private static AppContainer instance = null;
    private ProductDAO productDAO;

    public AppContainer() {
        initDAO();
    }

    public static AppContainer getInstance() {
        if(instance == null)
            instance = new AppContainer();
        return instance;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    private void initDAO() {
        productDAO = new ImplementProductDAO();
    }
}
