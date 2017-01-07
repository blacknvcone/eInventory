package app.eInvent.eInventController;

/**
 * Created by blacknvc on 04/01/2017.
 */

import app.eInvent.eInventService.ServiceTransaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.xml.ws.RequestWrapper;
import java.awt.*;

@Controller
public class TransactionController {

    @Autowired
    private ServiceTransaction servTrans;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String index()
    {
        return "transactions/index";
    }


    @RequestMapping(value = "/transaction/submit", method = RequestMethod.POST)
    @ResponseBody
    public String save (@RequestParam JSONObject serialize)
    {
       // JSONObject jsO = serialize;
       // servTrans.addTrans(jsO);

        return ""+serialize;

    }


    //SaveTransaction
    //DeleteTransaction
    //UpdateTransaction


}
