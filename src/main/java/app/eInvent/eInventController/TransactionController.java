package app.eInvent.eInventController;

import app.eInvent.eInventModel.Product;
import app.eInvent.eInventModel.Transaction;
import app.eInvent.eInventPayload.TransactionPayload;
import app.eInvent.eInventService.ServiceProduct;
import app.eInvent.eInventService.ServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;


@Controller
public class TransactionController {

    private Logger logger = Logger.getLogger(TransactionController.class);

    @Autowired
    private ServiceTransaction serviceTransaction;
    @Autowired
    private ServiceProduct serviceProduct;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String index()
    {
        return "transactions/index";
    }

    @RequestMapping(value = "/transaction/submit", method = RequestMethod.POST)
    @ResponseBody
    public String JSONParse(@RequestBody TransactionPayload transactionPayload)
    {
        //Simpan Transaksi
        TransactionManagement(transactionPayload);

        //Update Stock
        for (Product product : transactionPayload.getItemData()){
            ProductManagement(product.getProductId(), product.getProductQuantity());
        }
        return "Success";
    };


    /**
     * Digunakan untuk melakukan submit pada table transaksi
     * @param transactionPayload
     */
    private void TransactionManagement(TransactionPayload transactionPayload)
    {
        for (Product product : transactionPayload.getItemData()){
            Transaction transaction = new Transaction();
            transaction.setSalesName(transactionPayload.getSalesName());
            transaction.setDateField(transactionPayload.getTransactionDate());
            transaction.setProductId(product.getProductId());
            transaction.setTotalItem(product.getProductQuantity());
            serviceTransaction.add(transaction);
        }


    }


    /**
     * Digunakan untuk melakukan update pada product pasca pembelian
     * @param productId
     * @param productQuantity
     */
    private void ProductManagement(Long productId, int productQuantity)
    {
        System.out.println(productId);
        Product product     =  serviceProduct.getProductById(productId);

        int oldStock    = product.getProductStock();
        int newStock    = oldStock - productQuantity;
        product.setProductStock(newStock);
        serviceProduct.update(product);
    }

    /**
     * Melihat Daftar Transaksi
     */
    @RequestMapping(value = "/transaction/list",method = RequestMethod.GET)
    public String TransactionList(Model model) {
        model.addAttribute("daftar_trans",serviceTransaction.getAllTransaction());

        return "transactions/list";
    }


}
