package app.eInvent.eInventController;
import app.eInvent.AppContainer;
import app.eInvent.eInventModel.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductControllers {

    /**
     * Digunakan untuk melakukan request mapping pada http://localhost:8090/product pada menu aside
     * @return view (/resource/templates/product/index)
     */
    @RequestMapping(value = "/product/list-product", method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("listProduct", AppContainer.getInstance().getProductDAO().getAllProduct());
        return "product/index";
    }

    /**
     * Digunakan untuk melakukan request mapping pada http://localhost:8090/form-insert pada menu aside
     * @return view(/resource/templates/product/insert)
     */
    @RequestMapping(value = "/product/form-insert", method = RequestMethod.GET)
    public String formInsert(Model model) {
        model.addAttribute("product", new Product());
        return "product/insert";
    }

    /**
     * Digunakan untuk melakukan request mapping http://localhost:8090/product/submit pada form submit
     * @param product
     * @return
     */
    @RequestMapping(value = "/product/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute Product product) {
        AppContainer.getInstance().getProductDAO().saveProduct(product);
        return "redirect:/product/list-product";
    }
}
