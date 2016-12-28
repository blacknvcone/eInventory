package app.eInvent.eInventController;
import app.eInvent.eInventModel.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/product/submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute Product product) {
        if (serviceProduct.update(product)) {
        } else {serviceProduct.add(product);}
        return "redirect:/product/list-product";
    }
    /*
    	@RequestMapping(value = "/bidang/input", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("bidang", new Bidang());
		return "/bidang/bidang-input";
	}

	@RequestMapping(value = "/bidang/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		Bidang bidang = serviceBidang.getById(Long.parseLong(id));
		model.addAttribute("bidang", bidang);
		return "/bidang/bidang-edit";
	}

	@RequestMapping(value = "/bidang/save", method = RequestMethod.POST)
	public String submit(@ModelAttribute Bidang bidang) {
		if(serviceBidang.update(bidang)){}
		else{serviceBidang.save(bidang);}
		return "redirect:/bidang/list";
	}
     */

//    /**
//     * Digunakan untuk melakukan request mapping pada http://localhost:8090/form-insert pada menu aside
//     * @return view(/resource/templates/product/insert)
//     */
//    @RequestMapping(value = "/product/form-insert", method = RequestMethod.GET)
//    public String formInsert(Model model) {
//        model.addAttribute("product", new Product());
//        return "product/insert";
//    }
//
//    /**
//     * Digunakan untuk melakukan request mapping http://localhost:8090/product/submit pada form submit
//     * @param product
//     * @return
//     */
//    @RequestMapping(value = "/product/submit", method = RequestMethod.POST)
//    public String submit(@ModelAttribute Product product) {
//        AppContainer.getInstance().getProductDAO().saveProduct(product);
//        return "redirect:/product/list-product";
//    }
}
