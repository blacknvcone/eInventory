package app.eInvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductControllers {

    /**
     * Digunakan untuk melakukan request mapping pada http://localhost:8090/product
     * @return view (/resource/templates/product/index)
     */
    @RequestMapping("/product")
    public String listProduct() {
        return "product/index";
    }
}
