package app.eInvent.eInventController;
import app.eInvent.eInventModel.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.eInvent.eInventService.ServiceProduct;

@Controller
public class ProductControllers {

    @Autowired
    ServiceProduct serviceProduct;


    /**
     * Digunakan untuk melakukan request mapping pada http://localhost:8090/product pada menu aside
     * @return view (/resource/templates/product/index)
     */
    @RequestMapping(value = "/product/list-product", method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("listProduct",serviceProduct.getAllProduct());
        return "product/index";
    }

    @RequestMapping(value = "/product/form-insert", method = RequestMethod.GET)
    public String formInsert(Model model){
        model.addAttribute("product", new Product());
        return "product/insert";
    }

    @RequestMapping(value = "/product/edit-product/{id}", method = RequestMethod.GET)
    public String formEdit(@PathVariable String id,Model model){
        Product pro = serviceProduct.getProductById(Long.parseLong(id));
        model.addAttribute("product",pro);
        return "product/edit";
    }

    @RequestMapping(value = "/product/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute Product product) {
        if (serviceProduct.update(product)) {
        } else {serviceProduct.add(product);}
        return "redirect:/product/list-product";


    }

    @RequestMapping(value = "/product/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable String id){
        Product pro = serviceProduct.getProductById(Long.parseLong(id));
        serviceProduct.deleteProduct(pro.getProductId());
        return "redirect:/product/list-product";
    }

}
